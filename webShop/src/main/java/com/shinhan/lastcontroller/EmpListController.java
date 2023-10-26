package com.shinhan.lastcontroller;

import java.util.List;
import java.util.Map;


import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

public class EmpListController implements CommonController{

	@Override
	public String execute(Map<String, Object> data) {
		
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.selectAll();
		data.put("emplist", emplist);
		
		return "empList.jsp";
	}

}
