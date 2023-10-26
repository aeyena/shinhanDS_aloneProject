package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.DeptVO;

//Service: 비즈니스로직 담당
//POJO(Plain Old Java Object): 정해진 규칙없이 자바로 만들어진 class
//JDBC를 이용하여 만든 JAVA코드이다...계속사용예정
public class DeptService {
	DeptDAO dao = new DeptDAO();
	
	public List<DeptVO> selectByLocation(int loc) {
		return dao.selectByLocation(loc);
	}
	
	public List<DeptVO> selectByManager() {
		return dao.selectByManager();
	}
	
	public DeptVO selectById(int deptid) {
		return dao.selectById(deptid);
	}
	
	public List<DeptVO> selectAll() {
		return dao.selectAll();
	}

	public int insertDept(DeptVO dept) {
		return dao.insertDept(dept);
	}

	public int updateDept(DeptVO dept) {
		return dao.updateDept(dept);
	}

	public int deleteDept(int deptid) {
		return dao.deleteDept(deptid);
	}

	
}
