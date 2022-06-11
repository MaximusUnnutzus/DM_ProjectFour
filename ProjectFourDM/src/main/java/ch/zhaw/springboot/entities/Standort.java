package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Standort{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String Strasse;
	private String Stadt;
	private int PLZ;
	
	public Standort() {
		
	}
	
	
	@ManyToOne
	private restaurants restaurant;
	
	

	public Standort(String Strasse, String Stadt, int PLZ) {
		super();
		this.Strasse = Strasse;
		this.Stadt = Stadt;
		this.PLZ = PLZ;
	}

	public String getStrasse() {
		return Strasse;
	}

	public void setStrasse(String Strasse) {
		this.Strasse = Strasse;
	}

	public String getStadt() {
		return Stadt;
	}

	public void setStadt(String Stadt) {
		this.Stadt = Stadt;
	}

	public int getPLZ() {
		return PLZ;
	}

	public void setPLZ(int PLZ) {
		this.PLZ = PLZ;
	}


	public long getId() {
		return id;
	}
	
}
