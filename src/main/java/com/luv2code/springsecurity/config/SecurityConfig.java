package com.luv2code.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	// add a reference to our security data source
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// add our user for in memory Authentication
//
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication().withUser(users.username("Abhinav").password("root").roles("EMPLOYEE","ADMIN"))
//				.withUser(users.username("Aju").password("root").roles("EMPLOYEE"))
//				.withUser(users.username("Himanshu").password("root").roles("EMPLOYEE","MANAGER"));

		// use jdbc authentication
		//{noop} in jdbc mean plain text
		//{bcrypt} in jdbc mean encrypted process
		auth.jdbcAuthentication().dataSource(dataSource);

	}

	// override the configure http method for custom login form.
	// else remove it and use spring provided login form.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// showMyLoginPage plain login page
		// showMyFancyLoginPage fancy login page.
		// anyRequest will allow any one who is authenticated without authorization
		/*
		 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().
		 * loginPage("/showMyFancyLoginPage")//my loginiN page
		 * .loginProcessingUrl("/authenticateTheUser").permitAll()//check user name and
		 * pass provided by Spring. .and().logout().permitAll();//adding log out support
		 */

		// now we will authorised on basis of roles
		http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER").antMatchers("/manager/**")
				.hasRole("MANAGER").antMatchers("/system/**").hasRole("ADMIN").and().formLogin()
				.loginPage("/showMyFancyLoginPage")// my loginiN page
				.loginProcessingUrl("/authenticateTheUser").permitAll()// check user name and pass provided by Spring.
				.and().logout().permitAll()// adding log out support
				.and().exceptionHandling().accessDeniedPage("/access_denied");// custom access denied page

	}

}
