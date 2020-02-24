package com.example.userservice.zuulapigateway.configuration;

import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

@Configuration
public class LocalRibbonClientConfiguration {
	 @Bean
	    public ServerList<Server> ribbonServerList() {
	        // return new ConfigurationBasedServerList();
	        StaticServerList<Server> staticServerList = new StaticServerList<>(new Server("localhost", 8883));
	        return staticServerList;
	    }
}
