package com.ecommerce1.productservice1.service;

import com.ecommerce1.productservice1.dtos.GetProductDto;
import com.ecommerce1.productservice1.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public GetProductDto getProductById(Long id){
        //from here i need to call DB
        //from here i need to call fakestore API i.e 3rd party API
        //https://fakestoreapi.com/products/15
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);

        GetProductDto obj=new GetProductDto();
        //since i have used getters and setters in GetProductDto class, i can write as below.
        obj.setTitle(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImage(product.getImage());
        return obj;

    }
}
