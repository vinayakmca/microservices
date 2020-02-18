package com.example.userservice.userservice.service;



import java.util.List;

import com.example.userservice.userservice.dto.UserDTO;
import com.example.userservice.userservice.entity.User;

public interface UserService {
	
	public String saveUser(UserDTO userDto);
	public List<User> getAllUser();

}
