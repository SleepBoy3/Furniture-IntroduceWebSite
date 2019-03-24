package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.ProductClassDao;
import com.ysd.entity.ProductClass;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.DBManager;

public class ProductClassDaoImpl implements ProductClassDao {

	@Override
	public List<ProductClass> getAllProductClassTopSi() {//前台首页显示的产品分类
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<ProductClass> list=new ArrayList<ProductClass>();
		String sql="select top(4) * from [productClass]";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("productClassId");
				String name=rs.getString("productClassName");
				String projectClassDate=rs.getString("productClassDate");
				ProductClass sc=new ProductClass(id, name, projectClassDate);
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
	public List<ProductClass> getAllProductClass() {//后台获取全部产品分类
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<ProductClass> list=new ArrayList<ProductClass>();
		String sql="select * from [productClass]";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("productClassId");
				String name=rs.getString("productClassName");
				String projectClassDate=rs.getString("productClassDate");
				ProductClass sc=new ProductClass(id, name, projectClassDate);
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
	public int deleteById(int id) {//后台修改
		Connection conn=null;
		Statement sta=null;
		conn=DBManager.getConnection();//连接数据库
		String sql="delete productClass where productClassId="+id;//根据id删除对应的产品类
		try {
			sta=conn.createStatement();
			int a=sta.executeUpdate(sql);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int AddProductClass(ProductClass cpl) {//后台添加
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="insert into productClass(productClassName) values('"+cpl.getName()+"')";//根据获取到的数据添加
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	public ProductClass getProductClassById(int id) {//后台查询的辅助方法，根据id获取该条数据
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		String sql="select * from [productClass] where productClassId="+id;//根据id获取对应的产品类
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int productClassId=rs.getInt("productClassId");
				String name=rs.getString("productClassName");
				String projectClassDate=rs.getString("productClassDate");
				return new ProductClass(productClassId, name, projectClassDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int UpdateProductClass(ProductClass cpl) {//后台修改
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="update productClass set productClassName='"+cpl.getName()+"' where productClassId="+cpl.getId();//根据获取到的数据修改
		int i=DBManager.executeUpdate(sql);
		return i;
	}

}
