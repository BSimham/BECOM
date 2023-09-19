package com.backend.BECOM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.BECOM.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // You can define custom query methods here if needed
}
