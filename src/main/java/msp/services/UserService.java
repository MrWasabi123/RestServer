package msp.services;

import java.util.List;


import msp.model.User;
import msp.model.UserUpdate;

public interface UserService {
	
	User findUserById(Long id);
	List<User> findAllUsers();
	void save(User user);
	User updateUser(UserUpdate update, Long id);
	User findUserByEmail(String email);
	List<User> findAllTutors(long id);

}
