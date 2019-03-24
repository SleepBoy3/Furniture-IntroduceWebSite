package com.ysd.entity;

public class ProductClass {
	private int id;
	private String name;
	private String projectClassDate;
	public ProductClass(int id, String name, String projectClassDate) {
		super();
		this.id = id;
		this.name = name;
		this.projectClassDate = projectClassDate;
	}
	public ProductClass() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectClassDate() {
		return projectClassDate;
	}
	public void setProjectClassDate(String projectClassDate) {
		this.projectClassDate = projectClassDate;
	}
	@Override
	public String toString() {
		return "ProductClass [id=" + id + ", name=" + name
				+ ", projectClassDate=" + projectClassDate + "]";
	}
	
	
}
