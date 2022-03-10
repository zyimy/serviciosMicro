package com.practicas.userservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String email;
}
