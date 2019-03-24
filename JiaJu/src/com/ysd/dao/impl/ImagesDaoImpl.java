package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.ImagesDao;
import com.ysd.entity.Images;
import com.ysd.entity.ProductClass;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.DBManager;

public class ImagesDaoImpl implements ImagesDao {

	@Override
	public List<Images> getAllLunBoImages() {//前台获取轮播图
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<Images> list=new ArrayList<Images>();
		String sql="select top(2) * from [images]";//搜索得到前两条数据，即轮播图
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("imagesId");
				int productId=rs.getInt("productId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				Images sc=new Images(id, productId, url,click, zhuTu);
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
	public List<Images> getAll() {//后台获取全部图片
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<Images> list=new ArrayList<Images>();
		String sql="select * from [images]";//查询全部图片
		try {
			sta=conn.createStatement();//创建一个可以发送sql语句的对象
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("imagesId");
				int productId=rs.getInt("productId");
				String url=rs.getString("url");
				String click=rs.getString("click");
				String zhuTu=rs.getString("zhuTu");
				Images sc=new Images(id, productId, url,click, zhuTu);
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
	public int DeleteById(int id) {//后台删除
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="delete images where imagesId="+id;//根据id删除该条数据
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	public int AddImages(Images i) {//后台添加图片
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="insert into images(productId,url,click,zhuTu) values('"+i.getProductId()+"','"+i.getUrl()+"','"+i.getClick()+"','"+i.getZhuTu()+"')";//根据获取到的值添加数据
		int a=DBManager.executeUpdate(sql);
		return a;
	}



	@Override
	public int PlDelete(int id) {//后台根据id批量删除
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="DELETE FROM images WHERE imagesId="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}
	
	

}








