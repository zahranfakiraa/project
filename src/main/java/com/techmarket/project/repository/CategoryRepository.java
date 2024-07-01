package com.techmarket.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmarket.project.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
