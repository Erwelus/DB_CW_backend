package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.repository.GeneralRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.StreetRepository;
import com.example.db_cw_backend.transfer.PercentageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/app/percent/")
public class PercentageController {

    private final GeneralRepository generalRepository;
    private final StreetRepository streetRepository;
    private final QuarterRepository quarterRepository;

    public PercentageController(GeneralRepository gr, StreetRepository sr, QuarterRepository qr){
        this.generalRepository = gr;
        this.streetRepository = sr;
        this.quarterRepository = qr;
    }

    @GetMapping("city")
    public ResponseEntity calculatePercentageForCity(){
        Map<Object, Object> response = new HashMap<>();
        response.put("result", generalRepository.countPercentageOfCity());
        return ResponseEntity.ok(response);
    }

    @GetMapping("quarter")
    public ResponseEntity calculatePercentageForQuarter(@RequestParam String name){
        Map<Object, Object> response = new HashMap<>();
        response.put("result", quarterRepository.calculateReadinessPercentage(quarterRepository.findByName(name).getId()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("street")
    public ResponseEntity calculatePercentageForStreet(@RequestParam String name){
        Map<Object, Object> response = new HashMap<>();
        response.put("result", streetRepository.calculateReadinessPercentage(streetRepository.findByName(name).getId()));
        return ResponseEntity.ok(response);
    }
}
