package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ysd.dao.ProductDao;
import com.ysd.entity.HProduct;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;
import com.ysd.util.DBManager;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<product> getAllproductByZhuTu() {//前台显示精选产品，必须图片是主图并且倒叙排序
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<product> list=new ArrayList<product>();
		//String sql="select top(6) * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId order by i.click desc";
		String sql="select top(6) * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId where i.zhuTu='是'  order by i.click desc";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url, click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<product> getZhuTu() {//在产品页面显示产品并且图片为主图
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//
		List<product> list=new ArrayList<product>();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId where i.zhuTu='是'";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url, click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<product> getFuTu(String id) {//前台根据id获取产品详细信息以用到产品详细信息的图片排
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<product> list=new ArrayList<product>();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId where p.productId="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url, click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<product> getAllproductByClassName(String name) {//前台根据名字查询对应产品分类的产品
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<product> list=new ArrayList<product>();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId where pc.productClassName='"+name+"' and i.zhuTu='是'";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url,click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public product getproductById(Integer id) {//前台根据id显示对应的产品信息
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId where p.productId="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				return new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url,click, zhuTu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/*@Override
	public List<product> getAllproduct() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId";
		List<product> list=new ArrayList<product>();
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url,click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	

	/*@Override
	public List<product> getHAllProduct() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from productClass pc inner join product p on pc.productClassId=p.productClassId inner join images i on p.productId=i.productId";
		List<product> list=new ArrayList<product>();
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String productClassName=rs.getString("productClassName");
				String productClassDate=rs.getString("productClassDate");
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				int imagesId=rs.getInt("imagesId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				product sc=new product(productClassId, productClassName, productClassDate, productId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate, imagesId, url,click, zhuTu);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

	

	@Override
	public int deleteById(int id) {//后台删除
		Connection conn=null;
		Statement sta=null;
		try {
			conn=DBManager.getConnection();//连接数据库
			sta=conn.createStatement();
			String sql="delete product where productId="+id;//根据id删除
			int a=sta.executeUpdate(sql);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	
	@Override
	public HProduct ProductById(int id) {//后台查询的辅助方法
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		String sql="select * from product where productId="+id;//根据id查询该条数据
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				
				int productId=rs.getInt("productId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				String productDate=rs.getString("productDate");
				return new HProduct(productId, productClassId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, productDate);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int AddProduct(product cp) {//后台添加
		Connection conn=DBManager.getConnection();
		String sql="insert into product(productClassId,productName,caiZhi,Y_price,X_price,brand,size,style,color,GPS,dingZhi,zuZhuang,sheJi) values('"+cp.getProductClassId()+"','"+cp.getProductName()+"','"+cp.getCaiZhi()+"','"+cp.getYprice()+"','"+cp.getXprice()+"','"+cp.getBrand()+"','"+cp.getSize()+"','"+cp.getStyle()+"','"+cp.getColor()+"','"+cp.getGPS()+"','"+cp.getDingZhi()+"','"+cp.getZuZhuang()+"','"+cp.getSheJi()+"')";//根据获取到的值添加
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	public List<HProduct> HAllProduct() {//后台查询全部产品
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<HProduct> list=new ArrayList<HProduct>();
		String sql="select * from [product]";//查询全部产品
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productId=rs.getInt("productId");
				int productClassId=rs.getInt("productClassId");
				String productName=rs.getString("productName");
				String caiZhi=rs.getString("caiZhi");
				int Yprice=rs.getInt("Y_price");
				int Xprice=rs.getInt("X_price");
				String brand=rs.getString("brand");
				String size=rs.getString("size");
				String style=rs.getString("style");
				String color=rs.getString("color");
				String GPS=rs.getString("GPS");
				String dingZhi=rs.getString("dingZhi");
				String zuZhuang=rs.getString("zuZhuang");
				String sheJi=rs.getString("sheJi");
				HProduct sc=new HProduct(productId,productClassId, productName, caiZhi, Yprice, Xprice, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, null);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int UpdateProduct(HProduct cp) {//后台修改
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="update product set productClassId='"+cp.getProductClassId()+"',productName='"+cp.getProductName()+"',caiZhi='"+cp.getCaiZhi()+"',Y_price='"+cp.getYprice()+"',X_price='"+cp.getXprice()+"',brand='"+cp.getBrand()+"',size='"+cp.getSize()+"',style='"+cp.getStyle()+"',color='"+cp.getColor()+"',GPS='"+cp.getGPS()+"',dingZhi='"+cp.getDingZhi()+"',zuZhuang='"+cp.getZuZhuang()+"',sheJi='"+cp.getSheJi()+"' where productId="+cp.getProductId();//根据获取到的值修改id匹配的数据
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	public int PlDelete(int id) {
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="DELETE FROM [product] WHERE productId="+id;//根据获取到的值修改id匹配的数据
		int i=DBManager.executeUpdate(sql);
		return i;
	}

}
