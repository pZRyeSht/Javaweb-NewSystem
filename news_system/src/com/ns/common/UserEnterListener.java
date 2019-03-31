package com.ns.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserEnterListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		Integer totalcount = (Integer)sc.getAttribute("totalcount");
		Integer accesscount = (Integer)sc.getAttribute("accesscount");
		System.out.println("sessionCreated:"+totalcount);
		sc.setAttribute("totalcount", totalcount + 1);
		sc.setAttribute("accesscount", accesscount + 1);
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
		ServletContext sc = se.getSession().getServletContext();
		Integer accesscount = (Integer)sc.getAttribute("accesscount");
		sc.setAttribute("accesscount", accesscount - 1);
	}
}
