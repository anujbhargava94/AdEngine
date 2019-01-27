package com.anuj.project.flipkartTest.apipojo;

public class Ad {
	int adId;
	String adName;
	int budget;
	int lAge;
	int hAge;
	int bid;
	String gender;

	public Ad() {
		super();
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getlAge() {
		return lAge;
	}

	public void setlAge(int lAge) {
		this.lAge = lAge;
	}

	public int gethAge() {
		return hAge;
	}

	public void sethAge(int hAge) {
		this.hAge = hAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Ad(int adId, String adName, int budget, int lAge, int hAge, int bid, String gender) {
		super();
		this.adId = adId;
		this.adName = adName;
		this.budget = budget;
		this.lAge = lAge;
		this.hAge = hAge;
		this.bid = bid;
		this.gender = gender;
	}

}
