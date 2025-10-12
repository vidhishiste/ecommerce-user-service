package com.Ecommerce.user.model;

import jakarta.persistence.*;
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
  @Column(unique = true, nullable = false)
  private String email;

  private String password;
  private boolean emailVerified = false;

  // getters & setters (or use Lombok @Data)

}
