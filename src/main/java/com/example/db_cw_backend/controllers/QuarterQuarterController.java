package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.QuarterQuarterEntity;
import com.example.db_cw_backend.repository.QuarterQuarterRepository;
import com.example.db_cw_backend.service.QuarterQuarterService;
import com.example.db_cw_backend.transfer.IdDto;
import com.example.db_cw_backend.transfer.QuarterQuarterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/quarter_quarter/")
public class QuarterQuarterController {

    private final QuarterQuarterRepository QuarterQuarterRepository;
    private final QuarterQuarterService QuarterQuarterService;

    public QuarterQuarterController(QuarterQuarterRepository qr, QuarterQuarterService qs){
        this.QuarterQuarterRepository = qr;
        this.QuarterQuarterService = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody QuarterQuarterDto data){
        QuarterQuarterRepository.save(QuarterQuarterService.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<QuarterQuarterEntity> entityList = QuarterQuarterRepository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        QuarterQuarterEntity entity = QuarterQuarterRepository.findById(data.getId()).get();
        return ResponseEntity.ok(QuarterQuarterService.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody QuarterQuarterDto data){
        QuarterQuarterRepository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}

