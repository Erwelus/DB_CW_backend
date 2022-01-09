package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.StreetStreetEntity;
import com.example.db_cw_backend.repository.StreetStreetRepository;
import com.example.db_cw_backend.service.StreetStreetService;
import com.example.db_cw_backend.transfer.IdDto;
import com.example.db_cw_backend.transfer.StreetStreetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/street_street/")
public class StreetStreetController {

    private final StreetStreetRepository StreetStreetRepository;
    private final StreetStreetService StreetStreetService;

    public StreetStreetController(StreetStreetRepository qr, StreetStreetService qs){
        this.StreetStreetRepository = qr;
        this.StreetStreetService = qs;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody StreetStreetDto data){
        StreetStreetRepository.save(StreetStreetService.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<StreetStreetEntity> entityList = StreetStreetRepository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        StreetStreetEntity entity = StreetStreetRepository.findById(data.getId()).get();
        return ResponseEntity.ok(StreetStreetService.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody StreetStreetDto data){
        StreetStreetRepository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
