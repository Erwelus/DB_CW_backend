package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.service.ConstructionCrewService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
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
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        constructionCrewService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody ConstructionCrewDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        constructionCrewService.save(conversionService.convert(dto, ConstructionCrewEntity.class));
        return ResponseEntity.ok().build();
    }
}
