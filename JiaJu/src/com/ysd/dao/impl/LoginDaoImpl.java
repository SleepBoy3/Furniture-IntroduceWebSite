package com.ysd.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.LoginDao;
import com.ysd.entity.Admin;
import com.ysd.entity.HProduct;
import com.ysd.entity.Images;
import com.ysd.entity.News;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;
import com.ysd.util.DBManager;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Admin get(String name, String pass) {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from [Admin] where username='"+name+"' and password='"+pass+"'";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");				
				String username=rs.getString("username");
				String pwd=rs.getString("password");
				Admin sc=new Admin(id, username, pwd);
				return sc;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Admin> getAll() {//后台获取全部图片
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<Admin> list=new ArrayList<Admin>();
		String sql="select * from [admin]";
		try {
			sta=conn.createStatement();//创建一个可以发送sql语句的对象
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				Admin sc=new Admin(id, username, password);
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
	public int AddAdmin(Admin a) {
		Connection conn=DBManager.getConnection();
		String sql="insert into admin(username,password) values('"+a.getName()+"','"+a.getPass()+"')";
		int i=DBManager.executeUpdate(sql);
		return i;
	}
	
	
	
	@Override
	public Admin getAllAdmin(int id) {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from [admin] where id="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				String username=rs.getString("username");
				String password=rs.getString("password");
				Admin sc=new Admin(id, username, password);
				return sc;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public int UpdateAdmin(Admin ad) {
		Connection conn=DBManager.getConnection();
		String sql="update admin set username='"+ad.getName()+"',password='"+ad.getPass()+"' where id="+ad.getId();
		int i=DBManager.executeUpdate(sql);
		return i;
	}
	
	@Override
	public int deleteById(int id) {//后台删除
		Connection conn=null;
		Statement sta=null;
		try {
			conn=DBManager.getConnection();
			sta=conn.createStatement();
			String sql="delete admin where id="+id;
			int a=sta.executeUpdate(sql);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int PlDelete(int id) {//后台根据id批量删除
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="DELETE FROM admin WHERE id="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}
}
