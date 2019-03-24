package com.ysd.entity;

public class Images {
	private int id;
	private int productId;
	private String url;
	private String click;
	private String zhuTu;
	
	public Images(int id, int productId, String url, String click, String zhuTu) {
		super();
		this.id = id;
		this.productId = productId;
		this.url = url;
		this.click = click;
		this.zhuTu = zhuTu;
	}

	public Images() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getZhuTu() {
		return zhuTu;
	}

	public void setZhuTu(String zhuTu) {
		this.zhuTu = zhuTu;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", productId=" + productId + ", url=" + url
				+ ", click=" + click + ", zhuTu=" + zhuTu + "]";
	}
	
	
	
	
	
}
