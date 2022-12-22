package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.service.MaterialInBuildingService;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.transfer.MaterialInBuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/material_building")
public class MaterialBuildingController extends AbstractController {
    private final MaterialInBuildingService materialInBuildingService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping()
    public ResponseEntity<List<MaterialInBuildingDto>> getAll() {
        return ResponseEntity.ok(materialInBuildingService.findAll().stream()
                .map(e -> conversionService.convert(e, MaterialInBuildingDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody MaterialInBuildingDto dto) {
        materialInBuildingService.save(conversionService.convert(dto, MaterialInBuilding.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        materialInBuildingService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }
}