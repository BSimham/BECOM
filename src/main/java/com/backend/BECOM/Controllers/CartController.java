package com.backend.BECOM.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.BECOM.DTO.CartDTO;
import com.backend.BECOM.DTO.CartItemDTO;
import com.backend.BECOM.Services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        cartService.addToCart(cartItemDTO);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping("/view")
    public ResponseEntity<CartDTO> viewCart() {
        CartDTO cart = cartService.viewCart();
        return ResponseEntity.ok(cart);
    }

    // Other methods for cart-related actions
}

