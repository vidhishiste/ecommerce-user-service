package com.Ecommerce.user.repository;

import com.Ecommerce.user.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  // Find a user by email
  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);

  //    void save(User user);
}
