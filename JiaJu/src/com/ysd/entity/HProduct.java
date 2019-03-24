package com.ysd.entity;

public class HProduct {
	private int productId;
	private int productClassId;
	private String productName;
	private String caiZhi;
	private int Yprice;
	private int Xprice;
	private String brand;
	private String size;
	private String style;
	private String color;
	private String GPS;
	private String dingZhi;
	private String zuZhuang;
	private String sheJi;
	private String productDate;
	
	public HProduct(int productId, int productClassId, String productName,
			String caiZhi, int yprice, int xprice, String brand, String size,
			String style, String color, String gPS, String dingZhi,
			String zuZhuang, String sheJi, String productDate) {
		super();
		this.productId = productId;
		this.productClassId = productClassId;
		this.productName = productName;
		this.caiZhi = caiZhi;
		Yprice = yprice;
		Xprice = xprice;
		this.brand = brand;
		this.size = size;
		this.style = style;
		this.color = color;
		GPS = gPS;
		this.dingZhi = dingZhi;
		this.zuZhuang = zuZhuang;
		this.sheJi = sheJi;
		this.productDate = productDate;
	}

	public HProduct() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(int productClassId) {
		this.productClassId = productClassId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCaiZhi() {
		return caiZhi;
	}

	public void setCaiZhi(String caiZhi) {
		this.caiZhi = caiZhi;
	}

	public int getYprice() {
		return Yprice;
	}

	public void setYprice(int yprice) {
		Yprice = yprice;
	}

	public int getXprice() {
		return Xprice;
	}

	public void setXprice(int xprice) {
		Xprice = xprice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gPS) {
		GPS = gPS;
	}

	public String getDingZhi() {
		return dingZhi;
	}

	public void setDingZhi(String dingZhi) {
		this.dingZhi = dingZhi;
	}

	public String getZuZhuang() {
		return zuZhuang;
	}

	public void setZuZhuang(String zuZhuang) {
		this.zuZhuang = zuZhuang;
	}

	public String getSheJi() {
		return sheJi;
	}

	public void setSheJi(String sheJi) {
		this.sheJi = sheJi;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	@Override
	public String toString() {
		return "HProduct [productId=" + productId + ", productClassId="
				+ productClassId + ", productName=" + productName + ", caiZhi="
				+ caiZhi + ", Yprice=" + Yprice + ", Xprice=" + Xprice
				+ ", brand=" + brand + ", size=" + size + ", style=" + style
				+ ", color=" + color + ", GPS=" + GPS + ", dingZhi=" + dingZhi
				+ ", zuZhuang=" + zuZhuang + ", sheJi=" + sheJi
				+ ", productDate=" + productDate + "]";
	}
	
	
}
