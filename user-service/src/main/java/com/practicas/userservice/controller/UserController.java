package com.practicas.userservice.controller;

import com.practicas.userservice.entity.User;
import com.practicas.userservice.model.Bike;
import com.practicas.userservice.model.Car;
import com.practicas.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){
        List<User> lista = userService.getAll();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{

            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id")int id){
        User user = userService.getUserById(id);

        if (user==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping
    public ResponseEntity<User>saveUser(@RequestBody User user){
       User user1 = userService.save(user);

     return ResponseEntity.ok(user1);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>>getCars(@PathVariable("userId")int userId){
        User user= userService.getUserById(userId);

        if (user==null){
           return ResponseEntity.notFound().build();
        }else {
            List<Car>lista = userService.getCars(userId);

           return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>>getBikes(@PathVariable("userId")int userId){
        User user= userService.getUserById(userId);

        if (user==null){
            return ResponseEntity.notFound().build();
        }else {
            List<Bike>lista = userService.getBikes(userId);

            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car>guardarCar(@PathVariable("userId")int userId,@RequestBody Car car){
        Car car1 = userService.saveCar(userId,car);

        return ResponseEntity.ok(car1);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike>guardarBike(@PathVariable("userId")int userId,@RequestBody Bike bike){
        Bike bike1 = userService.saveBike(userId,bike);

        return ResponseEntity.ok(bike1);
    }

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String,Object>>getAllVehicles(@PathVariable("userId") int userId){
        Map<String,Object> lista = userService.getUserandVehicles(userId);

        return ResponseEntity.ok(lista);
    }


}
