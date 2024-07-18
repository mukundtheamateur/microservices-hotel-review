package com.cts.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.user.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByEmail(String username);

	Boolean existsByEmail(String email);

	
}
