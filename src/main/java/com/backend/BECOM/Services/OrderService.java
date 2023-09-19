package com.backend.BECOM.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.BECOM.DTO.OrderDTO;
import com.backend.BECOM.DTO.OrderItemDTO;
import com.backend.BECOM.DTO.ProductDTO;
import com.backend.BECOM.Entity.Order;
import com.backend.BECOM.Entity.OrderItem;
import com.backend.BECOM.Entity.Product;
import com.backend.BECOM.Repository.OrderItemRepository;
import com.backend.BECOM.Repository.OrderRepository;
import com.backend.BECOM.Repository.ProductRepository;
import com.backend.BECOM.Repository.UserRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;
    // You'll need to inject ProductService for updating product quantities
    
    @Autowired
    private UserRepository userRepository;

    public void placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUser(userRepository.getById(orderDTO.getUserId()));
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setStatus("PENDING"); // Set initial status

        double totalAmount = 0.0;

        for (OrderItemDTO orderItemDTO : orderDTO.getItems()) {
            Product product = productRepository.findById(orderItemDTO.getProductId()).get();
            
            int quantity = orderItemDTO.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItemRepository.save(orderItem);

            totalAmount += product.getPrice() * quantity;

            // Update product quantity (subtract sold quantity)
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product); // Update the product in the database
        }

        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
    }

    public List<OrderDTO> viewOrders(Long userId) {
        // Fetch the user's orders from the database
        List<Order> orders = orderRepository.findAll(); // Assuming you have a userId parameter

        return convertToDTOList(orders);
    }
    
    public List<OrderDTO> viewOrders() {
        // Fetch the user's orders from the database
        List<Order> orders = orderRepository.findAll(); // Assuming you have a userId parameter

        return convertToDTOList(orders);
    }


    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setTotalAmount(order.getTotalAmount());

        List<OrderItemDTO> orderItems = order.getItems().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());

        orderDTO.setItems(orderItems);
        return orderDTO;
    }

    private OrderItemDTO convertToDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setProductId(orderItem.getProduct().getId());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        return orderItemDTO;
    }

    private List<OrderDTO> convertToDTOList(List<Order> orders) {
        return orders.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    // Other methods for order-related logic
}
