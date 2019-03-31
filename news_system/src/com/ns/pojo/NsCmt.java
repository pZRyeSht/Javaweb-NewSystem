package com.ns.pojo;

import java.sql.Date;

public class NsCmt implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cmt_id;
	private Integer news_id;
	private Integer user_id;
	private String cmt_content;
	private Date cmt_datetime;
	
	public Integer getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(Integer cmt_id) {
		this.cmt_id = cmt_id;
	}
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public Date getCmt_datetime() {
		return cmt_datetime;
	}
	public void setCmt_datetime(Date cmt_datetime) {
		this.cmt_datetime = cmt_datetime;
	}
	
	public NsCmt(Integer cmt_id, Integer news_id, Integer user_id, String cmt_content, Date cmt_datetime) {
		super();
		this.cmt_id = cmt_id;
		this.news_id = news_id;
		this.user_id = user_id;
		this.cmt_content = cmt_content;
		this.cmt_datetime = cmt_datetime;
	}
	
	public NsCmt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NsCmt [cmt_id=" + cmt_id + ", news_id=" + news_id + ", user_id=" + user_id + ", cmt_content="
				+ cmt_content + ", cmt_datetime=" + cmt_datetime + "]";
	}
	
	
}
