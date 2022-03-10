package com.practicas.carservice.controller;

import com.practicas.carservice.entity.Car;
import com.practicas.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>>getAllUser(){
        List<Car> lista = carService.getAll();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{

            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id")int id){
        Car car = carService.getUserById(id);

        if (car==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(car);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("id")int id){
        List<Car> lista = carService.getByUserId(id);

            return ResponseEntity.ok(lista);

    }

    @PostMapping
    public ResponseEntity<Car>saveUser(@RequestBody Car car){
       Car car1 = carService.save(car);

     return ResponseEntity.ok(car1);
    }


}
