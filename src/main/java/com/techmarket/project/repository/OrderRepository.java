package com.techmarket.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.techmarket.project.entity.Order;
import com.techmarket.project.enums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
}
