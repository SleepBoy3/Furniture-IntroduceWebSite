package com.ysd.entity;

public class NewsClass {
	private int newsClassId;
	private String newsClassName;
	private String newsClassDate;
	public NewsClass(int newsClassId, String newsClassName, String newsClassDate) {
		super();
		this.newsClassId = newsClassId;
		this.newsClassName = newsClassName;
		this.newsClassDate = newsClassDate;
	}
	public NewsClass() {
		super();
	}
	public int getNewsClassId() {
		return newsClassId;
	}
	public void setNewsClassId(int newsClassId) {
		this.newsClassId = newsClassId;
	}
	public String getNewsClassName() {
		return newsClassName;
	}
	public void setNewsClassName(String newsClassName) {
		this.newsClassName = newsClassName;
	}
	public String getNewsClassDate() {
		return newsClassDate;
	}
	public void setNewsClassDate(String newsClassDate) {
		this.newsClassDate = newsClassDate;
	}
	@Override
	public String toString() {
		return "NewsClass [newsClassId=" + newsClassId + ", newsClassName="
				+ newsClassName + ", newsClassDate=" + newsClassDate + "]";
	}
	
}
