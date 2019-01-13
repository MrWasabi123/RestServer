package msp.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import msp.model.User;
import msp.model.UserUpdate;
import msp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService { //

	private UserRepository userRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		System.out.println("user count service: " + userRepository.count());
		
		//Test
//		msp.model.User user1 = new msp.model.User();
//		user1.setId(1);
//		user1.setName("Ju");
//		user1.setEmail("test3@test.de");
//		user1.setPassword("1");
//		user1.setUserRole("ADMIN");
//		userRepository.save(user1);
//		
//		msp.model.User user2 = new msp.model.User();
//		user2.setId(2);
//		user2.setName("Lydia");
//		user2.setEmail("test2@test.de");
//		user2.setPassword("321");
//		user2.setUserRole("ROLE_ADMIN");
//		userRepository.save(user2);
	}
	

	@Override
	public msp.model.User findUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<msp.model.User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
    public void save(User user) {
        //user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setUserRole("USER");
        userRepository.save(user);
    }

	@Override
	public User updateUser(UserUpdate update, Long id) {
		User user = userRepository.findById(id).get();
		user.setNickname(update.getNickname());
		user.setSubject(update.getSubject());
		user.setStudies(update.getStudies());
		user.setPlan(update.getPlan());
		userRepository.save(user);
		
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		List<User> users = userRepository.findAll();
		User user = null;
		for(User u: users) {
			if(u.getEmail().equals(email)) {
				user = u;
				break;
			}
		}
		return user;
	}

	@Override
	public List<User> findAllTutors(long id) {
		List<User> users = userRepository.findAll();
		List<User> result = new ArrayList<User>();
		for(User u: users) {
			if(u.getNickname() != null && u.getNickname().equals("Tutor") && u.getId() != id) {
				result.add(u);
			}
		}
		return result;
	}
}
