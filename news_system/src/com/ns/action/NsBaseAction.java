package com.ns.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public abstract class NsBaseAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			upfile(request,response);		//上传文件
		}else{
			String method = request.getParameter("method");
			if(method.equals("manage")){
				manage(request,response);		//管理就是showall，查出所有，然后放进PageList
			}else if(method.equals("browse")){
				browse(request,response);		//预览，调用show，之后再跳转页面
			}else if(method.equals("show")){
				show(request,response);			//显示,用于和数据库交互，查询
			}else if(method.equals("showall")){
				showall(request,response);		//遍历
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
	protected void upfile(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void manage(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void browse(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void show(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void showall(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void add(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void willEdit(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void edit(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	protected void delete(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
	}
	
}
