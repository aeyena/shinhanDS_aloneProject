package com.shinhan.lastcontroller;

import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;

public class EmpDetailContoller implements CommonController{

	@Override
	public String execute(Map<String, Object> data) {
		String method = (String)data.get(("method"));
		String page = "";
		if(method.equalsIgnoreCase("get")) {
			
			String empid = (String)data.get("empid");
			
			int i_empid = Integer.parseInt(empid);
			EmpService eservice = new EmpService();
			DeptService dService = new DeptService();
			JobDAO jDAO = new JobDAO();
			
			data.put("emp", eservice.selectById(i_empid));
			data.put("dlist", dService.selectAll());
			data.put("jlist", jDAO.selectAll());
			data.put("mlist", eservice.selectManagerAll());

			page="empDetail.jsp";

		}else {
			
			EmpVO emp = (EmpVO)data.get("emp");
			EmpService eservice = new EmpService();
			int result = eservice.empUpdate(emp);
			String str = result>0?"update success":"update fail";
			
			//Redirect: 새로운 요청하기
			//redirect: 이라는 문자는 정해진 것이 아니고 개발자가 임의로 정함(나중에 redirect라는 것을 알기 위해서)
			page = "redirect:empList.do?message=" + str;
			
		}
		return page;
	}

	
}
