package com.techmarket.project.services.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.techmarket.project.dto.ProductDTO;
import com.techmarket.project.entity.Product;
import com.techmarket.project.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductsServiceImpl implements CustomerProductsService{

    private final ProductRepository productRepository;
    
     public List<ProductDTO> getAllProduct(){
        List<Product> product = productRepository.findAll();
        return product.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDTO> searchProductByTitle(String name){
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}
