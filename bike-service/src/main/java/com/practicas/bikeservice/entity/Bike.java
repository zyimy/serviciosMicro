package com.practicas.bikeservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bike")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String brand;
    private String model;
    private int userId;
}
