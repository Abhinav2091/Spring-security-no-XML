package com.luv2code.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our user for in memory Authentication

		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("Abhinav").password("root").roles("ADMIN"))
				.withUser(users.username("Aju").password("root").roles("EMPLOYEE"))
				.withUser(users.username("Himanshu").password("root").roles("MANAGER"));
	}

	// override the configure http method for custom login form.
	//else remove it and use spring provided login form.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//showMyLoginPage plain login page
		//showMyFancyLoginPage fancy login page.
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyFancyLoginPage")//my loginiN page
				.loginProcessingUrl("/authenticateTheUser").permitAll()//check user name and pass provided by Spring.
				.and().logout().permitAll();//adding log out support
	}

}
