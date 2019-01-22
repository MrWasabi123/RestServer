package msp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
	
	@Id
    @Column(name = "appointment_id")
	private int id;
	
	@JsonIgnoreProperties({"appointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
    private User appointmentUser;
	
	@JsonIgnoreProperties({"appointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
    private User appointmentAuthor;

	@JsonIgnoreProperties({"appointments", "users"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lecture_id")
    private Lecture subject;
	
	@Column(name = "date")
    private String date;
	
	@Column(name = "time")
    private String time;
	
	public Appointment() {
		
	}

    public Appointment(int id, User appointmentUser, User appointmentAuthor, Lecture subject, String date, String time){
    	this.id = id;
        this.appointmentUser = appointmentUser;
        this.appointmentAuthor = appointmentAuthor;
        this.subject = subject;
        this.date = date;
        this.time = time;
    }

    
    //-------------- Getter and Setter -------------------------------

    public User getAppointmentAuthor() {
		return appointmentAuthor;
	}

	public void setAppointmentAuthor(User appointmentAuthor) {
		this.appointmentAuthor = appointmentAuthor;
	}
	
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public User getAppointmentUser() {
        return appointmentUser;
    }

    public void setAppointmentUser(User appointmentUser) {
        this.appointmentUser = appointmentUser;
    }

    public Lecture getSubject() {
        return subject;
    }

    public void setSubject(Lecture subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String plan) {
        this.time = time;
    }
    
}