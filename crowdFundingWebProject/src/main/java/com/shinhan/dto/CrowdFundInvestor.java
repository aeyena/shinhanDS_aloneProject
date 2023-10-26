package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class CrowdFundInvestor {
	private String investorID;
	private String investorPW;
	private String investorName;
	private int recharge;
	
	public CrowdFundInvestor(String investorID, String investorPW, String investorName) {
		this(investorID,investorPW,investorName,0);
	}
}
