package com.ecommerce1.productservice1.controllers;

import com.ecommerce1.productservice1.models.Product;
import org.springframework.web.bind.annotation.*;

//to tell spring as this is a controller(register this class as controller)
//Springbean--> spring will create object(1) for this class
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public String getProductbyId(@PathVariable("id") Long id){
        return "Here is your product" + id;
    }

    @PostMapping("")
    //@RequestBody Product product-->converts received json to object
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getId());
        return "Product created";
    }
}
