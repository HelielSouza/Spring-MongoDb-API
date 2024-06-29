package com.workhop.apimongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workhop.apimongo.domain.User;
import com.workhop.apimongo.dtos.UserDTO;
import com.workhop.apimongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll () {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list
									.stream()
									.map(x -> new UserDTO(x))
									.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<UserDTO> findByID(@PathVariable String id) {
		User obj = service.findByID(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}