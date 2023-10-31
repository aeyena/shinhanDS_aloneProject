package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class CrowdFundItem {
	private String businessmanID;
	private int itemID;
	private String itemName;
	private String itemInfo;
	private int targetAmount;
	private int collectedAmount;
	private float percentage;
	
	@Override
	public String toString() {
		return String.format("상품번호: %-3d 상품이름: %-42s 상품정보: %-110s 목표금액: %-20d 모인금액: %-20d 달성률: %-15.2f 사업가ID: %-10s",itemID,itemName,itemInfo,targetAmount,collectedAmount,percentage,businessmanID.trim());
		}

	public CrowdFundItem(String businessmanID, String itemName, String itemInfo, int targetAmount) {
		this(businessmanID,0,itemName,itemInfo,targetAmount,0,0);
	}
	
}
