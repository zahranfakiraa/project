package com.techmarket.project.services.customer.cart;

import org.springframework.http.ResponseEntity;

import com.techmarket.project.dto.AddProductInCartDTO;

public interface CartService {
    
    ResponseEntity<?> addProductToCart(AddProductInCartDTO addProductInCartDTO);
}
