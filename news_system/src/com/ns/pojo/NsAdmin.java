package com.ns.pojo;

import java.sql.Date;

public class NsAdmin implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer admin_id;
	private String admin_name;
	private String admin_rname;
	private String admin_password;
	private Date admin_datetime;
	private String admin_type;
	private Integer admin_right;
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_rname() {
		return admin_rname;
	}
	public void setAdmin_rname(String admin_rname) {
		this.admin_rname = admin_rname;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public Date getAdmin_datetime() {
		return admin_datetime;
	}
	public void setAdmin_datetime(Date admin_datetime) {
		this.admin_datetime = admin_datetime;
	}
	public String getAdmin_type() {
		return admin_type;
	}
	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;
	}
	public Integer getAdmin_right() {
		return admin_right;
	}
	public void setAdmin_right(Integer admin_right) {
		this.admin_right = admin_right;
	}
	public NsAdmin(Integer admin_id, String admin_name, String admin_rname, String admin_password, Date admin_datetime,
			String admin_type, Integer admin_right) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_rname = admin_rname;
		this.admin_password = admin_password;
		this.admin_datetime = admin_datetime;
		this.admin_type = admin_type;
		this.admin_right = admin_right;
	}
	public NsAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NsAdmin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_rname=" + admin_rname
				+ ", admin_password=" + admin_password + ", admin_datetime=" + admin_datetime + ", admin_type="
				+ admin_type + ", admin_right=" + admin_right + "]";
	}
	
	
}
