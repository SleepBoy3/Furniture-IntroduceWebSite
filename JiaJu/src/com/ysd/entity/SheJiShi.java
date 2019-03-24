package com.ysd.entity;

public class SheJiShi {
	private int id;
	private String tuPian;
	private String name;
	private String info;
	public SheJiShi(int id, String tuPian, String name, String info) {
		super();
		this.id = id;
		this.tuPian = tuPian;
		this.name = name;
		this.info = info;
	}
	public SheJiShi() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTuPian() {
		return tuPian;
	}
	public void setTuPian(String tuPian) {
		this.tuPian = tuPian;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "SheJiShi [id=" + id + ", tuPian=" + tuPian + ", name=" + name
				+ ", info=" + info + "]";
	}
	
}
