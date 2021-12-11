package com.jhoana.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhoana.cadastro.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
