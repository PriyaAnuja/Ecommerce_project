package com.ecommerce1.productservice1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Instructor extends User{
    private Double salary;
    private String skills;
    //if i use non-primitive(not int,str,double) type inside a cls, in that case i need to specify the cardinality between the class
    //cardinality
    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "instructor", cascade = CascadeType.REMOVE)
    private List<Batch> batch;

}
