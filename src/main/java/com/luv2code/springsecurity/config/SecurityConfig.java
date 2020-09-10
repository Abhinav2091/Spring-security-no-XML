package com.luv2code.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//add our user for in memory Authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
				auth.inMemoryAuthentication()
				.withUser(users.username("Abhinav").password("root").roles("ADMIN"))
				.withUser(users.username("Aju").password("root").roles("EMPLOYEE"))
				.withUser(users.username("Himanshu").password("root").roles("MANAGER"));
	}

	
}
