package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.service.NotificationService;
import com.example.db_cw_backend.service.QuarterService;
import com.example.db_cw_backend.transfer.QuarterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/model/{model}/quarter")
public class QuarterController extends AbstractController {
    private final QuarterService quarterService;
    private final ConversionService conversionService;
    private final NotificationService notificationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuarterDto> getById(@PathVariable Long model,
                                               @PathVariable Long id) {
        return ResponseEntity.ok(conversionService.convert(quarterService.findById(id, model), QuarterDto.class));
    }

    @GetMapping()
    public ResponseEntity<List<QuarterDto>> getAll(@PathVariable Long model) {
        return ResponseEntity.ok(quarterService.findAll(model).stream()
                .map(e -> conversionService.convert(e, QuarterDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@PathVariable Long model,
                                  @RequestBody QuarterDto dto) {
        dto.setModelId(model);
        quarterService.save(conversionService.convert(dto, QuarterEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        quarterService.deleteById(id);
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long model,
                                        @PathVariable Long id,
                                        @RequestBody QuarterDto dto) {
        dto.setId(id);
        dto.setModelId(model);
        quarterService.save(conversionService.convert(dto, QuarterEntity.class));
        notificationService.sendNotification();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}/cost")
    public ResponseEntity<Double> getCost(@PathVariable Long id) {
        return ResponseEntity.ok(quarterService.calculateCost(id));
    }

    @PostMapping(value = "/{id}/percent")
    public ResponseEntity<Double> getPercent(@PathVariable Long id) {
        return ResponseEntity.ok(quarterService.getPercentage(id));
    }
}
