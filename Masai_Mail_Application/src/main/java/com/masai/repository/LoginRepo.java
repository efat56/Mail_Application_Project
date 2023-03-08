package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {

	public Login findByEmail(String email);

}
