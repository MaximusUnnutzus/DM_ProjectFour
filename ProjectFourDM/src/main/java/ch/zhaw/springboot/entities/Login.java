package ch.zhaw.springboot.entities;
//Helo

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String passwort;
	
	@OneToOne
	private User user;
	
	public Login() {
		
	}

	public Login(String email, String passwort) {
		super();
		this.email = email;
		this.passwort = passwort;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}
	

}
