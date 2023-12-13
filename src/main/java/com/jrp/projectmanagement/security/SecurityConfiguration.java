package com.jrp.projectmanagement.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration{
//     @Bean
// 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// 		http
// 			.authorizeHttpRequests((requests) -> requests
//                 .requestMatchers("/projects/new-project").hasRole("ADMIN")
//                 .requestMatchers("/employees/new-employee").hasRole("ADMIN")
// 				.anyRequest().authenticated()
// 			)
// 			.formLogin((form) -> form
// 				.loginPage("/login")
// 				.permitAll()
// 			)   
// 			.logout((logout) -> logout.permitAll());

// 		return http.build();
// 	}
    
//     @Bean
// 	public UserDetailsService userDetailsService() {
// 		UserDetails user =
// 			 User.withDefaultPasswordEncoder()
// 				.username("user")
// 				.password("password")
// 				.roles("USER")
// 				.build();
// 		UserDetails admin =
// 			 User.withDefaultPasswordEncoder()
// 				.username("ayush")
// 				.password("sahu")
// 				.roles("ADMIN")
// 				.build();

// 		return new InMemoryUserDetailsManager(user,admin);

//Another method to do the above task
	// @Bean
	// InMemoryUserDetailsManager users(){
	// 	return new InMemoryUserDetailsManager( 
	// 		User.withUsername("ayush")
	// 			.password("{noop}haley")
	// 			.roles("ADMIN")
	// 			.build()
	// 		,
	// 		User.withUsername("sahu")
	// 			.password("{noop}9008")
	// 			.roles("USER")
	// 			.build()
	// 	);
	// }
// 	}



    
// }



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)   
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
    
	@Bean
	JdbcUserDetailsManager users(@Autowired DataSource dataSource){
		JdbcUserDetailsManager jdbcUserDetailsManager =  new JdbcUserDetailsManager(dataSource);
		
		return jdbcUserDetailsManager;
	}

	@Bean
	InMemoryUserDetailsManager users1(){
		return new InMemoryUserDetailsManager(
			User.withUsername("Ayush")
				.password("{noop}hello")
				.roles("ADMIN")
				.build()
		);
	}
}