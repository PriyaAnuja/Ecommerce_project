package com.ecommerce1.productservice1.controllers;

import com.ecommerce1.productservice1.dtos.GetProductDto;
import com.ecommerce1.productservice1.models.Product;
import com.ecommerce1.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//to tell spring as this is a controller(register this class as controller)
//Springbean--> spring will create object(1) for this class
@RestController
@RequestMapping("/products")
public class ProductController {

   // @Autowired
    //the below constructor is called when an object is getting created.
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductbyId(@PathVariable("id") Long id){
//        ProductService ps=new ProductService();
//        return ps.getProductById(id);
        //instead of above, i can create a constructor, whoever is creating the
        // productcontroller is creating the productservice
        return productService.getProductById(id);
    }

    @PostMapping("")
    //@RequestBody Product product-->converts received json to object
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
        System.out.println(product.getId());
        return "Product created";
    }
}
