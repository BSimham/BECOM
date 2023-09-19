package com.backend.BECOM.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.BECOM.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods here if needed
	 
//	@Query("SELECT * FROM users WHERE username = :username")
	Optional<User> findByUsername(String username);
//	
//	@Query("Select * from users where userId = :id")
	User getById(Long id);
//	
	
}