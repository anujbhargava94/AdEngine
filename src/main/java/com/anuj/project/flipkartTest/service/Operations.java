package com.anuj.project.flipkartTest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.anuj.project.flipkartTest.apipojo.Ad;
import com.anuj.project.flipkartTest.apipojo.DisplayAd;
import com.anuj.project.flipkartTest.apipojo.Merchants;
import com.anuj.project.flipkartTest.apipojo.User;
import com.anuj.project.flipkartTest.apipojo.UserHistory;

@Service
public class Operations {

	private static Map<Integer, Merchants> merchants = new HashMap<>();
	private Map<Integer, String> userVisitHistory = new HashMap<>();

	private DisplayAd displayAd;

	public Operations() {
		super();
	}

	static {
		Map<Integer, UserHistory> userVisit = new HashMap<>();
		Map<Integer, Ad> ads = new HashMap<>();

		Ad ad1 = new Ad(1, "mobile1", 20, 25, 35, 10, "M");
		Ad ad2 = new Ad(2, "mobile2", 100, 15, 24, 50, "M");
		Ad ad3 = new Ad(3, "mobile3", 100, 55, 58, 10, "F");
		Ad ad4 = new Ad(4, "mobile4", 100, 35, 50, 20, "M");
		ads.put(1, ad1);
		ads.put(2, ad2);
		ads.put(3, ad3);
		ads.put(4, ad4);

		Merchants merchant1 = new Merchants(1, "mobileMerchant", ads);
		Map<Integer, Ad> ads2 = new HashMap<>();

		Ad ad21 = new Ad(1, "cloth1", 100, 25, 30, 60, "M");
		Ad ad22 = new Ad(2, "cloth2", 100, 15, 20, 30, "M");
		Ad ad23 = new Ad(3, "cloth3", 100, 45, 60, 40, "M");
		Ad ad24 = new Ad(4, "cloth4", 100, 35, 40, 50, "F");
		ads2.put(1, ad21);
		ads2.put(2, ad22);
		ads2.put(3, ad23);
		ads2.put(4, ad24);

		Merchants merchant2 = new Merchants(2, "clothMerchant", ads2);
		merchants.put(merchant1.getMerchantId(), merchant1);
		merchants.put(merchant2.getMerchantId(), merchant2);
	}

	public DisplayAd displayAd(User user) {
		TreeMap<Integer, DisplayAd> suitableAds = new TreeMap<>();
		displayAd = new DisplayAd();
		if (merchants == null || merchants.isEmpty()) {
			displayAd.setAdName("No Suitable Ad");
			displayAd.setMerchantName(" ");
		}
		getFilteredAds(suitableAds, user);
		getHighestBidAd(suitableAds, user, displayAd);
		return displayAd;
	}

	private void getHighestBidAd(TreeMap<Integer, DisplayAd> suitableAds, User user, DisplayAd displayAd2) {
		if (suitableAds.isEmpty()) {
			displayAd.setAdName("No Suitable Ad");
			displayAd.setMerchantName(" ");
		} else {
			try {
				displayAd = suitableAds.lastEntry().getValue();
				Merchants selectedMerchant = new Merchants();
				selectedMerchant = merchants.get(displayAd.getMerchantId());
				Map<Integer, Ad> tempAds = new HashMap<>();
				Ad ad = new Ad();
				tempAds = selectedMerchant.getAd();
				ad = tempAds.get(displayAd.getAdId());
				ad.setBudget(ad.getBudget() - ad.getBid());
				tempAds.put(displayAd.getAdId(), ad);
				selectedMerchant.setAd(tempAds);
				merchants.put(displayAd.getMerchantId(), selectedMerchant);
			} catch (Exception e) {
				displayAd.setAdName("No Suitable Ad");
				displayAd.setMerchantName(" ");
			}
		}
	}

	private void getFilteredAds(TreeMap<Integer, DisplayAd> suitableAds, User user) {
		for (Map.Entry<Integer, Merchants> merchant : merchants.entrySet()) {
			Map<Integer, Ad> adTemp = new HashMap<>();
			adTemp = merchant.getValue().getAd();
			if (adTemp != null && !adTemp.isEmpty()) {
				for (Map.Entry<Integer, Ad> ad : adTemp.entrySet()) {
					if (isAdRelevant(ad, user)) {
						if (!adAlreadyDisplayed(merchant.getValue(), ad.getValue(), user)) {
							displayAd.setAdName(ad.getValue().getAdName());
							displayAd.setMerchantName(merchant.getValue().getName());
							displayAd.setAdId(ad.getValue().getAdId());
							displayAd.setMerchantId(merchant.getValue().getMerchantId());
							suitableAds.put(ad.getValue().getBid(), displayAd);
							userVisitHistory.put(user.getUserId(),
									merchant.getValue().getMerchantId() + "_" + ad.getValue().getAdId());
						}
					}
				}
			}
		}

	}

	private boolean adAlreadyDisplayed(Merchants merchants2, Ad ad, User user) {
		if (merchants2 != null && ad != null && user != null) {
			if (userVisitHistory != null && userVisitHistory.containsKey(user.getUserId())) {
				if (userVisitHistory.get(user.getUserId()).equals(merchants2.getMerchantId() + "_" + ad.getAdId()))
					return true;
			}
		}
		return false;

	}

	private boolean isAdRelevant(Map.Entry<Integer, Ad> ad, User user) {
		return (ad.getValue().getBudget() >= ad.getValue().getBid()
				&& ad.getValue().getGender().equals(user.getGender())
				&& (user.getAge() >= ad.getValue().getlAge() && user.getAge() <= ad.getValue().gethAge()));
	}

}
