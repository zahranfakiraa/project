package com.techmarket.project.services.admin.adminproduct;

import java.io.IOException;
import java.util.List;

import com.techmarket.project.dto.ProductDTO;

public interface AdminProductService {

    ProductDTO addProduct(ProductDTO productDTO) throws IOException;

    List<ProductDTO> getAllProduct();

    List<ProductDTO> getAllProductByName(String name);

    boolean deleteProduct(Long id);
} 
