package msp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msp.model.User;
import msp.repositories.UserRepository;


@RestController
public class MainController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/all")
	public List<User> getAllUsers(){
		System.out.println("something");
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/load")
	public List<User> addUser(@RequestBody final User user){
		userRepository.save(user);
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/login")
	public User loginUser(@RequestBody final User user){
		List<User> users = userRepository.findAll();
		if (users.contains(user)) {
			return user;
		} else {
			return null;
		}
	}
	
	@PostMapping(value = "/register")
	public User registerUser(@RequestBody final User user){
		List<User> users = userRepository.findAll();
		if (users.contains(user)) {
			return null;
		} else {
			userRepository.save(user);
			return user;
		}
	}
}