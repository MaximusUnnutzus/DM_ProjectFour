package ch.zhaw.springboot.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity


public class Oeffnungszeit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String wochentag;
	private long startZeit;
	private long endZeit;
	
	@ManyToMany
	@JoinTable(
			  name = "Oeffnungszeit_Restaurant", 
			  joinColumns = @JoinColumn(name = "oeffnungszeit_id"), 
			  inverseJoinColumns = @JoinColumn(name = "restaurant_id"))

	Set<restaurants> matchOeffnungszeit;
	
	public Oeffnungszeit() {
		
	}
	
	public Oeffnungszeit(String wochentag, long startZeit, long endZeit) {
		super();
		this.wochentag = wochentag;
		this.startZeit = startZeit;
		this.endZeit = endZeit;
	}
	public String getWochentag() {
		return wochentag;
	}
	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}
	public long getStartZeit() {
		return startZeit;
	}
	public void setStartZeit(long startZeit) {
		this.startZeit = startZeit;
	}
	public long getEndZeit() {
		return endZeit;
	}
	public void setEndZeit(long endZeit) {
		this.endZeit = endZeit;
	}
	public long getId() {
		return id;
	}
	
	
	

}
