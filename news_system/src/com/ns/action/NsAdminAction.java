package com.ns.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsAdminService;
import com.ns.pojo.NsAdmin;

public class NsAdminAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private INsAdminService adminService = (INsAdminService)MyFactory.getBean("adminService");
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NsAdminAction");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			upfile(request,response);		//上传文件
		}else{
			String method = request.getParameter("method");
			if(method.equals("manage")){
				manage(request,response);		//管理
			}else if(method.equals("browse")){
				browse(request,response);		//预览
			}else if(method.equals("show")){
				show(request,response);			//显示
			}else if(method.equals("showall")){
				showall(request,response);		//显示所有
			}else if(method.equals("add")){
				add(request,response);			//添加
			}else if(method.equals("willEdit")){
				willEdit(request,response);		//要修改
			}else if(method.equals("edit")){
				edit(request,response);			//修改
			}else if(method.equals("delete")){
				delete(request,response);		//删除
			}
		}
	}

	@Override
	protected void upfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void manage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		showall(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/manage.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void browse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			NsAdmin admin = adminService.findAdminById(Integer.parseInt(request.getParameter("adminId")));
			request.setAttribute("admin", admin);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/show.jsp");
			rd.forward(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void showall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		NsAdmin admin = (NsAdmin) session.getAttribute("admin");
		try {
			if(admin != null && admin.getAdmin_right().intValue() < 1){
				List<NsAdmin> adminlist = adminService.findAdminAll();
				request.setAttribute("adminlist", adminlist);
			}else{
				System.out.println("权限不够");
			}
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
		NsAdmin admin = new NsAdmin();
		admin.setAdmin_name(request.getParameter("adminName"));
		admin.setAdmin_rname(request.getParameter("adminRname"));
		admin.setAdmin_password(request.getParameter("adminPassword"));
		Date date = new Date(System.currentTimeMillis());
		admin.setAdmin_datetime(date);
		Integer adminRight = Integer.parseInt(request.getParameter("adminType"));
		admin.setAdmin_right(adminRight);
		if(adminRight==0){
			admin.setAdmin_type("超级管理员");
		}else {
			admin.setAdmin_type("普通管理员");
		}
		try {
			adminService.addAdmin(admin);
			manage(request, response);
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
			Integer adminId = Integer.parseInt(request.getParameter("adminId"));
			NsAdmin admin =adminService.findAdminById(adminId);
			request.setAttribute("admin", admin);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/edit.jsp");
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
		HttpSession session = request.getSession();
		NsAdmin adminsession = (NsAdmin) session.getAttribute("admin");
		NsAdmin admin = new NsAdmin();
		admin.setAdmin_id(Integer.parseInt(request.getParameter("adminId")));
		admin.setAdmin_name(request.getParameter("adminName"));
		admin.setAdmin_rname(request.getParameter("adminRname"));
		admin.setAdmin_password(request.getParameter("adminPassword"));
		Date date = new Date(System.currentTimeMillis());
		admin.setAdmin_datetime(date);
		Integer adminRight = Integer.parseInt(request.getParameter("adminType"));
		admin.setAdmin_right(adminRight);
		if(adminRight==0){
			admin.setAdmin_type("超级管理员");
		}else {
			admin.setAdmin_type("普通管理员");
		}
		try {
			adminService.editAdmin(admin);
			if(adminsession.getAdmin_right()<=0){
				manage(request, response);
			}else{
				show(request, response);
			}
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
		Integer id = Integer.parseInt(request.getParameter("adminId"));
		try {
			adminService.deleteAdmin(id);
			manage(request, response);
		} catch (MyException e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	
	/*
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login");
		try {
			String adminName =request.getParameter("adminName");
			String adminPwd = request.getParameter("adminPwd");
			NsAdmin admin = adminService.findAdminByNameAndPwd(adminName, adminPwd);
			HttpSession session = request.getSession();
			if(admin != null){
				System.out.println("管理员登录成功");
				session.setAttribute("admin", admin);
				response.sendRedirect("/news_system/adminIndex");
			}else{
				System.out.println("管理员登录失败");
				request.getSession().setAttribute("mrgss", "你的输入有误，请你重新输入");
				response.sendRedirect("/news_system/admin/login.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	*/
}
