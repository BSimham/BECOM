package com.backend.BECOM.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.BECOM.DTO.UserDTO;
import com.backend.BECOM.DTO.UserLoginDTO;
import com.backend.BECOM.Entity.User;
import com.backend.BECOM.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO) {
        // Convert DTO to entity and save user
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole("USER"); // Set default role
        userRepository.save(user);
    }

    public String loginUser(UserLoginDTO userLoginDTO) {
        // Implement login logic and generate authentication token
        // Return the token
    	String token = "your_generated_token";
        return token;
    }
    
    public User getUser(Long userId) {
    	User user = userRepository.getById(userId);
    	return user;
    }

    // Other methods for user-related logic
}
