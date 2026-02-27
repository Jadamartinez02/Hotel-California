package com.hotelcalifornia.hotelcalifornia.controller;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelcalifornia.hotelcalifornia.domain.model.entity.Bed;
import com.hotelcalifornia.hotelcalifornia.domain.model.service.BedService;

@RestController
@RequestMapping("/logincalifornia/v1/bed")
public class BedController {
    @Autowired
    BedService bedService;
    
    @PostMapping
    public ResponseEntity<Bed> saveBed(@RequestBody Bed data){
        Bed responseSave = this.bedService.saveBed(data);
        return ResponseEntity.status(HttpStatus.OK).body(responseSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bed> updateBed(@PathVariable Integer id, @RequestBody Bed data){
        Bed reponseUpdate = this.bedService.updateTypeBed(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(reponseUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBed(@PathVariable Integer id){
        this.bedService.deleteByid(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping
    public ResponseEntity<Bed> getBedById (@PathVariable Integer id){
        Bed reponseByid = this.bedService.searchBedById(id);
        return ResponseEntity.status(HttpStatus.OK).body(reponseByid);
    }
    @GetMapping
    public ResponseEntity<List<Bed>> getBeds(){
        List<Bed> responseBeds = this.bedService.serarchBeds();
        return ResponseEntity.status(HttpStatus.OK).body(responseBeds);
    }
}
