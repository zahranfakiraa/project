package com.techmarket.project.services.admin.category;

import java.util.List;

import com.techmarket.project.dto.CategoryDTO;
import com.techmarket.project.entity.Category;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);

    List<Category> getAllCategories();
} 
