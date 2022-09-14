package com.Gokul.ItemService;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
		corsConfiguration.setAllowedOrigins(List.of("*"));
		corsConfiguration
				.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS", "PATCH", "DELETE"));
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setExposedHeaders(List.of("Authorization"));
		http.cors().configurationSource(request -> corsConfiguration);
		http.csrf().disable();

		http.headers().frameOptions().disable();
	}
}