package com.backend.BECOM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.BECOM.Entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    // You can define custom query methods here if needed
}
