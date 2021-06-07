package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService service; 
	
	@PostMapping("/save-user")
	@Transactional
	@CrossOrigin
	public String registerUser(@RequestBody User user) {
		service.saveMyUser(user);
		return "Hello, "+user.getFirstname()+ " your registration is successful!";
	}
	
	@GetMapping("/all-users")
	@CrossOrigin
	public Iterable<User> ShowAllUsers(){
		return service.ShowAllUsers();
	}
	
	@GetMapping("/delete/{firstname}")
	@Transactional
	@CrossOrigin
	public Iterable<User> deleteUser(@PathVariable String firstname){
		return service.deleteUserByFirstname(firstname);
	}
	@GetMapping("/search/{firstname}")
	@CrossOrigin	
	public User searchUser(@PathVariable String firstname) {
		return service.findByFirstname(firstname);
	}
}
