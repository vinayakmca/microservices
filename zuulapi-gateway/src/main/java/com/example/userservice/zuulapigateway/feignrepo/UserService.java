package com.example.userservice.zuulapigateway.feignrepo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.userservice.zuulapigateway.entity.User;

@FeignClient(name="user-service" ,path="/userservice")
@RibbonClient(name="user-service")
public interface UserService {
	
	@GetMapping("/api/search/user")
	public User getUserByName(@RequestParam("name") String name);

}
