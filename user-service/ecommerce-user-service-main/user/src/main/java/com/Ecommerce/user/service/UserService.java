package com.Ecommerce.user.service;

import com.Ecommerce.user.dto.LoginRequest;
import com.Ecommerce.user.dto.UserRequest;
import com.Ecommerce.user.dto.UserResponse;
import com.Ecommerce.user.model.User;
import com.Ecommerce.user.repository.UserRepository;
import com.Ecommerce.user.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  @Autowired private JwtUtil jwtUtil;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  // Register user
  public UserResponse registerUser(UserRequest request) {
    log.info("request recieved : {}", request);
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      return new UserResponse("User already registered with ", request.getEmail());
    }
    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setMobile(request.getMobile());
    userRepository.save(user);
    return new UserResponse("User registered successfully", user.getEmail());
  }

  // Verify email (mock)
  public String verifyEmail(String email) {
    User user =
        userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    user.setEmailVerified(true);
    userRepository.save(user);
    return "Email verified successfully";
  }

  // Login
  public String login(LoginRequest request) {
    User user =
        userRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }
    // Here you would generate JWT
    return jwtUtil.generateToken(user.getEmail());
  }

  // Get profile
  public UserResponse getProfile(String email) {
    User user =
        userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    return new UserResponse("Profile fetched", user.getEmail());
  }
  // Update profile
  //    public UserResponse updateProfile(String email, UserUpdateRequest request) {
  //        User user = userRepository.findByEmail(email)
  //                .orElseThrow(() -> new RuntimeException("User not found"));
  //        if(request.getUsername() != null) user.setUsername(request.getUsername());
  //        if(request.getPassword() != null)
  // user.setPassword(passwordEncoder.encode(request.getPassword()));
  //        userRepository.save(user);
  //        return new UserResponse("Profile updated", user.getEmail(), user.getUsername());
  //    }
}
