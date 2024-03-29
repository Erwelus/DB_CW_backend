package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.service.DeliveryServiceService;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
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
    private final NotificationService notificationService;

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
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        deliveryServiceService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long material,
                                        @PathVariable Long id,
                                        @RequestBody DeliveryServiceDto dto) {
        dto.setId(id);
        dto.setMaterialId(material);
        deliveryServiceService.save(conversionService.convert(dto, DeliveryServiceEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }
}
