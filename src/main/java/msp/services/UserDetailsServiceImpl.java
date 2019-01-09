package msp.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import msp.repositories.UserRepository;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		System.out.println("load User "+ email);
		List<msp.model.User> users = userRepository.findAll();
		msp.model.User user = null;
		for(msp.model.User u: users) {
			System.out.println("copare User "+ u.getName());
			if(u.getEmail().equals(email)) {
				System.out.println("found User "+ email);
				user = u;
				break;
			}
		}
		
		if (user == null) {
			System.out.println("Error: User is null; in: UserDetailsService");
			throw new UsernameNotFoundException(email);
		}			
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole());
		String encodedPassword = passwordEncoder().encode(user.getPassword());
		UserDetails userDetails = (UserDetails)new User(user.getName(), encodedPassword, user.isEnabled(), true, true, true, Arrays.asList(authority));
		return userDetails;
		
	}
}
