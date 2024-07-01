package com.techmarket.project.controller.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmarket.project.dto.ProductDTO;
import com.techmarket.project.services.customer.CustomerProductsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerProductController {
    
    private final CustomerProductsService customerProductsService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProcducts(){
        List<ProductDTO> productDTOs = customerProductsService.getAllProduct();
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDTO>> getAllProductByName(@PathVariable String name){
        List<ProductDTO> productDTOs = customerProductsService.searchProductByTitle(name);
        return ResponseEntity.ok(productDTOs);
    }

}
