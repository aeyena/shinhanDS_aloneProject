package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.util.DBUtil;

public class CrowdFundDAO {
	
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public int bJoinMembership(CrowdFundBusinessman businessman) {
		String sql = "insert into businessman values(?,?,?)";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, businessman.getBusinessmanID());
			pst.setString(2, businessman.getBusinessmanPW());
			pst.setString(3, businessman.getBusinessmanName());
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

	public int registerItem(CrowdFundItem item) {
		String sql = "insert into item values(seq_01.NEXTVAL,?,?,?,?,?,?)";
		int count = 0;
		conn = DBUtil.getConnection();
	    try {
	    	pst = conn.prepareStatement(sql);
	    	pst.setString(1, item.getItemName());
	    	pst.setString(2, item.getItemInfo());
	    	pst.setInt(3, item.getTargetAmount());
	    	pst.setInt(4, item.getCollectedAmount());
	    	pst.setFloat(5, item.getPercentage());
	    	pst.setString(6, item.getBusinessmanID());
	    	count = pst.executeUpdate();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.dbDisconnect(conn, pst, rs);
	    }
		return count;
	}

	public int deleteItem(int itemId) {
		String sql = "delete from item where itemid=?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, itemId);
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

	public int iJoinMembership(CrowdFundInvestor investor) {
		String sql = "insert into investor values(?,?,?,?)";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, investor.getInvestorID());
			pst.setString(2, investor.getInvestorPW());
			pst.setString(3, investor.getInvestorName());
			pst.setInt(4, investor.getRecharge());
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

	public List<CrowdFundItem> selectAll() {
		List<CrowdFundItem> clist = new ArrayList<CrowdFundItem>();
		String sql = "select * from item";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				CrowdFundItem item = makeItem(rs);
				clist.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return clist;
	}

	private CrowdFundItem makeItem(ResultSet rs) throws SQLException {
		CrowdFundItem item = new CrowdFundItem();
		item.setItemID(rs.getInt("ItemId"));
		item.setItemName(rs.getString("ItemName"));
		item.setItemInfo(rs.getString("ItemInfo"));
		item.setTargetAmount(rs.getInt("TargetAmount"));
		item.setBusinessmanID(rs.getString("BusinessmanID"));
		item.setCollectedAmount(rs.getInt("CollectedAmount"));
		item.setPercentage(rs.getFloat("Percentage"));
		return item;
	}

	public List<CrowdFundItem> selectByBid(String businessmanId) {
		List<CrowdFundItem> clist = new ArrayList<CrowdFundItem>();
		String sql = "select * from item where trim(businessmanId) = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, businessmanId);
			rs = pst.executeQuery();
			while(rs.next()) {
				CrowdFundItem item = makeItem(rs);				
				clist.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return clist;
	}
	

	public int insertFunding(CrowdFundFunding funding) {
		String sql = "insert into funding values (?,?,?)";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, funding.getInvestorID());
			pst.setInt(2, funding.getItemID());
			pst.setInt(3, funding.getInvestmentAmount());
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

	public List<CrowdFundFunding> checkFunding(String investorId) {
		List<CrowdFundFunding> clist = new ArrayList<CrowdFundFunding>();
		String sql = "select * from funding where trim(investorId) = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, investorId);
			rs = pst.executeQuery();
			while(rs.next()) {
				CrowdFundFunding funding = makeFunding(rs);				
				clist.add(funding);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return clist;
	}

	private CrowdFundFunding makeFunding(ResultSet rs) throws SQLException {
		CrowdFundFunding funding = new CrowdFundFunding();
		funding.setInvestorID(rs.getString("InvestorID"));
		funding.setItemID(rs.getInt("ItemId"));
		funding.setInvestmentAmount(rs.getInt("InvestmentAmount"));
		return funding;
	}

	public List<CrowdFundItem> selectByIid(String investorId) {
		List<CrowdFundItem> clist = new ArrayList<CrowdFundItem>();
		String sql = "select i.* "
				+ "from item i inner join funding f on(i.itemID=f.itemID) "
				+ "where trim(investorID) = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, investorId);
			rs = pst.executeQuery();
			while(rs.next()) {
				CrowdFundItem item = makeItem(rs);				
				clist.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return clist;
	}

	public CrowdFundInvestor checkBalance(String investorId) {
		String sql = "select * from investor where trim(investorId) = ?";
		CrowdFundInvestor investor = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, investorId);
			rs = pst.executeQuery();
			while(rs.next()) {
				investor = makeInvestor(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return investor;
	}

	private CrowdFundInvestor makeInvestor(ResultSet rs) throws SQLException {
		CrowdFundInvestor investor = new CrowdFundInvestor();
		investor.setInvestorID(rs.getString("InvestorID"));
		investor.setInvestorPW(rs.getString("InvestorPW"));
		investor.setInvestorName(rs.getString("InvestorName"));
		investor.setRecharge(rs.getInt("Recharge"));
		return investor;
	}

	public int chargeAmount(String investorId, int amount) {
		String sql = "update investor set recharge = recharge + ? where trim(investorId) = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, amount);
			pst.setString(2, investorId);
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return count;
	}

	public boolean bLogin(String businessmanId, String businessmanPw) {
		boolean isLogin = false;
		String sql = "select * from businessman "
				+ "where trim(businessmanId)=? and trim(businessmanPw)=?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,businessmanId);
			pst.setString(2,businessmanPw);
			rs = pst.executeQuery();
			if(rs.next()) {
				isLogin = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return isLogin;
	}

	public boolean iLogin(String investorId, String investorPw) {
		boolean isLogin = false;
		String sql = "select * from investor "
				+ "where trim(investorId)=? and trim(investorPw)=?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,investorId);
			pst.setString(2,investorPw);
			rs = pst.executeQuery();
			if(rs.next()) {
				isLogin = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return isLogin;
	}

	public List<CrowdFundItem> selectByPopularity() {
		List<CrowdFundItem> clist = new ArrayList<CrowdFundItem>();
		String sql = "select * from item order by percentage desc";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				CrowdFundItem item = makeItem(rs);
				clist.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return clist;
	}

	
	
	public List<CrowdFundItem> selectBySearch(String search) {
		List<CrowdFundItem> clist = new ArrayList<CrowdFundItem>();
		String sql = "select * from item where itemName like '%'||?||'%'";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,search);
			rs = pst.executeQuery();
			Boolean isRs = rs.next();
			if(isRs) {
				while(isRs) {
					CrowdFundItem item = makeItem(rs);
					clist.add(item);
					isRs = rs.next();
				}
			} else {
				System.out.println("[알림]검색하신 상품이 존재하지 않습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return clist;
	}
	
}
