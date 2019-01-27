package msp.services;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import msp.model.Appointment;
import msp.model.Lecture;
import msp.model.Rating;
import msp.model.User;
import msp.model.UserUpdate;
import msp.repositories.AppointmentRepository;
import msp.repositories.LectureRepository;
import msp.repositories.RatingRepository;
import msp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService { //

	private UserRepository userRepository;
	private LectureRepository lectureRepository;
	private RatingRepository ratingRepository;
	private AppointmentRepository appointmentRepository;

	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	public UserServiceImpl(UserRepository userRepository, LectureRepository lectureRepository, RatingRepository ratingRepository, AppointmentRepository appointmentRepository) {
		this.userRepository = userRepository;
		this.lectureRepository = lectureRepository;
		this.ratingRepository = ratingRepository;
		this.appointmentRepository = appointmentRepository;
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
        
        Set<Rating> yourRatingsSet = new HashSet<>();
        Set<Rating> yourRatingsSetUpdate = user.getYourRatings();
        for(Rating r : yourRatingsSetUpdate) {
        	long ratingId = r.getId();
        	Rating currentRating = ratingRepository.findById(ratingId).get();
        	yourRatingsSet.add(currentRating);
        }
        user.setYourRatings(yourRatingsSet);
        
        Set<Rating> userRatingsSet = new HashSet<>();
        Set<Rating> userRatingsSetUpdate = user.getUserRatings();
        for(Rating r : userRatingsSetUpdate) {
        	long ratingId = r.getId();
        	Rating currentRating = ratingRepository.findById(ratingId).get();
        	userRatingsSet.add(currentRating);
        }
        user.setUserRatings(userRatingsSet);
        
        Set<Appointment> appointmentSet = new HashSet<>();
        Set<Appointment> appointmentSetUpdate = user.getAppointments();
        for(Appointment a : appointmentSetUpdate) {
        	long appointmentId = a.getId();
        	Appointment currentAppointment = appointmentRepository.findById(appointmentId).get();
        	appointmentSet.add(currentAppointment);
        }
        
        user.setAppointments(appointmentSet);
        

		String encoded = passwordEncoder().encode(user.getPassword());
		user.setPassword(encoded);
		
        
        userRepository.save(user);
    }

	@Override
	public User updateUser(UserUpdate update, Long id) {
		User user = userRepository.findById(id).get();
		user.setNickname(update.getNickname());
		user.setSubject(null);
		
		Set<Lecture> set = new HashSet<>();
        Set<Lecture> set2 = update.getLectures();
        if(set2 != null) {
	        for(Lecture l : set2) {
	        	Long lectureId = (long) l.getId();
	        	Lecture currentLecture = lectureRepository.findById(lectureId).get();
	        	set.add(currentLecture);
	        }
        }
        user.setLectures(set);
        
        Set<Rating> yourRatingsSet = new HashSet<>();
        Set<Rating> yourRatingsSetUpdate = update.getYourRatings();
        if(yourRatingsSetUpdate != null) {
	        for(Rating r : yourRatingsSetUpdate) {
	        	long ratingId = r.getId();
	        	Rating currentRating = ratingRepository.findById(ratingId).get();
	        	yourRatingsSet.add(currentRating);
	        }
        }
        user.setYourRatings(yourRatingsSet);
        
        Set<Rating> userRatingsSet = new HashSet<>();
        Set<Rating> userRatingsSetUpdate = update.getUserRatings();
        if(userRatingsSetUpdate != null) {
	        for(Rating r : userRatingsSetUpdate) {
	        	long ratingId = r.getId();
	        	Rating currentRating = ratingRepository.findById(ratingId).get();
	        	userRatingsSet.add(currentRating);
	        }
        }
        user.setUserRatings(userRatingsSet);
        
        Set<Appointment> appointmentSet = new HashSet<>();
        Set<Appointment> appointmentSetUpdate = update.getAppointments();
        if(appointmentSetUpdate != null) {
	        for(Appointment a : appointmentSetUpdate) {
	        	long appointmentId = a.getId();
	        	Appointment currentAppointment = appointmentRepository.findById(appointmentId).get();
	        	appointmentSet.add(currentAppointment);
	        }
        }
        user.setAppointments(appointmentSet);
         
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
