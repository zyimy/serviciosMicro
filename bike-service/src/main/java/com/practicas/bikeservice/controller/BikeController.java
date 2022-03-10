package com.practicas.bikeservice.controller;

import com.practicas.bikeservice.entity.Bike;
import com.practicas.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>>getAllUser(){
        List<Bike> lista = bikeService.getAll();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{

            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id")int id){
        Bike bike = bikeService.getUserById(id);

        if (bike==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(bike);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("id")int id){
        List<Bike> lista = bikeService.getByUserId(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Bike>saveUser(@RequestBody Bike bike){
       Bike bike1 = bikeService.save(bike);

     return ResponseEntity.ok(bike1);
    }


}
