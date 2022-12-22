package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.service.BuildingService;
import com.example.db_cw_backend.service.ModelService;
import com.example.db_cw_backend.service.NotificationService;
import com.example.db_cw_backend.transfer.BuildingDto;
import com.example.db_cw_backend.transfer.ModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/model/{model}/quarter/{quarter}/street/{street}/building")
@RequiredArgsConstructor
public class BuildingController extends AbstractController {
    private final BuildingService buildingService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BuildingDto> getById(@PathVariable Long street,
                                               @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(buildingService.findById(id, street), BuildingDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<BuildingDto>> getAll(@PathVariable Long street) {
        return ResponseEntity.ok(buildingService.findAll(street).stream()
                .map(e -> conversionService.convert(e, BuildingDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long street,
                                  @RequestBody BuildingDto dto) {
        dto.setStreetId(street);
        buildingService.save(conversionService.convert(dto, BuildingEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        buildingService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long street,
                                        @PathVariable Long id,
                                        @RequestBody BuildingDto dto) {
        dto.setId(id);
        dto.setStreetId(street);
        buildingService.save(conversionService.convert(dto, BuildingEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/cost")
    public ResponseEntity<Double> getCost(@PathVariable Long street,
                                          @PathVariable Long id) {
        return ResponseEntity.ok(buildingService.calculateCost(buildingService.findById(id, street)));
    }
}
