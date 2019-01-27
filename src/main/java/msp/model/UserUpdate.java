package msp.model;

import java.io.Serializable;
import java.util.Set;

public class UserUpdate implements Serializable{
	
	 private String nickname;
	 private Set<Lecture> lectures;
	 private Set<Rating> yourRatings;
	 private Set<Rating> userRatings;
	 private Set<Appointment> appoinments;
	 private String subject;
	 private String plan;
	 
	 
	 
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
	public Set<Appointment> getAppointments() {
		return this.appoinments;
	}
	public void setAppointments(Set<Appointment> appoinments) {
		this.appoinments = appoinments;
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
