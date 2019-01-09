package msp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import msp.model.BasicUser;
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
	
//	@PostMapping(value = "/login")
//	public User loginUser(@RequestBody final User user){
//		List<User> users = userService.findAllUsers();
//		if (users.contains(user)) {
//			return user;
//		} else {
//			return null;
//		}
//	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String signUp() {
		return "Hallo";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody BasicUser userForm, BindingResult bindingResult) {

		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		System.out.println(userForm.getPassword());
		user.setName(userForm.getUsername());
        userService.save(user);

        return "hallo";
    }
}