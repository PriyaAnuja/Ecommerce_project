package com.ecommerce1.productservice1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

//@MappedSuperclass
@Getter
@Setter
@Entity
//i am telling hibernate to add these data into tables in mysql
//@Entity(name = "ecomm_user")

//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.JOINED)
//this is user obj in backend application
public class User {
    @Id  //telling as id is primary key.
//    @GeneratedValue(strategy = IDENTITY)  //to generate autoincrement values for id(1,2,3...)
//    private Long id;
    @GeneratedValue
    private UUID id;
    //4c441c86-2a36-42de-b982-489e4b4cec8e  (32 char)

    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
