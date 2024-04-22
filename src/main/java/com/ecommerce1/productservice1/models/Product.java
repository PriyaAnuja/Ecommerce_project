package com.ecommerce1.productservice1.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//lombok annotaions
@Getter
@Setter
@Data //when i print the following,prints the values associated with it,won't print the address.
public class Product {
    private Long id;

    private String title;

    private String description;

    private Double price;

    private String image;

    private String category;

    private String seller;

}
