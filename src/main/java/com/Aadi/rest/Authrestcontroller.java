package com.Aadi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aadi.entity.User;
import com.Aadi.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class Authrestcontroller {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Authrestcontroller(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Autowired
	public UserRepository userRepository;
	
	
	@PostMapping("/save-user")
	public ResponseEntity<User> saveuser(@RequestBody User user) {
		
		                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		                
		               if(user.getUsername().equals("Aadi")||user.getUsername().equals("Raj")) {
		            	   user.setRole("ADMIN");
		               }else {
		            	   user.setRole("USER");
		               }
		                
		                
		User saveduser =  userRepository.save(user);
		
		return new ResponseEntity<User>(saveduser,HttpStatus.CREATED);
		
	}
	
	
	
}
