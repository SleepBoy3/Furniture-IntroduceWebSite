package com.ysd.entity;

public class Liuyan {
	private int id;
	private String name;
	private String telephone;
	private String email;
	private String info;
	private String date;
	private String huifu;
	private String zhuangTai;
	public Liuyan(int id, String name, String telephone, String email,
			String info, String date, String huifu, String zhuangTai) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.info = info;
		this.date = date;
		this.huifu = huifu;
		this.zhuangTai = zhuangTai;
	}
	public Liuyan() {
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHuifu() {
		return huifu;
	}
	public void setHuifu(String huifu) {
		this.huifu = huifu;
	}
	public String getZhuangTai() {
		return zhuangTai;
	}
	public void setZhuangTai(String zhuangTai) {
		this.zhuangTai = zhuangTai;
	}
	@Override
	public String toString() {
		return "Liuyan [id=" + id + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", info=" + info + ", date="
				+ date + ", huifu=" + huifu + ", zhuangTai=" + zhuangTai + "]";
	}
	
}
