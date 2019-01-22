package msp.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
    private long id;
	@Column(name = "name")
    private String name;
	@Column(name = "email")
    private String email;
	@Column(name = "nickname")
    private String nickname;
	@Column(name = "password")
	@JsonIgnore
    private String password;
	@Column(name = "studies")
    private String studies;
	@Column(name = "subject")
	private String subject;
	@Column(name = "plan")
    private String plan;
	@Column(name = "ratings")
	private int ratings;
	@Column(name = "enabled")
    private boolean enabled;
	@Column(name = "role")
    private String userRole;
    @Column(name = "firebase_id")
    private String firebaseId;
    @Column(name = "imageURL")
    private String imageURL;
    
   
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_lecture", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id"))
    @JsonIgnoreProperties("users")
    private Set<Lecture> lectures;
    
    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> userRatings;
    
    @JsonIgnoreProperties("author")
    @OneToMany(mappedBy = "author", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> yourRatings;
    
    @JsonIgnoreProperties("appointmentUser")
    @OneToMany(mappedBy = "appointmentUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
    

    
    public User(){

    }

    public User(long id, String name, String email, String password, String nickname, String studies, String subject, String plan, int ratings){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.studies = studies;
        this.subject = subject;
        this.plan = plan;
        this.ratings = ratings;
    }
    
    public User(String name, String password, boolean enabled) {
		this.name = name;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String name, String password, boolean enabled, String userRole) {
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	
    
    public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public Set<Lecture> getLectures() {
        return this.lectures;
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

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getPrivateInfo() {
        return "";
    }
    
    public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getFirebaseId() {
		return this.firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

    
    @Override
    public String toString() {
    	return String.format(
                "User[id=%d, Name='%s', NickName='%s']",
                id, name, nickname);
    }
}

