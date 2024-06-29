package com.workhop.apimongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workhop.apimongo.domain.User;
import com.workhop.apimongo.dtos.UserDTO;
import com.workhop.apimongo.repositories.UserRepository;
import com.workhop.apimongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByID (String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
	}
	
	public User insert (User obj) {
		return repository.insert(obj);
	}
	
	public void delete (String id) {
		findByID(id);
		repository.deleteById(id);
	}
	
	public User fromDTO (UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}