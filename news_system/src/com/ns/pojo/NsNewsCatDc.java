package com.ns.pojo;

import java.sql.Date;

public class NsNewsCatDc {
	private Integer news_id;
	private String news_title;
	private String cat_name;
	private String dc_name;
	private Date news_datetime;
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
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getDc_name() {
		return dc_name;
	}
	public void setDc_name(String dc_name) {
		this.dc_name = dc_name;
	}
	public Date getNews_datetime() {
		return news_datetime;
	}
	public void setNews_datetime(Date news_datetime) {
		this.news_datetime = news_datetime;
	}
	
}
