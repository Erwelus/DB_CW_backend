package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.StreetStreetEntity;
import com.example.db_cw_backend.repository.StreetStreetRepository;
import com.example.db_cw_backend.service.StreetStreetService;
import com.example.db_cw_backend.transfer.StreetStreetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/street_street/")
public class StreetStreetController {

    private final StreetStreetRepository repository;
    private final StreetStreetService service;

    public StreetStreetController(StreetStreetRepository qr, StreetStreetService qs){
        this.repository = qr;
        this.service = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody StreetStreetDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<StreetStreetEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        StreetStreetEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody StreetStreetDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
