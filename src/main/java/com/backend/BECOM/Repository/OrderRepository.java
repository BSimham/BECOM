package com.backend.BECOM.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.BECOM.Entity.Order;
import com.backend.BECOM.Entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can define custom query methods here if needed
	
	List<Order> findByUserOrder(User user);
	
    List<Object[]> getTotalAmountByUser(User user);
    
    List<Order> findByStatus(String status);

    List<Order> findByUserAndStatus(User user, String status);

    List<Order> findByTotalAmountGreaterThan(double amount);
    
    List<Order> findByUserAndStatusOrderByTotalAmountDesc(User user, String status);
}


