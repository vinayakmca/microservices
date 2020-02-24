package com.example.userservice.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.userservice.dto.UserDTO;
import com.example.userservice.userservice.entity.User;
import com.example.userservice.userservice.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create/user")
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDto){
		return new ResponseEntity<String>(userService.saveUser(userDto),HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getAllUser(){
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("/search/user")
	public ResponseEntity<?> getUserByName(@RequestParam("name") String name){
		return new ResponseEntity<User>(userService.getUserByName(name),HttpStatus.OK);
	}
	
	
}
