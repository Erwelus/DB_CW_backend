package ru.ervelus.rest.controllers;

import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.service.MaterialService;
import ru.ervelus.rest.service.NotificationService;
import ru.ervelus.rest.transfer.MaterialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/material")
public class MaterialController extends AbstractController {
    private final MaterialService materialService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaterialDto> getById(@PathVariable Long model,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(materialService.findById(id, model), MaterialDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<MaterialDto>> getAll(@PathVariable Long model) {
        return ResponseEntity.ok(materialService.findAll(model).stream()
                .map(e -> conversionService.convert(e, MaterialDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long model,
                                  @RequestBody MaterialDto dto) {
        dto.setModelId(model);
        materialService.save(conversionService.convert(dto, MaterialEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        materialService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody MaterialDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        materialService.save(conversionService.convert(dto, MaterialEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }
}