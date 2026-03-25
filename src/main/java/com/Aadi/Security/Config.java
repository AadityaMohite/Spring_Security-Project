package com.Aadi.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Aadi.Service.CustomUserdaetails;

@Configuration
@EnableWebSecurity
public class Config {

	@Autowired
	CustomUserdaetails customUserdaetails;
	
	@Bean
	public DaoAuthenticationProvider authinticateuser() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserdaetails);
		
		provider.setPasswordEncoder(encoder());
		
		return provider;
		
	}
	
	
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	@Bean
	public SecurityFilterChain filterchain (HttpSecurity http) {
		
		http.csrf(csrf->csrf.disable());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers("/api/v1/employee/save").hasRole("ADMIN");
			auth.requestMatchers("/api/v1/employee/all").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/get/**").hasAnyRole("USER","ADMIN");
			auth.requestMatchers("/api/v1/employee/update/**").hasRole("ADMIN");
			auth.requestMatchers("/api/v1/employee/delete/**").hasRole("ADMIN");
			auth.requestMatchers("/api/v1/employee/byfirstname").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/bydesignation").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/byage").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/byaddress").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/bygender").hasRole("USER");
			auth.requestMatchers("/api/v1/employee/bysalary").hasRole("USER");
			auth.requestMatchers("/auth/save-user").permitAll();
		});
		
	      return	http.build();
		
		
	}
	
	
	
	
}
