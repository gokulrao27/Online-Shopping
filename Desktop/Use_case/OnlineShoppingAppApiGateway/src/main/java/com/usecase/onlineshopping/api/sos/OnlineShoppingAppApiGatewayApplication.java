package com.usecase.onlineshopping.api.sos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
public class OnlineShoppingAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingAppApiGatewayApplication.class, args);
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

}
