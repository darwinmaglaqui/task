package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public Iterable<User> deleteByFirstname(String firstname);
	public User findByFirstname(String firstname);
}
