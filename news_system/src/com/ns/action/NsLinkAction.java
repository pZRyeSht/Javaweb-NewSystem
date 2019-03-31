package com.ns.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsLinkService;
import com.ns.pojo.NsLink;

public class NsLinkAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsLinkService linkService = (INsLinkService)MyFactory.getBean("linkService");
	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<NsLink> linklist = linkService.findLinkAll();
			request.setAttribute("linklist", linklist);
			RequestDispatcher rd = request.getRequestDispatcher("/link/manage.jsp");
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
		NsLink link = new NsLink();
		link.setLink_name(request.getParameter("linkName"));
		link.setLink_address(request.getParameter("linkAddress"));
		Date date = new Date(System.currentTimeMillis());
		link.setLink_datetime(date);
		try {
			linkService.addLink(link);
			show(request, response);
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
			NsLink link = linkService.findLinkById(Integer.parseInt(request.getParameter("linkId")));
			request.setAttribute("link", link);
			RequestDispatcher rd = request.getRequestDispatcher("/link/edit.jsp");
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
		NsLink link = new NsLink();
		link.setLink_id(Integer.parseInt(request.getParameter("linkId")));
		link.setLink_name(request.getParameter("linkName"));
		link.setLink_address(request.getParameter("linkAddress"));
		Date date = new Date(System.currentTimeMillis());
		link.setLink_datetime(date);
		try {
			linkService.editLink(link);
			show(request, response);
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
		int id = Integer.parseInt(request.getParameter("linkId"));
		try {
			linkService.deleteLink(id);
			show(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
}
