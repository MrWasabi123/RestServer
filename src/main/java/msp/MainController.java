package msp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import msp.model.User;
import msp.model.UserUpdate;
import msp.services.UserServiceImpl;


@RestController
public class MainController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = "/all")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
//	@RequestMapping(value = "/all/{id}")
//	public User getUser(@PathVariable Long id){
//		return userService.findUserById(id);
//	}
	
	@RequestMapping(value = "/all/{email}")
	public User getUser(@PathVariable String email){
		return userService.findUserByEmail(email);
	}
	
	@RequestMapping(value = "/tutors/{id}", method = RequestMethod.GET)
	public List<User> getAllTutors(@PathVariable long id){
		return userService.findAllTutors(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public User updateUser(@PathVariable Long id, @RequestBody UserUpdate update) {
		return userService.updateUser(update, id);
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) {
		return userService.findUserByEmail(user.getEmail());
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User registration(@RequestBody User user, BindingResult bindingResult) {
		
//		String decode = userForm.getEncode();
//		String result = new String(Base64.getDecoder().decode(decode.getBytes()));
//		User user = new User();
//		user.setEmail(userForm.getEmail());
//		user.setPassword(userForm.getPassword());
//		user.setName(userForm.getUsername());
//		user.setFirebaseId(userForm.getFirebaseId());
//		System.out.println("User: "+ userForm.getEmail()+ "; "+userForm.getPassword()+" is registerd.");
        userService.save(user);
		
        return user;
    }
}