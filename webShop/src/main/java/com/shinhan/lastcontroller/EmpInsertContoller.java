package com.shinhan.lastcontroller;

import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;

public class EmpInsertContoller implements CommonController{

	@Override
	public String execute(Map<String, Object> data) {
		String method = (String)data.get(("method"));
		String page = "empInsert_real.jsp";
		if(method.equalsIgnoreCase("get")) {
			
			DeptService dService = new DeptService();
			JobDAO jDAO = new JobDAO();
			EmpService eservice = new EmpService();
			
			data.put("dlist", dService.selectAll());
			data.put("jlist", jDAO.selectAll());
			data.put("mlist", eservice.selectManagerAll());
		}else {
			EmpService eservice = new EmpService();
			EmpVO emp = (EmpVO)data.get("emp");
			int result = eservice.empInsert(emp);
			data.put("message", result>0?"insert성공":"insert실패");
			
			//Redirect: 새로운 요청하기
			page = "redirect:empList.do";
			
		}
		return page;
	}

	
}
