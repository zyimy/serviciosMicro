package com.practicas.userservice.feigclients;

import com.practicas.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service",url = "http://localhost:8002/car")
public interface CarFeignClient {
    @PostMapping
    Car save(@RequestBody Car car);

    @GetMapping("/buscar/{userId}")
    List<Car>getCars(@PathVariable("userId") int userId);
}
