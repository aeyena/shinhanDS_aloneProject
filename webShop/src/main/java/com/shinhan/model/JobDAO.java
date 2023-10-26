package com.shinhan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.JobVO;
import com.shinhan.util.DBUtil;

public class JobDAO {
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public List<JobVO> selectAll() {
		List<JobVO> jlist = new ArrayList<JobVO>();
		String sql = "select * from jobs";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				JobVO job = new JobVO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)); 
				jlist.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return jlist;
	}

}
