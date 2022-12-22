package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.service.DeliveryServiceService;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/material/{material}/delivery")
public class DeliveryServiceController extends AbstractController {
    private final DeliveryServiceService deliveryServiceService;
    private final ConversionService conversionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeliveryServiceDto> getById(@PathVariable Long material,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(deliveryServiceService.findById(id, material), DeliveryServiceDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<DeliveryServiceDto>> getAll(@PathVariable Long material) {
        return ResponseEntity.ok(deliveryServiceService.findAll(material).stream()
                .map(e -> conversionService.convert(e, DeliveryServiceDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long material,
                                  @RequestBody DeliveryServiceDto dto) {
        dto.setMaterialId(material);
        deliveryServiceService.save(conversionService.convert(dto, DeliveryServiceEntity.class));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        deliveryServiceService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long material,
                                        @PathVariable Long id,
                                        @RequestBody DeliveryServiceDto dto) {
        dto.setId(id);
        dto.setMaterialId(material);
        deliveryServiceService.save(conversionService.convert(dto, DeliveryServiceEntity.class));
        return ResponseEntity.ok().build();
    }
}
