package msp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import msp.model.Appointment;
import msp.model.Lecture;
import msp.model.Rating;
import msp.model.User;
import msp.model.UserUpdate;
import msp.services.LectureServiceImpl;
import msp.services.UserServiceImpl;


@RestController
public class MainController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	LectureServiceImpl lectureService;
	
	@RequestMapping(value = "/all")
	public List<User> getAllUsers(){
		List<User> mappings = new ArrayList<>();
		for(User u: userService.findAllUsers()) {
			mappings.add(getMapping(u));
		}
		return mappings;
	}
	
//	@RequestMapping(value = "/all/{id}")
//	public User getUser(@PathVariable Long id){
//		return userService.findUserById(id);
//	}
	
	@RequestMapping(value = "/all/{email}")
	public User getUser(@PathVariable String email){
		return getMapping(userService.findUserByEmail(email));
	}
	
	@RequestMapping(value = "/users/{firebase}")
	public User getFireUser(@PathVariable String firebase){
		return getMapping(userService.findUserByFirebaseId(firebase));
	}
	
	@RequestMapping(value = "/lectures", method = RequestMethod.GET)
	public List<Lecture> getAllLectures(){
		return lectureService.findAllLectures();
	}
	
	@RequestMapping(value = "/lectures/{searchQuerry},{size}", method = RequestMethod.GET)
	public List<Lecture> getLectures(@PathVariable String searchQuerry, @PathVariable int size){
		try {
			long id = (long) Integer.parseInt(searchQuerry);
			return lectureService.findById(id, size);
		}catch(Exception e) {
			
		}
		return lectureService.findAllBySearchQuerry(searchQuerry, size);
	}
	
	@RequestMapping(value = "/lecture", method = RequestMethod.POST)
	public void addLectures(@RequestBody Lecture lecture){
		lectureService.save(lecture);
	}
	
	@RequestMapping(value = "/lectures", method = RequestMethod.POST)
	public void addAllLectures(@RequestBody List<Lecture> lectures){
		for(Lecture l: lectures) {
			lectureService.save(l);
		}
	}

	@RequestMapping(value = "/tutors/{id}", method = RequestMethod.GET)
	public List<User> getAllTutors(@PathVariable long id){
		List<User> mappings = new ArrayList<>();
		for(User u: userService.findAllTutors(id)) {
			mappings.add(getMapping(u));
		}
		return mappings;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public User updateUser(@PathVariable Long id, @RequestBody UserUpdate update) {
		return getMapping(userService.updateUser(update, id));
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public User updateUser(@PathVariable Long id) {
		return getMapping(userService.findUserById(id));
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) {
		
		return getMapping(userService.findUserByEmail(user.getEmail()));
		
	}

	@RequestMapping(value = "/rating/add/{userId}", method = RequestMethod.POST)
	public User addRating(@PathVariable Long userId, @RequestBody Rating rating) {
		User user = userService.findUserById(userId);
		User author = userService.findUserById(rating.getAuthor().getId());
		user.addUserRating(rating);
		//author.addYourRating(rating);
		userService.editUser(user);
		//userService.editUser(author);
		return getMapping(author);
	}
	
	@RequestMapping(value = "/rating/remove/{userId}", method = RequestMethod.POST)
	public User removeRating(@PathVariable Long userId, @RequestBody Rating rating) {
		User user = userService.findUserById(userId);
		User author = userService.findUserById(rating.getAuthor().getId());
		user.removeUserRating(rating);
		//author.removeYourRating(rating);
		userService.editUser(user);
		//userService.editUser(author);
		return getMapping(author);
	}
	
	@RequestMapping(value = "/appointment/add/{userId}", method = RequestMethod.POST)
	public User addAppointment(@PathVariable Long userId, @RequestBody Appointment appointment) {
		User user = userService.findUserById(userId);
		User author = userService.findUserById(appointment.getAppointmentAuthor().getId());
		user.addAppointment(appointment);
		//author.addAppointment(appointment);
		userService.editUser(user);
		//userService.editUser(author);
		return getMapping(author);
	}
	
	@RequestMapping(value = "/appointment/remove/{userId}", method = RequestMethod.POST)
	public User removeAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		User user = userService.findUserById(id);
		User author = userService.findUserById(appointment.getAppointmentAuthor().getId());
		user.removeAppointment(appointment);
		//author.removeAppointment(appointment);
		userService.editUser(user);
		//userService.editUser(author);
		return getMapping(author);
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User registration(@RequestBody User user, BindingResult bindingResult) {
		
        userService.save(user);
		
        return user;
    }
	
	public User getMapping(User user) {
//		Set<String> strings = new HashSet<>();
//		Field[] fields = User.class.getDeclaredFields();
//		for(int i=0; i<fields.length; i++) {
//			if(!fields[i].getName().equals("password")){
//				strings.add(fields[i].getName());
//			}
//		}
//		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(strings);
//
//	    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//	    MappingJacksonValue mapping = new MappingJacksonValue(user);
//
//	    mapping.setFilters(filters);
	   
		user.setPassword("");
	    
	    return user;
	}
}