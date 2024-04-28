package com.ecommerce1.productservice1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Setter
public class Batch{
    @Id
    private Long id;
    private String name;
    private Integer strength;

    //creating extra column here to store instructor id
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;
}
