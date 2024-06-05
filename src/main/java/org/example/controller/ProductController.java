package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Product;
import org.example.repository.*;
import org.example.repository.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class ProductController {



    ProductsRepository productsRepository;

    @Autowired
    public ProductController(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/api/products/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id){
        Optional<Product> product = productsRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping(path = "/api/products/")
    public void addProduct(@RequestBody ProductDTO product) throws Exception{
        //Product item = new ObjectMapper().readValue(description, Product.class);
        Product item = new Product();
//        item.setId(123L);
        item.setDescription(product.getDescription());
        item.setPurchased(product.isPurchased());
        //productsRepository
        productsRepository.save(item);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProductById(@PathVariable Long id){
        productsRepository.deleteById(id);
    }

    @GetMapping(path = "/api/products/")
    @ResponseBody
    public List<Product> getProducts(){
        return (List<Product>) productsRepository.findAll();
    }

    @PutMapping("/api/products/{id}")
    public void setPurchased(@PathVariable Long id, @RequestBody boolean purchased){
        productsRepository.setPurchased(purchased, id);
    }
}
