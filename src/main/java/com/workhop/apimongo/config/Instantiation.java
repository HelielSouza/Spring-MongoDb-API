package com.workhop.apimongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workhop.apimongo.domain.Post;
import com.workhop.apimongo.domain.User;
import com.workhop.apimongo.dtos.AuthorDTO;
import com.workhop.apimongo.repositories.PostRepository;
import com.workhop.apimongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User johnes = new User(null, "Johnes May", "johnes@gmail.com");
		User suzanna = new User(null, "Suzanna Johnson", "suzi@gmail.com");
		User kvara = new User(null, "Khvicha Kvaratskhelia", "kvara@gmail.com");
		
		userRepository.saveAll(Arrays.asList(johnes, suzanna, kvara));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Bora", "Bora dar uma saida hahaha", new AuthorDTO(kvara));
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Tá dificil...", "Será que meu time ganha hoje? ... ", new AuthorDTO(johnes));
		Post post3 = new Post(null, sdf.parse("23/03/2018"), "Bom domingo!", "Qual a boa de hoje ein?", new AuthorDTO(johnes));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		kvara.getPosts().addAll(Arrays.asList(post1));
		johnes.getPosts().addAll(Arrays.asList(post2, post3));
		
		userRepository.saveAll(Arrays.asList(kvara, johnes));
	}
}

