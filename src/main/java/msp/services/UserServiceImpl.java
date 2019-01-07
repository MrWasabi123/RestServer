package msp.services;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import msp.model.User;
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
		msp.model.User user1 = new msp.model.User();
		user1.setId(1);
		user1.setName("Wanja");
		user1.setEmail("test@test.de");
		userRepository.save(user1);
		
		msp.model.User user2 = new msp.model.User();
		user2.setId(2);
		user2.setName("Lydia");
		user2.setEmail("test2@test.de");
		userRepository.save(user2);
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
        user.setPassword(passwordEncoder().encode(user.getPassword()));
//        Set<UserRole> roles = new HashSet<>();
//        UserRole role = new UserRole();
//        role.setRole("Default");
//        roles.add(role);
//        user.setRoles(roles);
        userRepository.save(user);
    }
}
