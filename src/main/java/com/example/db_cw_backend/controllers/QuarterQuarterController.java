package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.QuarterQuarterEntity;
import com.example.db_cw_backend.repository.QuarterQuarterRepository;
import com.example.db_cw_backend.service.QuarterQuarterService;
import com.example.db_cw_backend.transfer.QuarterQuarterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/quarter_quarter/")
public class QuarterQuarterController {

    private final QuarterQuarterRepository repository;
    private final QuarterQuarterService service;

    public QuarterQuarterController(QuarterQuarterRepository qr, QuarterQuarterService qs){
        this.repository = qr;
        this.service = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody QuarterQuarterDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<QuarterQuarterEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        QuarterQuarterEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody QuarterQuarterDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}

