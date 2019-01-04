package services;

/*
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
	}
	
	@Override
	public User findUserById(Long id) {
		
		ArrayList<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setName("Wanja");
		User user2 = new User();
		user2.setName("Lydia");
		
		//return user1;
		return userRpository.getOne(id);
	}

	@Override
	public List<User> findAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setName("Wanja");
		User user2 = new User();
		user2.setName("Lydia");
		
		//return users;
		return userRpository.findAll();
	}

}
*/
