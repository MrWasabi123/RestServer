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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lecture")
public class Lecture implements Serializable{

    @Id
    @Column(name = "lecture_id")
    private int id;
    @Column(name = "name")
    private String name;
    
    
    @ManyToMany(mappedBy = "lectures")
    //@JsonIgnoreProperties("lectures")
    private Set<User> users;
    
    @OneToMany(mappedBy = "subject", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    public Lecture(){

    }

    public Lecture(String name, int id){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
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
