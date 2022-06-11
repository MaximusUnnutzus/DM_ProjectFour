package ch.zhaw.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String telefonnummer;
	
	@OneToOne
	private Login login;
	
	@ManyToMany
    
    @JoinTable(
    		  name = "User_Restaurant", 
    		  joinColumns = @JoinColumn(name = "user_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
	
	Set<restaurants> matchedRestaurants;
	

	
public User() {
		
	}
	
	

	public User(String name, String telefonnummer) {
	super();
	this.name = name;
	this.telefonnummer = telefonnummer;
	this.login = login;
}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}


	public long getId() {
		return id;
	}

	public Login getLogin() {
		return login;
	}
	
	
	
	
}
