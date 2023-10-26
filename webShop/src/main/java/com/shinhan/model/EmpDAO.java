package com.shinhan.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.EmpVO;
import com.shinhan.util.DBUtil;

public class EmpDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public int empInsert(EmpVO emp) {
		int result = 0;
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	public int empUpdate(EmpVO emp) {
		int result = 0;
		String sql = "update employees \r\n"
				+ "	set first_name=?,\r\n"
				+ "		last_name=?,\r\n"
				+ "		email=?,\r\n"
				+ "		phone_number=?,\r\n"
				+ "		hire_date=?,\r\n"
				+ "		job_id=?,\r\n"
				+ "		salary=?,\r\n"
				+ "		commission_pct=?,\r\n"
				+ "		manager_id=?,\r\n"
				+ "		department_id=? \r\n"
				+ "	where employee_id=?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			pst.setInt(11, emp.getEmployee_id());
			
			result = pst.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}	
		return result;
	}
	
	public EmpVO loginCheck(String email, int pass) {
		EmpVO emp = null;
		String sql = "select * from employees where email = ? and department_id = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setInt(2, pass);
			rs = pst.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emp;
	}
	
	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		String sql = "select * from employees where employee_id = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs); //resultSet에서 읽어서 VO만들기 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emp;
	}
	
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		String sql = "select * from employees order by 1";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = makeEmp(rs); //resultSet에서 읽어서 VO만들기 
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}
	
	public List<EmpVO> selectManagerAll() {
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		String sql = "select * from employees where employee_id in (select distinct manager_id from employees)";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = makeEmp(rs); //resultSet에서 읽어서 VO만들기 
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getInt("Salary"));
		return emp;
	}

}
