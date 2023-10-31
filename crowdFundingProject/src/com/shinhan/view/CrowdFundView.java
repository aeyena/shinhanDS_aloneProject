package com.shinhan.view;

import java.util.List;

import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;

public class CrowdFundView {
	
	public static void print(String message) {
		System.out.println("-------------------------");
		System.out.println(message);
		System.out.println("-------------------------");
	}
	
	public static void print(List<CrowdFundItem> clist) {
		clist.stream().forEach(item->{
			System.out.println(item);	
		});
		System.out.println("-------------------------");
	}

	public static void print2(List<CrowdFundFunding> clist) {
		clist.stream().forEach(funding->{
			System.out.println(funding);	
		});
		System.out.println("-------------------------");
		
	}

	public static void balancePrint(CrowdFundInvestor investor) {
		System.out.printf("%s님의 잔고는 %d원 입니다\n",investor.getInvestorName(),investor.getRecharge());
		
	}

}
