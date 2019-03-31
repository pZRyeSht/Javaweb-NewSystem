package com.ns.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsCatService;
import com.ns.iservice.INsDcService;
import com.ns.iservice.INsNewsService;
import com.ns.pojo.NsCat;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsNews;
import com.ns.pojo.NsNewsCatDc;
import com.ns.pojo.NsNewsDc;

public class NsNewsAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private INsNewsService newsService = (INsNewsService)MyFactory.getBean("newsService");
	private INsCatService catService = (INsCatService)MyFactory.getBean("catService");
	private INsDcService dcService = (INsDcService)MyFactory.getBean("dcService");
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			upfile(request,response);		//上传文件
		}else{
			String method = request.getParameter("method");
			System.out.println("调用的函数："+method);
			if(method.equals("manage")){
				manage(request,response);		//管理就是showall，查出所有，然后放进PageList
			}else if(method.equals("browse")){
				browse(request,response);		//预览
			}else if(method.equals("show")){
				show(request,response);			//显示
			}else if(method.equals("showall")){
				showall(request,response);		//showall
			}else if(method.equals("add")){
				add(request,response);			//添加
			}else if(method.equals("willadd")){
				willadd(request,response);			//添加
			}else if(method.equals("willEdit")){
				willEdit(request,response);		//要修改
			}else if(method.equals("edit")){
				edit(request,response);			//修改
			}else if(method.equals("delete")){
				delete(request,response);		//删除
			}else if(method.equals("likeshow")){
				likeshow(request,response);		//模糊查询
			}
		}
	}
	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			NsNews news = newsService.findNewsById(Integer.parseInt(request.getParameter("newsId")));
			request.setAttribute("news", news);
			RequestDispatcher rd = request.getRequestDispatcher("/news/show.jsp");
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
		NsNews news = new NsNews();
		news.setNews_title(request.getParameter("newsTitle"));
		news.setNews_content(request.getParameter("newsContent"));
		Date date = new Date(System.currentTimeMillis());
		news.setNews_datetime(date);
		int newsFirstshow = Integer.parseInt(request.getParameter("newsFirstshow"));
		news.setNews_firstshow(newsFirstshow);
		int catId = Integer.parseInt(request.getParameter("catId"));
		news.setCat_id(catId);
		int dcId = Integer.parseInt(request.getParameter("dcId"));
		news.setDc_id(dcId);
		try {
			newsService.addNews(news);
			showall(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	protected void willadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NsCat cat = new NsCat();
		List<NsDc> dclist = new ArrayList<NsDc>();
		int catId = Integer.parseInt(request.getParameter("catId"));
		try {
			cat = catService.findCatById(catId);
			dclist = dcService.findDcByCatId(catId);
			request.setAttribute("cat", cat);
			request.setAttribute("dclist", dclist);
			RequestDispatcher rd = request.getRequestDispatcher("/news/add.jsp");
			rd.forward(request, response);
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
		NsCat cat = new NsCat();
		List<NsDc> dclist = new ArrayList<NsDc>();
		try {
			NsNews news = newsService.findNewsById(Integer.parseInt(request.getParameter("newsId")));
			Integer catId = news.getCat_id();
			cat = catService.findCatById(catId);
			dclist = dcService.findDcByCatId(catId);
			request.setAttribute("cat", cat);
			request.setAttribute("dclist", dclist);
			request.setAttribute("news", news);
			RequestDispatcher rd = request.getRequestDispatcher("/news/edit.jsp");
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
		NsNews news = new NsNews();
		news.setNews_id(Integer.parseInt(request.getParameter("newsId")));
		news.setNews_title(request.getParameter("newsTitle"));
		news.setNews_content(request.getParameter("newsContent"));
		Date date = new Date(System.currentTimeMillis());
		news.setNews_datetime(date);
		int newsFirstshow = Integer.parseInt(request.getParameter("newsFirstshow"));
		news.setNews_firstshow(newsFirstshow);
		int catId = Integer.parseInt(request.getParameter("catId"));
		news.setCat_id(catId);
		int dcId = Integer.parseInt(request.getParameter("dcId"));
		news.setDc_id(dcId);
		try {
			newsService.editNews(news);
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
		int id = Integer.parseInt(request.getParameter("newsId"));
		try {
			newsService.deleteNews(id);
			showall(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	protected void likeshow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newsTitle = request.getParameter("newsTitle");
		int catId = Integer.parseInt(request.getParameter("catId"));
		NsNews news = new NsNews();
		news.setNews_title(newsTitle);
		news.setCat_id(catId);
		try {
			List<NsNewsDc> newsdclist = newsService.findNewsLike(news);
//			List<NsCat> list = catService.findCatAll();
			request.setAttribute("newsdclist", newsdclist);
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
	protected void showall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<NsNewsCatDc> newscatdclist = newsService.findNewsConAll();
			request.setAttribute("newscatdclist", newscatdclist);
			RequestDispatcher rd = request.getRequestDispatcher("/news/manage.jsp");
			rd.forward(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	
}
