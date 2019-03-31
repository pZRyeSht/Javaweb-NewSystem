package com.ns.pojo;

public class NsDcCat {
	private Integer dc_id;
	private String dc_name;
	private String cat_name;
	public Integer getDc_id() {
		return dc_id;
	}
	public void setDc_id(Integer dc_id) {
		this.dc_id = dc_id;
	}
	public String getDc_name() {
		return dc_name;
	}
	public void setDc_name(String dc_name) {
		this.dc_name = dc_name;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public NsDcCat(Integer dc_id, String dc_name, String cat_name) {
		super();
		this.dc_id = dc_id;
		this.dc_name = dc_name;
		this.cat_name = cat_name;
	}
	public NsDcCat() {
		super();
		// TODO Auto-generated constructor stub
	}
}
