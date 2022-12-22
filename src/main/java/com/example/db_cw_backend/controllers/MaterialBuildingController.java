package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.service.MaterialInBuildingService;
import com.example.db_cw_backend.transfer.MaterialInBuildingDto;
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

    @GetMapping()
    public ResponseEntity<List<MaterialInBuildingDto>> getAll() {
        return ResponseEntity.ok(materialInBuildingService.findAll().stream()
                .map(e -> conversionService.convert(e, MaterialInBuildingDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody MaterialInBuildingDto dto) {
        materialInBuildingService.save(conversionService.convert(dto, MaterialInBuilding.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        materialInBuildingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}