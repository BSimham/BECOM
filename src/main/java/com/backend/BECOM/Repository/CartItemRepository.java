package com.backend.BECOM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.BECOM.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // You can define custom query methods here if needed
}