package com.anuj.project.flipkartTest.apipojo;

import java.util.Map;

public class Merchants {
	private int merchantId;
	private String Name;
	private Map<Integer, Ad> ad;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Map<Integer, Ad> getAd() {
		return ad;
	}

	public void setAd(Map<Integer, Ad> ad) {
		this.ad = ad;
	}

	public Merchants(int merchantId, String name, Map<Integer, Ad> ad) {
		super();
		this.merchantId = merchantId;
		Name = name;
		this.ad = ad;
	}

	public Merchants() {
		super();
	}

}
