package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.service.ConstructionCrewService;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.transfer.CityServiceDto;
import ru.ervelus.rest.transfer.ConstructionCrewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/model/{model}/crew")
@RequiredArgsConstructor
public class ConstructionCrewController extends AbstractController {
    private final ConstructionCrewService constructionCrewService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConstructionCrewDto> getById(@PathVariable Long model,
                                                  @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(constructionCrewService.findById(id, model), ConstructionCrewDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<ConstructionCrewDto>> getAll(@PathVariable Long model) {
        return ResponseEntity.ok(constructionCrewService.findAll(model).stream()
                .map(e -> conversionService.convert(e, ConstructionCrewDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long model,
                                  @RequestBody ConstructionCrewDto dto) {
        dto.setModelId(model);
        constructionCrewService.save(conversionService.convert(dto, ConstructionCrewEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        constructionCrewService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody ConstructionCrewDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        constructionCrewService.save(conversionService.convert(dto, ConstructionCrewEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }
}
