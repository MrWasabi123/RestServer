package msp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msp.model.User;
import msp.services.UserServiceImpl;


@RestController
public class MainController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = "/all")
	public List<User> getAllUsers(){
		System.out.println("something");
		
		return userService.findAllUsers();
	}
	
	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable Long id){
		return userService.findUserById(id);
	}
	
	@PostMapping(value = "/load")
	public List<User> addUser(@RequestBody final User user){
		userService.saveUser(user);
		return userService.findAllUsers();
	}
	
//	@PostMapping(value = "/login")
//	public User loginUser(@RequestBody final User user){
//		List<User> users = userService.findAllUsers();
//		if (users.contains(user)) {
//			return user;
//		} else {
//			return null;
//		}
//	}
	
//	@PostMapping(value = "/register")
//	public User registerUser(){
//		List<User> users = userService.findAllUsers();
//		if (users.contains(user)) {
//			return null;
//		} else {
//			userService.saveUser(user);
//			return user;
//		}
//	}
}