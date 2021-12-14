package com.jhoana.cadastro.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhoana.cadastro.entities.User;
import com.jhoana.cadastro.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		var a = repository.findAll();
		return a;
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public boolean findByUser(User user) {
		List<User> users = repository.findAll();
		boolean ehVerdadeiro = false;
		
		for (int i=0; i < users.size(); i++) {
	        if (users.get(i).getName().equals(user.getName()) && (users.get(i).getPassword().equals(user.getPassword()))) {
	        	ehVerdadeiro = true;
	        }
	    }
		
		
		return ehVerdadeiro;
	}
	
	public User createUser(User user) {
		var userSaved = repository.save(user);
		
		return userSaved;
	}
	
	
	public Boolean deleteUser(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
