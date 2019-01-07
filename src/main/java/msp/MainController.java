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
import msp.services.SecurityService;
import msp.services.UserServiceImpl;


@RestController
public class MainController {
	
	@Autowired
	UserServiceImpl userService;

//	@Autowired
//	private SecurityService securityService;
	
	@RequestMapping(value = "/all")
	public List<User> getAllUsers(){
		System.out.println("something");
		
		return userService.findAllUsers();
	}
	
	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable Long id){
		return userService.findUserById(id);
	}
	
//	@PostMapping(value = "/load")
//	public List<User> addUser(@RequestBody final User user){
//		userService.save(user);
//		return userService.findAllUsers();
//	}
	
//	@PostMapping(value = "/login")
//	public User loginUser(@RequestBody final User user){
//		List<User> users = userService.findAllUsers();
//		if (users.contains(user)) {
//			return user;
//		} else {
//			return null;
//		}
//	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }

        userService.save(userForm);

        //securityService.autologin(userForm.getName(), userForm.getPassword());

        return "redirect:/welcome";
    }
}