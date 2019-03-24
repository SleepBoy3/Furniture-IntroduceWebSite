package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.SheJiShiDao;
import com.ysd.entity.SheJiShi;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.DBManager;

public class SheJiShiDaoImpl implements SheJiShiDao {

	
	/*
	 * 前台显示四条设计师数据
	 * */
	@Override
	public List<SheJiShi> getSheJiShiTopSi() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<SheJiShi> list=new ArrayList<SheJiShi>();
		String sql="select top(4) * from [sheJiShi]";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String tuPian=rs.getString("tuPian");
				String name=rs.getString("name");
				String info=rs.getString("info");
				
				SheJiShi sc=new SheJiShi(id, tuPian, name, info);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	
	
	
		/*
		 * 后台显示所有设计师数据
		 * */
	@Override
	public List<SheJiShi> getAllSheJiShi() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<SheJiShi> list=new ArrayList<SheJiShi>();
		String sql="select * from [sheJiShi]";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String tuPian=rs.getString("tuPian");
				String name=rs.getString("name");
				String info=rs.getString("info");
				
				SheJiShi sc=new SheJiShi(id, tuPian, name, info);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 根据id删除一条设计师
	 * */
	@Override
	public int DeleteById(int id) {
		Connection conn=DBManager.getConnection();
		String sql="delete sheJiShi where id="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	
	/*
	 * 添加设计师
	 * */
	@Override
	public int AddSheJiShi(SheJiShi sjs) {
		Connection conn=DBManager.getConnection();
		String sql="insert into sheJiShi(name,tuPian,info) values('"+sjs.getName()+"','"+sjs.getTuPian()+"','"+sjs.getInfo()+"')";
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	
	/*
	 * 根据id搜索设计师，
	 * */
	@Override
	public SheJiShi SheJiShiById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from [sheJiShi] where id="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int sheJiShiId=rs.getInt("id");
				String name=rs.getString("name");
				String tuPian=rs.getString("tuPian");
				String info=rs.getString("info");
				return new SheJiShi(sheJiShiId, tuPian, name, info);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	 * 修改设计师
	 * */
	@Override
	public int updateSheJiShi(SheJiShi sjs) {
		// TODO Auto-generated method stub
		Connection conn=DBManager.getConnection();
		String sql="update sheJiShi set name='"+sjs.getName()+"',tuPian='"+sjs.getTuPian()+"',info='"+sjs.getInfo()+"' where id="+sjs.getId();
		int i=DBManager.executeUpdate(sql);
		return i;
		
	}

	@Override
	public int PlDelete(int id) {//后台根据id批量删除
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="DELETE FROM sheJiShi WHERE id="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}

}
