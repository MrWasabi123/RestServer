package services;

import java.util.List;

import msp.model.User;

public interface UserService {
	
	User findUserById(Long id);
	List<User> findAllUsers();

}
