package com.rohit.springbootrestsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springbootrestsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByusername(String username);

}
