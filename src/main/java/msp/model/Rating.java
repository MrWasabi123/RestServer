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
@Table(name = "rating")
public class Rating implements Serializable{

	@Id
    @Column(name = "rating_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "stars")
    private int stars;
	@Column(name = "description")
    private String description;
	
	@JsonIgnoreProperties({"yourAppointments","userAppointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnoreProperties({"yourAppointments","userAppointments", "yourRatings", "userRatings", "lectures", "userRole", "enabled", "password"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private User author;

    public Rating(){

    }

    public Rating(int id, int stars, String description){
    	this.id = id;
        this.stars = stars;
        this.description = description;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setAuthor(User author) {
    	this.author = author;
    }
    
    public User getAuthor() {
    	return this.author;
    }
}
