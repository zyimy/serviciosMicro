package com.practicas.bikeservice.service;

import com.practicas.bikeservice.entity.Bike;
import com.practicas.bikeservice.repository.BikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike>getAll(){
        return bikeRepository.findAll();
    }

    public Bike getUserById(int id){
        Bike bike = bikeRepository.findById(id).orElse(null);

        return bike;
    }

    public Bike save(Bike bike){
        Bike bike1 = bikeRepository.save(bike);

        return bike1;
    }

    public List<Bike> getByUserId(int id){
        return  bikeRepository.findByUserId(id);
    }
}
