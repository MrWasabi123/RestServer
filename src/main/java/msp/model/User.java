package msp.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	@Id
    private long id;
    private String name;
    private String email;
    private String nickname;
    private String password;
    private String studies;
    private String subject;
    private String plan;
    private int ratings;

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
    
    @Override
    public String toString() {
    	return String.format(
                "User[id=%d, Name='%s', NickName='%s']",
                id, name, nickname);
    }

    
    
    
    
    
    
	public Set<UserRole> getUserRole() {
		return null;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}

