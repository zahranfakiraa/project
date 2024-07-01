package com.techmarket.project.services.admin.adminproduct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.techmarket.project.dto.ProductDTO;
import com.techmarket.project.entity.Category;
import com.techmarket.project.entity.Product;
import com.techmarket.project.repository.CategoryRepository;
import com.techmarket.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl  implements AdminProductService{
    
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDTO addProduct(ProductDTO productDTO) throws java.io.IOException{
        
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImg(productDTO.getImg().getBytes());

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow();

        product.setCategory(category);
        
        return productRepository.save(product).getDto();
    }

    public List<ProductDTO> getAllProduct(){
        List<Product> product = productRepository.findAll();
        return product.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDTO> getAllProductByName(String name){
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public boolean deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
