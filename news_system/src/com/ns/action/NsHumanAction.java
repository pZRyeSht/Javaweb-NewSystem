package com.ns.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.iservice.INsHumanService;
import com.ns.pojo.NsAdmin;
import com.ns.pojo.NsHuman;
import com.ns.pojo.NsUser;
import com.ns.tag.NsUserCheckTag;

public class NsHumanAction extends NsBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private INsHumanService humanService = (INsHumanService)MyFactory.getBean("humanService");
	
	@Override
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
			System.out.println("NsHumanAction:"+method);
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
			}else if(method.equals("shownum")){
				shownum(request,response);		//展示票数
			}else if(method.equals("addNum")){
				addNum(request,response);		//投票
			}
		}
	}

	
	@Override
	protected void manage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		showall(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/human/human_manage.jsp");
		rd.forward(request, response);
	}

	

	@Override
	protected void browse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		showall(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/human/human_select.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			NsHuman human = humanService.findHumanById(Integer.parseInt(request.getParameter("humanId")));
			request.setAttribute("human", human);
			RequestDispatcher rd = request.getRequestDispatcher("/human/show.jsp");
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
			List<NsHuman> humanlist = humanService.findHumanAll();
			request.setAttribute("humanlist", humanlist);
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
		NsHuman human = new NsHuman();
		human.setHuman_name(request.getParameter("humanName"));
		human.setHuman_address(request.getParameter("humanAddress"));
		int humanAge = Integer.parseInt(request.getParameter("humanAge"));
		human.setHuman_age(humanAge);
		human.setHuman_work(request.getParameter("humanWork"));
		human.setHuman_intr(request.getParameter("humanIntr"));
		int humanNum = Integer.parseInt(request.getParameter("humanNum"));
		human.setHuman_num(humanNum);
		try {
			humanService.addHuman(human);
			manage(request, response);
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
			int humanId = Integer.parseInt(request.getParameter("humanId"));
			NsHuman human = humanService.findHumanById(humanId);
			request.setAttribute("human", human);
			RequestDispatcher rd = request.getRequestDispatcher("/human/edit.jsp");
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
		NsHuman human = new NsHuman();
		int humanId = Integer.parseInt(request.getParameter("humanId"));
		human.setHuman_id(humanId);
		human.setHuman_name(request.getParameter("humanName"));
		human.setHuman_address(request.getParameter("humanAddress"));
		int humanAge = Integer.parseInt(request.getParameter("humanAge"));
		human.setHuman_age(humanAge);
		human.setHuman_work(request.getParameter("humanWork"));
		human.setHuman_intr(request.getParameter("humanIntr"));
		int humanNum = Integer.parseInt(request.getParameter("humanNum"));
		human.setHuman_num(humanNum);
		try {
			humanService.editHuman(human);
			manage(request, response);
		} catch (Exception e) {
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
		int id = Integer.parseInt(request.getParameter("humanId"));
		try {
			humanService.deleteHuman(id);
			manage(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("msg", e.getMessage()+"<a href=\"JavaScript:window.history.back()\">返回</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/common/message.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void shownum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showall(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/human/human_number.jsp");
		rd.forward(request, response);
	}
	
	protected void addNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NsAdmin admin = (NsAdmin) session.getAttribute("admin");
		NsUser user = (NsUser) session.getAttribute("user");
		if(admin!=null||user!=null){
			Integer num = (Integer)session.getAttribute("num");
			try {
				if(num==0){
					Integer id = Integer.parseInt(request.getParameter("humanId"));
						humanService.updateNum(id);
						session.setAttribute("num", 1);
						response.getWriter().print("投票成功，请勿重复投票。");
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/human/numerror.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else{
			//向客户端输出
			response.getWriter().print("你没有登录或者权限不够，你不能投票！");
		}  
	}
}
