package com.ns.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitNumListener implements ServletContextListener{
	// 这个方法在Web应用服务做好接受请求的时候被调用。
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String filename = sc.getRealPath("WEB-INF/count.txt");
		File file = new File(filename);
		int totalcount = 0;
		System.out.println("contextInitialized");
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String valueString = null;
				if((valueString = br.readLine())!=null&&valueString.equals("")&&!valueString.equals("null")){
					totalcount = Integer.parseInt(valueString);
					System.out.println("valueString:"+valueString);
				}
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.setAttribute("totalcount", totalcount);//访问总数
		sc.setAttribute("accesscount", 0);//在线用户数
	}
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String filename = sc.getRealPath("WEB-INF/count.txt");
		File file = new File(filename);
		try {
			FileWriter fr = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(sc.getAttribute("totalcount").toString());
			br.close();
			fr.close();
			System.out.print("contextDestroyed:");
			System.out.println(sc.getAttribute("totalcount").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
