package com.anuj.project.flipkartTest.apipojo;

import java.util.Map;

public class UserHistory {
	int userId;
	Map<Integer, Integer> adHistory;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Map<Integer, Integer> getAdHistory() {
		return adHistory;
	}

	public void setAdHistory(Map<Integer, Integer> adHistory) {
		this.adHistory = adHistory;
	}

}
