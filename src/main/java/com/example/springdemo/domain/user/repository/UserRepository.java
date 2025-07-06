package com.example.springdemo.domain.user.repository;

import com.example.springdemo.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	// AuthService.java 에서 사용
	boolean existsByUsername(String username);

	// AuthService.java 에서 사용
	Optional<User> findByUsername(String username);









}
