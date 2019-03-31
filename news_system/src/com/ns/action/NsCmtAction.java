package com.ns.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsCmtService;
import com.ns.pojo.NsCmt;

public class NsCmtAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsCmtService cmtService = (INsCmtService)MyFactory.getBean("cmtService");
	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			NsCmt cmt = cmtService.findCmtById(Integer.parseInt(request.getParameter("cmtId")));
			request.setAttribute("cmt", cmt);
			RequestDispatcher rd = request.getRequestDispatcher("cmt/show.jsp");
			rd.forward(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NsCmt cmt = new NsCmt();
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		cmt.setCmt_id(newsId);
		int userId = Integer.parseInt(request.getParameter("userId"));
		cmt.setUser_id(userId);
		cmt.setCmt_content(request.getParameter("cmtContent"));
		Date date = new Date(System.currentTimeMillis());
		cmt.setCmt_datetime(date);
		try {
			cmtService.addCmt(cmt);
			response.sendRedirect("");
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void willEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			NsCmt cmt = cmtService.findCmtById(Integer.parseInt(request.getParameter("cmtId")));
			request.setAttribute("cmt", cmt);
			RequestDispatcher rd = request.getRequestDispatcher("cmt/edit.jsp");
			rd.forward(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NsCmt cmt = new NsCmt();
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		cmt.setCmt_id(newsId);
		int userId = Integer.parseInt(request.getParameter("userId"));
		cmt.setUser_id(userId);
		cmt.setCmt_content(request.getParameter("cmtContent"));
		Date date = new Date(System.currentTimeMillis());
		cmt.setCmt_datetime(date);
		try {
			cmtService.editCmt(cmt);
			response.sendRedirect("");
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("cmtId"));
		try {
			cmtService.deleteCmt(id);
			response.sendRedirect("");
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	
	
}
