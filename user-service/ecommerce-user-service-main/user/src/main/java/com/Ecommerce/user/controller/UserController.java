package com.Ecommerce.user.controller;

import com.Ecommerce.user.dto.LoginRequest;
import com.Ecommerce.user.dto.UserRequest;
import com.Ecommerce.user.dto.UserResponse;
import com.Ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest request) {
    return ResponseEntity.ok(userService.registerUser(request));
  }

  //
  //  @PostMapping("/forgotPassword")
  //  public ResponseEntity<UserResponse> forgotPassword(@RequestBody UserRequest request) {
  //    return ResponseEntity.ok(userService.forgotPassword(request));
  //  }

  @GetMapping("/verify-email")
  public ResponseEntity<String> verifyEmail(@RequestParam String email) {
    return ResponseEntity.ok(userService.verifyEmail(email));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(userService.login(request));
  }

  @GetMapping("/me")
  public ResponseEntity<UserResponse> getProfile(@RequestParam String email) {
    return ResponseEntity.ok(userService.getProfile(email));
  }

  //    @PutMapping("/me")
  //    public ResponseEntity<UserResponse> updateProfile(@RequestParam String email, @RequestBody
  // UserUpdateRequest request) {
  //        return ResponseEntity.ok(userService.updateProfile(email, request));
  //    }
}
