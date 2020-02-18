package com.example.userservice.userservice.serviceimpl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.userservice.userservice.dto.UserDTO;
import com.example.userservice.userservice.entity.User;
import com.example.userservice.userservice.repository.UserRepository;
import com.example.userservice.userservice.sequence.UserSequences;
import com.example.userservice.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private MongoOperations mongo;
	
	 public int getNextSequence(String seqName)
	    {
	        UserSequences counter = mongo.findAndModify(
	            query(where("_id").is(seqName)),
	            new Update().inc("seq",1),
	            options().returnNew(true).upsert(true),
	            UserSequences.class);
	        return counter.getSeq();
	    }
	
	@Override
	public String saveUser(UserDTO userDto) {
		User user=new User();
		user.setFirstName(userDto.getFirstName());
		//String encodedPassword = new BCryptPasswordEncoder().encode(userDTO.getLastName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setPassword(userDto.getPassword());
        user.setId(getNextSequence("userSequences"));
		 userRepository.save(user);
		userDto.setId(user.getId());
		 return "user created sucessfully";
	}
	
	@Override
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
}
