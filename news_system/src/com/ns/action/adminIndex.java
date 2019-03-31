package com.ns.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsCatService;
import com.ns.pojo.NsCat;

public class adminIndex extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsCatService catService= (INsCatService)MyFactory.getBean("catService");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			resp.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			List<NsCat> catlist = catService.findCatAll();
			req.setAttribute("catlist", catlist);
			RequestDispatcher rd = req.getRequestDispatcher("admin/admin.jsp");
			rd.forward(req, resp);
		} catch (MyException e) {
			// TODO: handle exception
			req.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">·µ»Ø</a>");
			RequestDispatcher rd = req.getRequestDispatcher("/common/message.jsp");
			rd.forward(req, resp);
		}
	}
	
	
}
