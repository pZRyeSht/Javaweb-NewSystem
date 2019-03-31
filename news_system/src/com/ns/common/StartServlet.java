package com.ns.common;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		try{
			String path = this.getServletContext().getRealPath("/WEB-INF/config.properties");
			InputStream in = new FileInputStream(path);
			Config.prop.load(in);
		}catch(Exception ex){
			throw new ServletException(ex.getMessage());
		}
	}
}
