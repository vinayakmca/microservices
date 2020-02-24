package com.example.userservice.zuulapigateway.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.userservice.zuulapigateway.entity.User;
import com.example.userservice.zuulapigateway.feignrepo.UserService;


@Component
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		 User user=userService.getUserByName(username);
		 if(user==null) {
			 throw new UsernameNotFoundException("User not found with username: " + username);
		 }
		 return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getPassword(),
	                new ArrayList<>());
    }

}
