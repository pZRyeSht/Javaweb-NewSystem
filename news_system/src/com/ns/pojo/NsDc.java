package com.ns.pojo;

public class NsDc implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer dc_id;
	private String dc_name;
	private Integer cat_id;
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
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public NsDc(Integer dc_id, String dc_name, Integer cat_id) {
		super();
		this.dc_id = dc_id;
		this.dc_name = dc_name;
		this.cat_id = cat_id;
	}
	public NsDc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NsDc [dc_id=" + dc_id + ", dc_name=" + dc_name + ", cat_id=" + cat_id + "]";
	}
	
}
