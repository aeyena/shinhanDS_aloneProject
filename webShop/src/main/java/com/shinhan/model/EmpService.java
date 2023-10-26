package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.EmpVO;

public class EmpService {
	
	EmpDAO dao = new EmpDAO();
	
	public EmpVO loginCheck(String email, int pass) {
		return dao.loginCheck(email, pass);
	}
	public EmpVO selectById(int empid) {
		return dao.selectById(empid);		
	}
	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}
	public List<EmpVO> selectManagerAll() {
		return dao.selectManagerAll();
	}
	public int empUpdate(EmpVO emp) {
		return dao.empUpdate(emp);
	}
	public int empInsert(EmpVO emp) {
		return dao.empInsert(emp);
	}
}
