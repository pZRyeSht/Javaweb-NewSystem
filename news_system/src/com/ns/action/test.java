package com.ns.action;

import java.util.List;

import com.ns.dao.NsAdminDao;
import com.ns.pojo.NsAdmin;

public class test {
	public static void main(String[] args) {
		NsAdminDao adminDao = new NsAdminDao();
		try {
			List<NsAdmin> admins = adminDao.selectall();
			for (NsAdmin nsAdmin : admins) {
				System.out.println(nsAdmin.getAdmin_id());
				System.out.println(nsAdmin.getAdmin_name());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
