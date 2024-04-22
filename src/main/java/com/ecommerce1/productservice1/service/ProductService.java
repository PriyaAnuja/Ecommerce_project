package com.ecommerce1.productservice1.service;

import com.ecommerce1.productservice1.dtos.GetProductDto;
import com.ecommerce1.productservice1.exceptions.NotFoundException;
import com.ecommerce1.productservice1.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public GetProductDto getProductById(Long id) throws NotFoundException {
        //from here i need to call DB
        //from here i need to call fakestore API i.e 3rd party API
        //https://fakestoreapi.com/products/15
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        System.out.println(product);

        if(product == null) {
            throw new NotFoundException();
        }
        return convertToDto(product);

    }

    private static GetProductDto convertToDto(Product product) {
        GetProductDto obj=new GetProductDto();
        //since i have used getters and setters in GetProductDto class, i can write as below.
        obj.setTitle(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImage(product.getImage());
        return obj;
    }

    public List<GetProductDto> getAllProducts(){

        //1. make a call to 3rd party api
        //2. deserialize into java obj--> array of products
        //3. convert the array into list of DTO objects

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        List<GetProductDto> returnProducts = new ArrayList<>();
        for(Product product : products){
            returnProducts.add(convertToDto(product));
        }
        return returnProducts;
    }
}
