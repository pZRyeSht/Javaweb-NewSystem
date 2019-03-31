package com.ns.pojo;

import java.sql.Date;

public class NsNews implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer news_id;
	private String news_title;
	private String news_content;
	private Date news_datetime;
	private Integer news_firstshow;
	private Integer cat_id;
	private Integer dc_id;
	
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
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Date getNews_datetime() {
		return news_datetime;
	}
	public void setNews_datetime(Date news_datetime) {
		this.news_datetime = news_datetime;
	}
	public Integer getNews_firstshow() {
		return news_firstshow;
	}
	public void setNews_firstshow(Integer news_firstshow) {
		this.news_firstshow = news_firstshow;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public Integer getDc_id() {
		return dc_id;
	}
	public void setDc_id(Integer dc_id) {
		this.dc_id = dc_id;
	}
	
	public NsNews(Integer news_id, String news_title, String news_content, Date news_datetime, Integer news_firstshow,
			Integer cat_id, Integer dc_id) {
		super();
		this.news_id = news_id;
		this.news_title = news_title;
		this.news_content = news_content;
		this.news_datetime = news_datetime;
		this.news_firstshow = news_firstshow;
		this.cat_id = cat_id;
		this.dc_id = dc_id;
	}
	
	public NsNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NsNews [news_id=" + news_id + ", news_title=" + news_title + ", news_content=" + news_content
				+ ", news_datetime=" + news_datetime + ", news_firstshow=" + news_firstshow + ", cat_id=" + cat_id
				+ ", dc_id=" + dc_id + "]";
	}
	
	
}
