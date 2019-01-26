package msp.model;

import java.io.Serializable;
import java.util.Set;

public class UserUpdate implements Serializable{
	
	 private String nickname;
	 private Set<Lecture> lectures;
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
