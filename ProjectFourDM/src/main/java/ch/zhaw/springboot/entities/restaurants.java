package ch.zhaw.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class restaurants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany (mappedBy = "matchedRestaurants")
    Set<User> matches;
	
	private String name;
	private long vertragsStart;
	private long vertragsEnde;
	
	public restaurants() {
		
	}
	
	

	public restaurants(String name, long vertragsStart, long vertragsEnde) {
		super();
		this.name = name;
		this.vertragsStart = vertragsStart;
		this.vertragsEnde = vertragsEnde;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getVertragsStart() {
		return vertragsStart;
	}

	public void setVertragsStart(long vertragsStart) {
		this.vertragsStart = vertragsStart;
	}

	public long getVertragsEnde() {
		return vertragsEnde;
	}

	public void setVertragsEnde(long vertragsEnde) {
		this.vertragsEnde = vertragsEnde;
	}


	public long getId() {
		return id;
	}
	
}
