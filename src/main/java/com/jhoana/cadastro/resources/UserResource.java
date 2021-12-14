package com.jhoana.cadastro.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhoana.cadastro.entities.User;
import com.jhoana.cadastro.services.UserService;


@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("User")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/findByUser")
	public ResponseEntity<Boolean> findByUser(@RequestBody User user) {
		boolean obj = service.findByUser(user);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		User obj = service.createUser(user);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		User obj = service.createUser(user);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(service.deleteUser(id));
	}
}
