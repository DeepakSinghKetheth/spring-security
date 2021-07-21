package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.config.UserPrincipal;
import com.springsecurity.entity.Employee;
import com.springsecurity.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Entered MyUserDetailsService");
		System.out.println("Calling Repository to find user by username");
		Employee user = repo.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("User Not Found");
		System.out.println("Current User :" + user);
		return new UserPrincipal(user); 	 
	}

}
