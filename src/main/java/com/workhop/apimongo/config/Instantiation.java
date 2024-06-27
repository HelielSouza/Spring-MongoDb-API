package com.workhop.apimongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workhop.apimongo.domain.User;
import com.workhop.apimongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User johnes = new User(null, "Johnes May", "johnes@gmail.com");
		User suzanna = new User(null, "Suzanna Johnson", "suzi@gmail.com");
		User kvara = new User(null, "Khvicha Kvaratskhelia", "kvara@gmail.com");
		
		userRepository.saveAll(Arrays.asList(johnes, suzanna, kvara));
	}

}

