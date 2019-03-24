package com.ysd.entity;

public class product {
	private int productClassId;
	private String productClassName;
	private String projectClassDate;
	private int productId;
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
	private int imagesId;
	private String url;
	private String click;
	private String zhuTu;
	
	public product(int productClassId, String productClassName,
			String projectClassDate, int productId, String productName,
			String caiZhi, int yprice, int xprice, String brand, String size,
			String style, String color, String gPS, String dingZhi,
			String zuZhuang, String sheJi, String productDate, int imagesId,
			String url, String click, String zhuTu) {
		super();
		this.productClassId = productClassId;
		this.productClassName = productClassName;
		this.projectClassDate = projectClassDate;
		this.productId = productId;
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
		this.imagesId = imagesId;
		this.url = url;
		this.click = click;
		this.zhuTu = zhuTu;
	}

	public product() {
		super();
	}

	public int getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(int productClassId) {
		this.productClassId = productClassId;
	}

	public String getProductClassName() {
		return productClassName;
	}

	public void setProductClassName(String productClassName) {
		this.productClassName = productClassName;
	}

	public String getProjectClassDate() {
		return projectClassDate;
	}

	public void setProjectClassDate(String projectClassDate) {
		this.projectClassDate = projectClassDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getImagesId() {
		return imagesId;
	}

	public void setImagesId(int imagesId) {
		this.imagesId = imagesId;
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
		return "product [productClassId=" + productClassId
				+ ", productClassName=" + productClassName
				+ ", projectClassDate=" + projectClassDate + ", productId="
				+ productId + ", productName=" + productName + ", caiZhi="
				+ caiZhi + ", Yprice=" + Yprice + ", Xprice=" + Xprice
				+ ", brand=" + brand + ", size=" + size + ", style=" + style
				+ ", color=" + color + ", GPS=" + GPS + ", dingZhi=" + dingZhi
				+ ", zuZhuang=" + zuZhuang + ", sheJi=" + sheJi
				+ ", productDate=" + productDate + ", imagesId=" + imagesId
				+ ", url=" + url + ", click=" + click + ", zhuTu=" + zhuTu
				+ "]";
	}
	
	
	
	
}
