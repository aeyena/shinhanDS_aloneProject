package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;

public class CrowdFundService {
	CrowdFundDAO dao = new CrowdFundDAO();

	public int bJoinMembership(CrowdFundBusinessman businessman) {
		return dao.bJoinMembership(businessman);
	}
	
	public int registerItem(CrowdFundItem item) {
		return dao.registerItem(item);
	}

	public int deleteItem(int itemId) {
		return dao.deleteItem(itemId);
	}

	public int iJoinMembership(CrowdFundInvestor investor) {
		return dao.iJoinMembership(investor);
	}

	public List<CrowdFundItem> selectAll() {
		return dao.selectAll();
	}

	public List<CrowdFundItem> selectByBid(String businessmanId) {
		return dao.selectByBid(businessmanId);
	}

	public int insertFunding(CrowdFundFunding funding) {
		return dao.insertFunding(funding);
	}

	public List<CrowdFundFunding> checkFunding(String investorId) {
		return dao.checkFunding(investorId);
	}

	public List<CrowdFundItem> selectByIid(String investorId) {
		return dao.selectByIid(investorId);
	}

	public CrowdFundInvestor checkBalance(String investorId) {
		return dao.checkBalance(investorId);
	}

	public int chargeAmount(String investorId, int amount) {
		return dao.chargeAmount(investorId,amount);
	}

	public CrowdFundBusinessman bLogin(String businessmanId, String businessmanPw) {
		return dao.bLogin(businessmanId,businessmanPw);
	}

	public CrowdFundInvestor iLogin(String investorId, String investorPw) {
		return dao.iLogin(investorId,investorPw);
	}

	public List<CrowdFundItem> selectByPopularity() {
		return dao.selectByPopularity();
	}

	public List<CrowdFundItem> selectBySearch(String search) {
		return dao.selectBySearch(search);
	}
	
	public CrowdFundItem selectByitemId(int itemID) {
		return dao.selectByitemId(itemID);
	}
	
	public int updateItem(CrowdFundItem item) {
		return dao.updateItem(item);
	}

	
}
