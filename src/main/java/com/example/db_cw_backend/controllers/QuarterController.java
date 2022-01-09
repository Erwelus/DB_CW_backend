package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.service.QuarterService;
import com.example.db_cw_backend.transfer.IdDto;
import com.example.db_cw_backend.transfer.QuarterDto;
import com.example.db_cw_backend.transfer.QuarterListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/app/quarter/")
public class QuarterController {

    private final QuarterRepository quarterRepository;
    private final QuarterService quarterService;

    public QuarterController(QuarterRepository qr, QuarterService qs){
        this.quarterRepository = qr;
        this.quarterService = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody QuarterDto data){
        quarterRepository.save(quarterService.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<QuarterEntity> entityList = quarterRepository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        QuarterEntity entity = quarterRepository.findById(data.getId()).get();
        return ResponseEntity.ok(quarterService.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody QuarterDto data){
        quarterRepository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
