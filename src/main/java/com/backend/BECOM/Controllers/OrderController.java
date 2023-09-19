package com.backend.BECOM.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.BECOM.DTO.OrderDTO;
import com.backend.BECOM.Services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);
        return ResponseEntity.ok("Order placed successfully");
    }

    @GetMapping("/view")
    public ResponseEntity<List<OrderDTO>> viewOrders() {
        List<OrderDTO> orders = orderService.viewOrders();
        return ResponseEntity.ok(orders);
    }

    // Other methods for order-related actions
}
