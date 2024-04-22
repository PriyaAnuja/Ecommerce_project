package com.ecommerce1.productservice1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String image;

    private String category;

}
