package com.Ecommerce.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  private String username;
  private String email;
  private String password;
}
