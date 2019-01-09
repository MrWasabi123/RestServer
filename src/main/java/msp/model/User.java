package msp.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String userRole;;

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

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
    
    @Override
    public String toString() {
    	return String.format(
                "User[id=%d, Name='%s', NickName='%s']",
                id, name, nickname);
    }
}

