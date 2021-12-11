package com.jhoana.cadastro.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhoana.cadastro.entities.User;

@RestController
@RequestMapping("User")
public class UserResource {

	@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
	@RequestMapping("/findAll")
	public ResponseEntity<User> findAll() {
		User u = new User(1L,"Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
