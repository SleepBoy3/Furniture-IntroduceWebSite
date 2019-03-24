package com.ysd.entity;

public class News {
	private int newsClassId;
	private String newsClassName;
	private String newsClassDate;
	private int newsId;
	private String title;
	private String info;
	private String newsdate;
	private int click;
	public News(int newsClassId, String newsClassName, String newsClassDate,
			int newsId, String title, String info, String newsdate, int click) {
		super();
		this.newsClassId = newsClassId;
		this.newsClassName = newsClassName;
		this.newsClassDate = newsClassDate;
		this.newsId = newsId;
		this.title = title;
		this.info = info;
		this.newsdate = newsdate;
		this.click = click;
	}
	public News() {
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
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	@Override
	public String toString() {
		return "News [newsClassId=" + newsClassId + ", newsClassName="
				+ newsClassName + ", newsClassDate=" + newsClassDate
				+ ", newsId=" + newsId + ", title=" + title + ", info=" + info
				+ ", newsdate=" + newsdate + ", click=" + click + "]";
	}
	
	
}
