package services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import msp.model.User;
import msp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRpository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRpository = userRepository;
		System.out.println("user count service: " + userRepository.count());
		
		User user1 = new User();
		user1.setId(1);
		user1.setName("Wanja");
		userRpository.save(user1);
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("Lydia");
		userRpository.save(user2);
	}
	
	@Override
	public User findUserById(Long id) {
		
		//return user1;
		return userRpository.findById(id).get();
	}

	@Override
	public List<User> findAllUsers() {
		
		//return users;
		return userRpository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRpository.save(user);
	}

}
