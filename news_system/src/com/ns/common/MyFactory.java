package com.ns.common;

public class MyFactory {
	public static Object getBean(String name){
		try {
			String className = Config.prop.getProperty(name);
			Object obj = Class.forName(className).newInstance();
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
