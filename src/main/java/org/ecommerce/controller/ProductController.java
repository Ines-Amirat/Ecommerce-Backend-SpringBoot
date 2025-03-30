package org.ecommerce.controller;

import org.ecommerce.model.Product;

import org.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return  productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable  Long id ){

        Optional<Product> product =  productService.getProductById(id);
        if(product.isPresent()){
            return  ResponseEntity.ok(product.get());
        }else{
            return  ResponseEntity.notFound().build();
        }
    }


}
