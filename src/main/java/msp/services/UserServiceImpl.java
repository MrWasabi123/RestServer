package msp.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import msp.model.UserRole;
import msp.repositories.UserRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService { //

	private UserRepository userRpository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRpository = userRepository;
		System.out.println("user count service: " + userRepository.count());
		
		//Test
		msp.model.User user1 = new msp.model.User();
		user1.setId(1);
		user1.setName("Wanja");
		user1.setEmail("test@test.de");
		userRpository.save(user1);
		
		msp.model.User user2 = new msp.model.User();
		user2.setId(2);
		user2.setName("Lydia");
		user2.setEmail("test2@test.de");
		userRpository.save(user2);
	}
	

	@Override
	public msp.model.User findUserById(Long id) {
		return userRpository.findById(id).get();
	}

	@Override
	public List<msp.model.User> findAllUsers() {
		return userRpository.findAll();
	}

	@Override
	public void saveUser(msp.model.User user) {
		userRpository.save(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		
		List<msp.model.User> users = userRpository.findAll();
		msp.model.User user = null;
		for(msp.model.User u: users) {
			if(u.getName() == name) {
				user = u;
				break;
			}
		}
		
		if (user == null) {
			throw new UsernameNotFoundException(name);
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
		
	}
	
	private User buildUserForAuthentication(msp.model.User user, List<GrantedAuthority> authorities) {
			
		return new User(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
