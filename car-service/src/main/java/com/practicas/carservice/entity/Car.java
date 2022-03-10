package com.practicas.carservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String brand;
    private String model;
    private int userId;
}
