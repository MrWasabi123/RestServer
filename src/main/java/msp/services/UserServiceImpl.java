package msp.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import msp.model.Lecture;
import msp.model.User;
import msp.model.UserUpdate;
import msp.repositories.LectureRepository;
import msp.repositories.RatingRepository;
import msp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService { //

	private UserRepository userRepository;
	private LectureRepository lectureRepository;
	private RatingRepository ratingRepository;

	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	public UserServiceImpl(UserRepository userRepository, LectureRepository lectureRepository, RatingRepository ratingRepository) {
		this.userRepository = userRepository;
		this.lectureRepository = lectureRepository;
		this.ratingRepository = ratingRepository;
	}
	

	@Override
	public msp.model.User findUserById(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public List<msp.model.User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
    public void save(User user) {
        //user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setUserRole("USER");
        //Test
        Set<Lecture> set = new HashSet<>();
        Set<Lecture> set2 = user.getLectures();
        for(Lecture l : set2) {
        	set.add(lectureRepository.findById((long)l.getId()).get());
        }
        
        user.setLectures(set);
        
        userRepository.save(user);
    }

	@Override
	public User updateUser(UserUpdate update, Long id) {
		User user = userRepository.findById(id).get();
		user.setNickname(update.getNickname());
		//user.setSubject(update.getSubject());
		user.setSubject(null);
		user.setStudies(update.getStudies());
		user.setPlan(update.getPlan());
		userRepository.save(user);
		
		return user;
	}
	
	@Override
	public User editUser(User user) {
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
	public User findUserByFirebaseId(String firebase) {
		List<User> users = userRepository.findAll();
		User user = null;
		for(User u: users) {
			if(u.getFirebaseId().equals(firebase)) {
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


	public RatingRepository getRatingRepository() {
		return ratingRepository;
	}

	public void setRatingRepository(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	

}
