package com.example.userservice.zuulapigateway;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.userservice.zuulapigateway.configuration.JwtToken;
import com.example.userservice.zuulapigateway.configuration.LocalRibbonClientConfiguration;
import com.example.userservice.zuulapigateway.filters.ErrorFilter;
import com.example.userservice.zuulapigateway.filters.PostFilter;
import com.example.userservice.zuulapigateway.filters.PreFilter;
import com.example.userservice.zuulapigateway.filters.RouteFilter;


@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@RibbonClient(name = "user-service", configuration = LocalRibbonClientConfiguration.class)
public class ZuulapiGatewayApplication {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulapiGatewayApplication.class, args);
	}

	
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
