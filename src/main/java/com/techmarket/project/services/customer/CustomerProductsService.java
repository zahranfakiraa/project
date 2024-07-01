package com.techmarket.project.services.customer;

import java.util.List;

import com.techmarket.project.dto.ProductDTO;

public interface CustomerProductsService {
    
    List<ProductDTO> searchProductByTitle(String title);
    
    List<ProductDTO> getAllProduct();
}
