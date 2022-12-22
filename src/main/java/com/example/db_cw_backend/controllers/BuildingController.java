package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.service.BuildingService;
import com.example.db_cw_backend.service.ModelService;
import com.example.db_cw_backend.transfer.BuildingDto;
import com.example.db_cw_backend.transfer.ModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;
    private final ConversionService conversionService;

    @GetMapping(value = "/{model}/{quarter}/{street}/{id}")
    public ResponseEntity<BuildingDto> getById(@PathVariable Long street,
                                               @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(buildingService.findById(id, street), BuildingDto.class));
    }

    @GetMapping(value = "/{model}/{quarter}/{street}")
    public ResponseEntity<List<BuildingDto>> getAll(@PathVariable Long street) {
        return ResponseEntity.ok(buildingService.findAll(street).stream()
                .map(e -> conversionService.convert(e, BuildingDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping(value = "/{model}/{quarter}/{street}")
    public ResponseEntity<?> save(@PathVariable Long street,
                                  @RequestBody BuildingDto dto) {
        dto.setStreetId(street);
        buildingService.save(conversionService.convert(dto, BuildingEntity.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{model}/{quarter}/{street}/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        buildingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{model}/{quarter}/{street}/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long street,
                                        @PathVariable Long id,
                                        @RequestBody BuildingDto dto) {
        dto.setId(id);
        dto.setStreetId(street);
        buildingService.save(conversionService.convert(dto, BuildingEntity.class));
        return ResponseEntity.ok().build();
    }
}
