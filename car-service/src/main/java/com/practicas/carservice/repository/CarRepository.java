package com.practicas.carservice.repository;

import com.practicas.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car>findByUserId(int id);
}
