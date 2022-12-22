package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.service.ServiceTeamService;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/service/{service}/service_team")
public class ServiceTeamController extends AbstractController {
    private final ServiceTeamService serviceTeamService;
    private final ConversionService conversionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceTeamDto> getById(@PathVariable Long service,
                                            @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(serviceTeamService.findById(id, service), ServiceTeamDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<ServiceTeamDto>> getAll(@PathVariable Long service) {
        return ResponseEntity.ok(serviceTeamService.findAll(service).stream()
                .map(e -> conversionService.convert(e, ServiceTeamDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long service,
                                  @RequestBody ServiceTeamDto dto) {
        dto.setCityServiceId(service);
        serviceTeamService.save(conversionService.convert(dto, ServiceTeamEntity.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        serviceTeamService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long service,
                                        @PathVariable Long id,
                                        @RequestBody ServiceTeamDto dto) {
        dto.setId(id);
        dto.setCityServiceId(service);
        serviceTeamService.save(conversionService.convert(dto, ServiceTeamEntity.class));
        return ResponseEntity.ok().build();
    }
}