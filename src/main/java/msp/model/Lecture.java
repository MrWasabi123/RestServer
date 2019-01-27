package msp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lecture")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lecture implements Serializable{

    @Id
    @Column(name = "lecture_id")
    private long id;
    @Column(name = "name")
    private String name;
    
    
    @ManyToMany(mappedBy = "lectures")
    //@JsonIgnoreProperties("lectures")
    private Set<User> users;
    
    @OneToMany(mappedBy = "subject", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    public Lecture(){

    }

    public Lecture(String name, long id){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<User> getUsers(){
    	return users;
    }
    
    public void setUsers(Set<User> users) {
    	this.users = users;
    }
}
