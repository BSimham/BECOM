package com.backend.BECOM.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.BECOM.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom query methods here if needed
	
//	@Query(value = "SELECT * FROM products WHERE price > :minPrice", nativeQuery = true)
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);
//	
//	@Query("SELECT * FROM products WHERE LIKE '%:category' ORDER BY price ASC")
	List<Product> findByCategoryOrderByPriceAsc(Category category);
//	
//    Page<Product> findByCategory(Category category, Pageable pageable);
//    
//    @Query("SELECT * FROM products WHERE price < :price")
    List<Product> findByPriceLessThan(double price);
//    
//    @Query("SELECT * FROM products WHERE name LIKE '%:keyword%'")
    List<Product> findByNameContaining(String keyword);
//    
//    @Query("SELECT * FROM products WHERE category LIKE '%:category'")
    List<Product> findByCategory(Category category);

}
