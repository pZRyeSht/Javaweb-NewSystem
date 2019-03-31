package com.ns.tag;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.ns.pojo.NsAdmin;

public class NsAdminCheckTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer right;
	
	public void setRight(Integer right) {
		this.right = right;
	}
	
	public Integer getRight() {
		return right;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		HttpSession session = this.pageContext.getSession();
		NsAdmin admin = (NsAdmin) session.getAttribute("admin");
		if(admin != null && admin.getAdmin_right().intValue() <= right.intValue()){
			System.out.println("admin.right:"+admin.getAdmin_right().intValue());
			return TagSupport.EVAL_PAGE;
		}
		try {
			this.pageContext.getOut().print("你没有登录或者权限不够，你不能访问！");
		} catch (IOException e) {
			// TODO: handle exception
		}
		return TagSupport.SKIP_PAGE;
	}
}
