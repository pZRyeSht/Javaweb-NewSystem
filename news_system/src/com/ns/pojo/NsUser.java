package com.ns.pojo;

import java.sql.Date;

public class NsUser implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String user_name;
	private String user_rname;
	private String user_password;
	private String user_email;
	private String user_tel;
	private Date user_datetime;
	private Integer user_right;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_rname() {
		return user_rname;
	}
	public void setUser_rname(String user_rname) {
		this.user_rname = user_rname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public Date getUser_datetime() {
		return user_datetime;
	}
	public void setUser_datetime(Date user_datetime) {
		this.user_datetime = user_datetime;
	}
	public Integer getUser_right() {
		return user_right;
	}
	public void setUser_right(Integer user_right) {
		this.user_right = user_right;
	}
	
	public NsUser(Integer user_id, String user_name, String user_rname, String user_password, String user_email,
			String user_tel, Date user_datetime, Integer user_right) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_rname = user_rname;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_datetime = user_datetime;
		this.user_right = user_right;
	}
	
	public NsUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NsUser [user_id=" + user_id + ", user_name=" + user_name + ", user_rname=" + user_rname
				+ ", user_password=" + user_password + ", user_email=" + user_email + ", user_tel=" + user_tel
				+ ", user_datetime=" + user_datetime + ", user_right=" + user_right + "]";
	}
	
}
