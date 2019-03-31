package com.ns.pojo;

public class NsHuman implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer human_id;
	private String human_name;
	private String human_address;
	private Integer human_age;
	private String human_work;
	private String human_intr;
	private Integer human_num;
	
	public Integer getHuman_id() {
		return human_id;
	}
	public void setHuman_id(Integer human_id) {
		this.human_id = human_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public String getHuman_address() {
		return human_address;
	}
	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}
	public Integer getHuman_age() {
		return human_age;
	}
	public void setHuman_age(Integer human_age) {
		this.human_age = human_age;
	}
	public String getHuman_work() {
		return human_work;
	}
	public void setHuman_work(String human_work) {
		this.human_work = human_work;
	}
	public String getHuman_intr() {
		return human_intr;
	}
	public void setHuman_intr(String human_intr) {
		this.human_intr = human_intr;
	}
	public Integer getHuman_num() {
		return human_num;
	}
	public void setHuman_num(Integer human_num) {
		this.human_num = human_num;
	}
	
	public NsHuman(Integer human_id, String human_name, String human_address, Integer human_age, String human_work,
			String human_intr, Integer human_num) {
		super();
		this.human_id = human_id;
		this.human_name = human_name;
		this.human_address = human_address;
		this.human_age = human_age;
		this.human_work = human_work;
		this.human_intr = human_intr;
		this.human_num = human_num;
	}
	
	public NsHuman() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NsHuman [human_id=" + human_id + ", human_name=" + human_name + ", human_address=" + human_address
				+ ", human_age=" + human_age + ", human_work=" + human_work + ", human_intr=" + human_intr
				+ ", human_num=" + human_num + "]";
	}
	
	
}
