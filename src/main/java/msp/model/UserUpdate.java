package msp.model;

import java.io.Serializable;
import java.util.Set;

public class UserUpdate implements Serializable{
	
	 private String nickname;
	 private Set<Lecture> lectures;
	 private Set<Rating> yourRatings;
	 private Set<Rating> userRatings;
	 private Set<Appointment> userAppoinments;
	 private Set<Appointment> yourAppoinments;
	 private String subject;
	 private String plan;
	 private String image;
	 
	 
	 
	 public Set<Appointment> getUserAppoinments() {
		return userAppoinments;
	}
	public void setUserAppoinments(Set<Appointment> userAppoinments) {
		this.userAppoinments = userAppoinments;
	}
	public Set<Appointment> getYourAppoinments() {
		return yourAppoinments;
	}
	public void setYourAppoinments(Set<Appointment> yourAppoinments) {
		this.yourAppoinments = yourAppoinments;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Set<Lecture> getLectures() {
		return lectures;
	}
	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}
	public Set<Rating> getYourRatings() {
		return this.yourRatings;
	}
	public void setYourRatings(Set<Rating> yourRatings) {
		this.yourRatings = yourRatings;
	}
	public Set<Rating> getUserRatings() {
		return this.userRatings;
	}
	public void setUserRatings(Set<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	public Set<Appointment> getUserAppointments() {
		return this.userAppoinments;
	}
	public void setUserAppointments(Set<Appointment> appoinments) {
		this.userAppoinments = appoinments;
	}
	public Set<Appointment> getYourAppointments() {
		return this.yourAppoinments;
	}
	public void setYourAppointments(Set<Appointment> appoinments) {
		this.yourAppoinments = appoinments;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
}
