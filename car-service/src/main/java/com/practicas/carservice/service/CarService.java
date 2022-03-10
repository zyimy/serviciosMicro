package com.practicas.carservice.service;

import com.practicas.carservice.entity.Car;
import com.practicas.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car>getAll(){
        return carRepository.findAll();
    }

    public Car getUserById(int id){
        Car car = carRepository.findById(id).orElse(null);

        return car;
    }

    public Car save(Car car){
        Car car1 = carRepository.save(car);

        return car1;
    }

    public List<Car> getByUserId(int id){

        return  carRepository.findByUserId(id);
    }
}
