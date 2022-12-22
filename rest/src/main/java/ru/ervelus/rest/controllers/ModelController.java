package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.ModelEntity;
import ru.ervelus.rest.service.ModelService;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.transfer.BuildingDto;
import ru.ervelus.rest.transfer.ModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/model")
@RequiredArgsConstructor
public class ModelController extends AbstractController{
    private final ModelService modelService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ModelDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(modelService.findById(id), ModelDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<ModelDto>> getAll() {
        return ResponseEntity.ok(modelService.findAll().stream()
                .map(e -> conversionService.convert(e, ModelDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody ModelDto dto) {
        modelService.save(conversionService.convert(dto, ModelEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        modelService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ModelDto dto) {
        dto.setId(id);
        modelService.save(conversionService.convert(dto, ModelEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/cost")
    public ResponseEntity<Double> getCost(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.calculateCost(id));
    }

    @PostMapping(value = "/{id}/percent")
    public ResponseEntity<Double> getPercent(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.getPercentage(id));
    }

}
