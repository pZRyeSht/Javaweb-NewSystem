package com.ns.pojo;

import java.sql.Date;

public class NsNewsDc {
	private Integer news_id;
	private String news_title;
	private Date news_datetime;
	private String dc_name;
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public Date getNews_datetime() {
		return news_datetime;
	}
	public void setNews_datetime(Date news_datetime) {
		this.news_datetime = news_datetime;
	}
	public String getDc_name() {
		return dc_name;
	}
	public void setDc_name(String dc_name) {
		this.dc_name = dc_name;
	}
	public NsNewsDc(Integer news_id, String news_title, Date news_datetime, String dc_name) {
		super();
		this.news_id = news_id;
		this.news_title = news_title;
		this.news_datetime = news_datetime;
		this.dc_name = dc_name;
	}
	public NsNewsDc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NsNewsDc [news_id=" + news_id + ", news_title=" + news_title + ", news_datetime=" + news_datetime
				+ ", dc_name=" + dc_name + "]";
	}
	
}
