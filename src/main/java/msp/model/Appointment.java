package msp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@JsonIgnoreProperties({"yourAppointments","userAppointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
    private User appointmentUser;
	
	@JsonIgnoreProperties({"yourAppointments","userAppointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
    private User appointmentAuthor;

	@JsonIgnoreProperties({"appointments", "users"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lecture_id")
    private Lecture subject;
	
	@Column(name = "date")
    private String date;
	
	@Column(name = "time")
    private String time;
	
	@Column(name = "accepted")
    private boolean accepted;
	
	public Appointment() {
		
	}

    public Appointment(int id, User appointmentUser, User appointmentAuthor, Lecture subject, String date, String time, boolean accepted){
    	this.id = id;
        this.appointmentUser = appointmentUser;
        this.appointmentAuthor = appointmentAuthor;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.accepted = accepted;
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

    public void setTime(String time) {
        this.time = time;
    }
    
    public boolean getAccepted() {
        return this.accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
}