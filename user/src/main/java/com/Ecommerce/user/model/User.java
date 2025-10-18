package com.Ecommerce.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates no-arg constructor
@AllArgsConstructor // Generates all-args constructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  @Email(message = "Email should be valid")
  @NotBlank(message = "Email is required")
  @Column(unique = true, nullable = false)
  private String email;
  @NotBlank(message = "Password is required")
  @Size(min = 8, message = "Password must be at least 8 characters long")
  @Pattern(
          regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
          message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character"
  )
  private String password;
  private boolean emailVerified = false;
  @Column(unique = true, nullable = false)
  private String mobile;

  // getters & setters (or use Lombok @Data)

}
