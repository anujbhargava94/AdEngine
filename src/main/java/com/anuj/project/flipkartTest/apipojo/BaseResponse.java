package com.anuj.project.flipkartTest.apipojo;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class BaseResponse<K> {
	private K responseData;
	private String responseMessage;

	public String getResponseData() {
		Gson jsonString = new Gson();
		return jsonString.toJson(responseData);
	}

	public void setResponseData(K responseData) {
		this.responseData = responseData;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
