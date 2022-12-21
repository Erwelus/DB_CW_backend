package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.service.QuarterService;
import com.example.db_cw_backend.transfer.QuarterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/app/quarter/")
public class QuarterController {

    private final QuarterRepository repository;
    private final QuarterService service;

    public QuarterController(QuarterRepository qr, QuarterService qs){
        this.repository = qr;
        this.service = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody QuarterDto data){
        if (data.getIndex() != null) {
            data.setX(data.getIndex() % 7);
            data.setY(data.getIndex() / 7);
        }
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody QuarterDto data){
        data.setId(repository.findByName(data.getOldName()).getId());
        return save(data);
    }

    @GetMapping("map")
    public ResponseEntity getMap(){
        List<QuarterEntity> entityList = repository.findAll();
        List<QuarterEntity> resultList = new ArrayList<>(28);
        for (int i = 0; i < 28; i++) {
            resultList.add(null);
        }
        for (QuarterEntity entity : entityList){
            resultList.set(entity.getY()*7 + entity.getX(), entity);
        }
        return ResponseEntity.ok(resultList);
    }
    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<QuarterEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getByName(@RequestParam String name){
        QuarterEntity entity = repository.findByName(name);
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam String name){
        repository.deleteByName(name);
        return ResponseEntity.ok("");
    }

}
