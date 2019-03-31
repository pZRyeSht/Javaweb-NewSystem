package com.ns.pojo;

import java.sql.Date;

public class NsLink implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer link_id;
	private String link_name;
	private String link_address;
	private Date link_datetime;
	
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_address() {
		return link_address;
	}
	public void setLink_address(String link_address) {
		this.link_address = link_address;
	}
	public Date getLink_datetime() {
		return link_datetime;
	}
	public void setLink_datetime(Date link_datetime) {
		this.link_datetime = link_datetime;
	}
	
	public NsLink(Integer link_id, String link_name, String link_address, Date link_datetime) {
		super();
		this.link_id = link_id;
		this.link_name = link_name;
		this.link_address = link_address;
		this.link_datetime = link_datetime;
	}
	
	public NsLink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NsLink [link_id=" + link_id + ", link_name=" + link_name + ", link_address=" + link_address
				+ ", link_datetime=" + link_datetime + "]";
	}
	
	
}
