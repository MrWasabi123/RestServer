package msp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import msp.repositories.UserRepository;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		
		List<msp.model.User> users = userRepository.findAll();
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
		//List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
//		Set<GrantedAuthority> authorities = new HashSet<>();
//				authorities.add(new SimpleGrantedAuthority("Default"));
				
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole());
		UserDetails userDetails = (UserDetails)new User(user.getName(),
		user.getPassword(), Arrays.asList(authority));
		return userDetails;

		//return buildUserForAuthentication(user, authorities);
		
	}
	
	private User buildUserForAuthentication(msp.model.User user, Set<GrantedAuthority> authorities) {
			
		return new User(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
//
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
//
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//		return Result;
//	}

}
