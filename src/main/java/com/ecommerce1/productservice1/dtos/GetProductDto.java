package com.ecommerce1.productservice1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private String title;

    private Double price;

    private String image;
}
