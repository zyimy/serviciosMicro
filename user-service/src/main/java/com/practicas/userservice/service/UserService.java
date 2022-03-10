package com.practicas.userservice.service;

import com.practicas.userservice.config.RestTemplateConfig;
import com.practicas.userservice.entity.User;
import com.practicas.userservice.feigclients.BikeFeingClient;
import com.practicas.userservice.feigclients.CarFeignClient;
import com.practicas.userservice.model.Bike;
import com.practicas.userservice.model.Car;
import com.practicas.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarFeignClient carFeignClient;


    @Autowired
    private BikeFeingClient bikeFeingClient;



    public List<User>getAll(){

        return userRepository.findAll();
    }

    public User getUserById(int id){
        User user = userRepository.findById(id).orElse(null);

        return user;
    }

    public User save(User user){
        User user1 = userRepository.save(user);

        return user1;
    }

    public List<Car>getCars(int userId){
        List<Car>lista = restTemplate.getForObject("http://localhost:8002/car/buscar/"+userId,List.class);
        return lista;
    }

    public List<Bike>getBikes(int userId){
        List<Bike>lista = restTemplate.getForObject("http://localhost:8003/bike/buscar/"+userId,List.class);
        return lista;
    }

    public  Car saveCar(int userId,Car car){
        car.setUserId(userId);
        Car carNew= carFeignClient.save(car);

        return carNew;
    }

    public  Bike saveBike(int userId,Bike bike){
        bike.setUserId(userId);
        Bike bikeNew= bikeFeingClient.save(bike);

        return bikeNew;
    }

    public Map<String, Object> getUserandVehicles(int userId){
        HashMap<String, Object> result = new HashMap<>();
        User user = userRepository.findById(userId).orElse(null);

        if (user == null){
            result.put("Mensaje","No existe el usario");
            return result;
        }
        result.put("User",user);

        List<Car>cars = carFeignClient.getCars(userId);
        if (cars.isEmpty()){
            result.put("Cars","Ese user no tiene coches");
        }else{
            result.put("Cars",cars);
        }

        List<Bike>bikes = bikeFeingClient.getBikes(userId);
        if (bikes.isEmpty()){
            result.put("Bikes","Ese user no tiene bikes");
        }else{
            result.put("Bikes",bikes);
        }

        return result;
    }
}
