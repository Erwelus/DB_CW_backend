package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.service.RouteService;
import com.example.db_cw_backend.transfer.RouteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/route/")
public class RouteController {
    private final RouteService routeService;
    private final ConversionService conversionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RouteDto> getById(@PathVariable Long model,
                                              @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(routeService.findById(id, model), RouteDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<RouteDto>> getAll(@PathVariable Long model) {
        return ResponseEntity.ok(routeService.findAll(model).stream()
                .map(e -> conversionService.convert(e, RouteDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long model,
                                  @RequestBody RouteDto dto) {
        dto.setModelId(model);
        routeService.save(conversionService.convert(dto, RouteEntity.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        routeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody RouteDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        routeService.save(conversionService.convert(dto, RouteEntity.class));
        return ResponseEntity.ok().build();
    }
}
