package com.actour.api.dao;

public class ProductModelForRecommand {

	private Integer id;
	private String title;
	private String date;
	private String nation;
	private Double totlaTime;
	private Integer money;
	private Integer ownerId;
	private Double adventure;
	private Double eater;
	private Double photo;
	private Double actor;
	private Double healing;


	public ProductModelForRecommand(Integer id, String title, String date, String nation, Double totlaTime, Integer money,
			Integer ownerId, Double adventure, Double eater, Double photo, Double actor, Double healing) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.nation = nation;
		this.totlaTime = totlaTime;
		this.money = money;
		this.ownerId = ownerId;
		this.adventure = adventure;
		this.eater = eater;
		this.photo = photo;
		this.actor = actor;
		this.healing = healing;
	}

	public Double getAdventure() {
		return adventure;
	}

	public void setAdventure(Double adventure) {
		this.adventure = adventure;
	}

	public Double getEater() {
		return eater;
	}

	public void setEater(Double eater) {
		this.eater = eater;
	}

	public Double getPhoto() {
		return photo;
	}

	public void setPhoto(Double photo) {
		this.photo = photo;
	}

	public Double getActor() {
		return actor;
	}

	public void setActor(Double actor) {
		this.actor = actor;
	}

	public Double getHealing() {
		return healing;
	}

	public void setHealing(Double healing) {
		this.healing = healing;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Double getTotlaTime() {
		return totlaTime;
	}

	public void setTotlaTime(Double totlaTime) {
		this.totlaTime = totlaTime;
	}
}
