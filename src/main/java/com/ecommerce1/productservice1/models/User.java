package com.ecommerce1.productservice1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
//i am telling hibernate to add these data into tables in mysql
@Entity(name = "ecomm_user")
//this is user obj in backend application
public class User {
    @Id  //telling as id is primary key.
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
