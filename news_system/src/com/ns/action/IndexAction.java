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
import com.ns.iservice.INsLinkService;
import com.ns.iservice.INsNewsService;
import com.ns.pojo.NsCat;
import com.ns.pojo.NsLink;
import com.ns.pojo.NsNewsDc;

public class IndexAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsCatService catService = (INsCatService)MyFactory.getBean("catService");
	private INsLinkService linkService = (INsLinkService)MyFactory.getBean("linkService");
	private INsNewsService newsService = (INsNewsService)MyFactory.getBean("newsService");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		if(method==null||"".equals(method)){
			try {
				resp.setContentType("text/html;charset=utf-8");
				req.setCharacterEncoding("utf-8");
				List<NsCat> catlist = catService.findCatAll();
				List<NsLink> linklist = linkService.findLinkAll(1, 7);
				req.setAttribute("catlist", catlist);
				req.setAttribute("linklist", linklist);
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			} catch (MyException e) {
				// TODO: handle exception
				req.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
				RequestDispatcher rd = req.getRequestDispatcher("/common/message.jsp");
				rd.forward(req, resp);
			}
		}else if(method.equals("firstshow")){
			firstshow(req,resp);		//管理就是showall，查出所有，然后放进PageList
		}
	}
	
	protected void firstshow(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException, IOException{
		try {
			List<NsNewsDc> newsFlist = newsService.findNewsFrist();
			req.setAttribute("newsFlist", newsFlist);
			RequestDispatcher rd = req.getRequestDispatcher("/first.jsp");
			rd.forward(req, resp);
		} catch (MyException e) {
			// TODO: handle exception
			req.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = req.getRequestDispatcher("/common/message.jsp");
			rd.forward(req, resp);
		}
	}
}
