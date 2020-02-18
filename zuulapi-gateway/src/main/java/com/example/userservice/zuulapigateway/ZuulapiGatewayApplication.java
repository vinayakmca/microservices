package com.example.userservice.zuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.userservice.zuulapigateway.filters.ErrorFilter;
import com.example.userservice.zuulapigateway.filters.PostFilter;
import com.example.userservice.zuulapigateway.filters.PreFilter;
import com.example.userservice.zuulapigateway.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulapiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulapiGatewayApplication.class, args);
	}

	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
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
