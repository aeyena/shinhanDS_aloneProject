package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class CrowdFundFunding {
	private String investorID;
	private int itemID;
	private int investmentAmount;
	
	@Override
	public String toString() {
		return "투자자ID: " + investorID.trim() + ", 상품번호: " + itemID
				+ ", 펀딩금액: " + investmentAmount;
	}
}
