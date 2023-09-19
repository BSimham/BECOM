package com.backend.BECOM.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.BECOM.DTO.ProductDTO;
import com.backend.BECOM.Entity.Product;
import com.backend.BECOM.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return convertToDTOList(products);
    }

	public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return convertToDTO(productOptional.get());
        }
        throw new EntityNotFoundException("Product not found");
    }

	private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageUrl(product.getImageUrl());
        return productDTO;
    }

    private List<ProductDTO> convertToDTOList(List<Product> products) {
        return products.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }


    // Other methods for product-related logic
}
