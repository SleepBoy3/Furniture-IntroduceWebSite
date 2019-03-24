package com.ysd.entity;

public class HNews {
	private int newsId;
	private int newsClassId;
	private String title;
	private String info;
	private String newsdate;
	private int click;
	public HNews(int newsId, int newsClassId, String title, String info,
			String newsdate, int click) {
		super();
		this.newsId = newsId;
		this.newsClassId = newsClassId;
		this.title = title;
		this.info = info;
		this.newsdate = newsdate;
		this.click = click;
	}
	public HNews() {
		super();
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getNewsClassId() {
		return newsClassId;
	}
	public void setNewsClassId(int newsClassId) {
		this.newsClassId = newsClassId;
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
		return "HNews [newsId=" + newsId + ", newsClassId=" + newsClassId
				+ ", title=" + title + ", info=" + info + ", newsdate="
				+ newsdate + ", click=" + click + "]";
	}
	
}
