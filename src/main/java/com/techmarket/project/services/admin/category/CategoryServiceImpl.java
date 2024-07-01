package com.techmarket.project.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techmarket.project.dto.CategoryDTO;
import com.techmarket.project.entity.Category;
import com.techmarket.project.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(category.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

}
