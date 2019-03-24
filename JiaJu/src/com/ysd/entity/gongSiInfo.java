package com.ysd.entity;

public class gongSiInfo {
	private int id;
	private String url;
	private String title;
	private String info;
	private String telephone;
	private String zsTelephone;
	private String email;
	private String diZhi;
	public gongSiInfo(int id, String url, String title, String info,
			String telephone, String zsTelephone, String email, String diZhi) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.info = info;
		this.telephone = telephone;
		this.zsTelephone = zsTelephone;
		this.email = email;
		this.diZhi = diZhi;
	}
	public gongSiInfo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getZsTelephone() {
		return zsTelephone;
	}
	public void setZsTelephone(String zsTelephone) {
		this.zsTelephone = zsTelephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiZhi() {
		return diZhi;
	}
	public void setDiZhi(String diZhi) {
		this.diZhi = diZhi;
	}
	@Override
	public String toString() {
		return "gongSiInfo [id=" + id + ", url=" + url + ", title="
				+ title + ", info=" + info + ", telephone=" + telephone
				+ ", zsTelephone=" + zsTelephone + ", email=" + email
				+ ", diZhi=" + diZhi + "]";
	}
	
	
	
}
