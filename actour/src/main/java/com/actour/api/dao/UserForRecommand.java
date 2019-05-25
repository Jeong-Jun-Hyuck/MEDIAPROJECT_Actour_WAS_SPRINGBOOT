package com.actour.api.dao;

public class UserForRecommand {

	private int systemId;
	private String userName;
	private double adventure;
	private double eater;
	private double photo;
	private double actor;
	private double healing;
	
	
	public UserForRecommand(int systemId, String userName, double adventure, double eater, double photo, double actor,
			double healing) {
		super();
		this.systemId = systemId;
		this.userName = userName;
		this.adventure = adventure;
		this.eater = eater;
		this.photo = photo;
		this.actor = actor;
		this.healing = healing;
	}
	
	public int getSystemId() {
		return systemId;
	}
	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getAdventure() {
		return adventure;
	}
	public void setAdventure(double adventure) {
		this.adventure = adventure;
	}
	public double getEater() {
		return eater;
	}
	public void setEater(double eater) {
		this.eater = eater;
	}
	public double getPhoto() {
		return photo;
	}
	public void setPhoto(double photo) {
		this.photo = photo;
	}
	public double getActor() {
		return actor;
	}
	public void setActor(double actor) {
		this.actor = actor;
	}
	public double getHealing() {
		return healing;
	}
	public void setHealing(double healing) {
		this.healing = healing;
	}
	
}
