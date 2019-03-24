package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.NewsClassDao;
import com.ysd.entity.News;
import com.ysd.entity.NewsClass;
import com.ysd.util.DBManager;

public class NewsClassDaoImpl implements NewsClassDao {

	@Override
	/*
	 * 所有新闻类别
	 * */
	public List<NewsClass> getAllNewsClass() {
		
			Connection conn=null;
			Statement sta=null;
			ResultSet rs=null;
			conn=DBManager.getConnection();
			List<NewsClass> list=new ArrayList<NewsClass>();
			String sql="select * from newsClass ";
			try {
				sta=conn.createStatement();
				rs=sta.executeQuery(sql);
				while(rs.next()){
					int newsClassId=rs.getInt("newsClassId");
					String newsClassName=rs.getString("newsClassName");
					String newsClassDate=rs.getString("date");				
					NewsClass sc=new NewsClass(newsClassId, newsClassName,newsClassDate);
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
	/*
	 * 删除
	 * */
	public int DelectNews(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		String sql="delete newsClass where newsClassId="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	/*
	 * 添加
	 * */
	public int AddNews(NewsClass xwl) {
		// TODO Auto-generated method stub
		Connection conn=DBManager.getConnection();
		String sql="insert into newsClass(newsClassName) values('"+xwl.getNewsClassName()+"') ";
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	/*
	 * 新闻类别
	 * */
	public NewsClass NewsByid(int id) {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		String sql="select * from newsClass where newsClassId="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsClassId=rs.getInt("newsClassId");
				String newsClassName=rs.getString("newsClassName");
				String newsClassDate=rs.getString("date");				
				return new NewsClass(newsClassId, newsClassName,newsClassDate);
									
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/*
	 * 修改
	 * */
	public int UpdateNews(NewsClass xwl) {
		Connection conn=DBManager.getConnection();
		String sql="update newsClass set newsClassName='"+xwl.getNewsClassName()+"' where newsClassId="+xwl.getNewsClassId();
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	
	
}
