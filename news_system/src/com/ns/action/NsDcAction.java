package com.ns.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsDcService;
import com.ns.iservice.INsNewsService;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsDcCat;
import com.ns.pojo.NsNewsDc;

public class NsDcAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsDcService dcService = (INsDcService)MyFactory.getBean("dcService");
	private INsNewsService newsService =(INsNewsService)MyFactory.getBean("newsService");
	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int dcId = Integer.parseInt(request.getParameter("dcId"));
			int catId = Integer.parseInt(request.getParameter("catId"));
			List<NsDc> dclist = dcService.findDcByCatId(catId);
			List<NsNewsDc> newsdclist = newsService.findNewsByDcId(dcId);
			request.setAttribute("newsdclist", newsdclist);
			request.setAttribute("dclist", dclist);
			RequestDispatcher rd = request.getRequestDispatcher("/news/catnews.jsp");
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
		NsDc dc = new NsDc();
		dc.setDc_name(request.getParameter("dcName"));
		int catId = Integer.parseInt(request.getParameter("catId"));
		dc.setCat_id(catId);
		try {
			dcService.addDc(dc);
			showall(request, response);
		} catch (Exception e) {
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
			NsDc dc = dcService.findDcById(Integer.parseInt(request.getParameter("dcId")));
			request.setAttribute("dc", dc);
			RequestDispatcher rd = request.getRequestDispatcher("/dc/edit.jsp");
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
		NsDc dc = new NsDc();
		int dcId = Integer.parseInt(request.getParameter("dcId"));
		dc.setDc_name(request.getParameter("dcName"));
		int catId = Integer.parseInt(request.getParameter("catId"));
		dc.setCat_id(catId);
		dc.setDc_id(dcId);
		try {
			dcService.editDc(dc);
			showall(request, response);
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
		int id = Integer.parseInt(request.getParameter("dcId"));
		try {
			dcService.deleteDc(id);
			showall(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void showall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<NsDcCat> dccatlist = dcService.findDcCat();
			request.setAttribute("dccatlist", dccatlist);
			RequestDispatcher rd = request.getRequestDispatcher("/dc/manage.jsp");
			rd.forward(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
}
