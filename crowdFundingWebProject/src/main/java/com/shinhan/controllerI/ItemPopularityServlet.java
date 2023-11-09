package com.shinhan.controllerI;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;

@WebServlet("/investor/itemPopularity.do")
public class ItemPopularityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CrowdFundInvestor investor = (CrowdFundInvestor)session.getAttribute("investor");
		if (investor==null) {
			response.sendRedirect("investorLogin.do");
			return;
		}

		CrowdFundService service = new CrowdFundService();
		List<CrowdFundItem> ilist = service.selectByPopularity();
		request.setAttribute("ilist", ilist);

		RequestDispatcher rd = request.getRequestDispatcher("itemPopularity.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String search = request.getParameter("search");
		CrowdFundService service = new CrowdFundService();
		List<CrowdFundItem> ilist = service.selectBySearch(search);
		request.setAttribute("ilist", ilist);

		RequestDispatcher rd = request.getRequestDispatcher("itemPopularity.jsp");
		rd.forward(request, response);
	}

}
