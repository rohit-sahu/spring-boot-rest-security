package com.rohit.springbootrestsecurity.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rohit.springbootrestsecurity.dto.UserDetailsPrincipal;
import com.rohit.springbootrestsecurity.model.User;
import com.rohit.springbootrestsecurity.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByusername(username);
		optionalUser
			.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return optionalUser
			.map(UserDetailsPrincipal :: new).get();
	}
}