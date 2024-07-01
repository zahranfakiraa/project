package com.techmarket.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmarket.project.entity.Cartitems;

@Repository
public interface CartItemsRepository extends JpaRepository<Cartitems, Long>{
    
    Optional<Cartitems> findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);
}
