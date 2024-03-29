package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.service.StreetService;
import ru.ervelus.rest.transfer.StreetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/quarter/{quarter}/street")
public class StreetController extends AbstractController {
    private final StreetService streetService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StreetDto> getById(@PathVariable Long quarter,
                                                  @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(streetService.findById(id, quarter), StreetDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<StreetDto>> getAll(@PathVariable Long quarter) {
        return ResponseEntity.ok(streetService.findAll(quarter).stream()
                .map(e -> conversionService.convert(e, StreetDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long quarter,
                                  @RequestBody StreetDto dto) {
        dto.setQuarterId(quarter);
        streetService.save(conversionService.convert(dto, StreetEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        streetService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long quarter,
                                        @PathVariable Long id,
                                        @RequestBody StreetDto dto) {
        dto.setId(id);
        dto.setQuarterId(quarter);
        streetService.save(conversionService.convert(dto, StreetEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/cost")
    public ResponseEntity<Double> getCost(@PathVariable Long id) {
        return ResponseEntity.ok(streetService.calculateCost(id));
    }

    @PostMapping(value = "/{id}/percent")
    public ResponseEntity<Double> getPercent(@PathVariable Long id) {
        return ResponseEntity.ok(streetService.getPercentage(id));
    }
}
