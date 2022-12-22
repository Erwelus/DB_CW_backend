package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.service.CityServiceService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/model/{model}/service")
@RequiredArgsConstructor
public class CityServiceController extends AbstractController {
    private final CityServiceService cityServiceService;
    private final ConversionService conversionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityServiceDto> getById(@PathVariable Long model,
                                               @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(cityServiceService.findById(id, model), CityServiceDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<CityServiceDto>> getAll(@PathVariable Long model) {
        return ResponseEntity.ok(cityServiceService.findAll(model).stream()
                .map(e -> conversionService.convert(e, CityServiceDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long model,
                                  @RequestBody CityServiceDto dto) {
        dto.setModelId(model);
        cityServiceService.save(conversionService.convert(dto, CityServiceEntity.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        cityServiceService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody CityServiceDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        cityServiceService.save(conversionService.convert(dto, CityServiceEntity.class));
        return ResponseEntity.ok().build();
    }
}
