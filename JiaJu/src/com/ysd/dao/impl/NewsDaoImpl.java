package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.NewsDao;
import com.ysd.entity.HNews;
import com.ysd.entity.News;
import com.ysd.util.DBManager;

public class NewsDaoImpl implements NewsDao {
	
	@Override
	/*
	 * 头条
	 * */
	public List<News> getTouTiao() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<News> list=new ArrayList<News>();
		String sql="select top(5) * from News n join newsClass nc on n.newsClassId=nc.newsClassId order by n.click desc";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsClassId=rs.getInt("newsClassId");
				String newsClassName=rs.getString("newsClassName");
				String newsClassDate=rs.getString("date");
				int newsId=rs.getInt("newsId");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String newsdate=rs.getString("date");
				int click=rs.getInt("click");
				
				News sc=new News(newsClassId, newsClassName,newsClassDate, newsId, title, info, newsdate, click);
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
	 * 根据id查询
	 * */
	public News getNewsById(int id) {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		
		String sql="select * from News n join newsClass nc on n.newsClassId=nc.newsClassId where n.newsId="+id;
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsClassId=rs.getInt("newsClassId");
				String newsClassName=rs.getString("newsClassName");
				String newsClassDate=rs.getString("date");
				int newsId=rs.getInt("newsId");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String newsdate=rs.getString("date");
				int click=rs.getInt("click");
				
				return new News(newsClassId, newsClassName,newsClassDate, newsId, title, info, newsdate, click);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/*
	 * 根据根据标题查询的方法
	 * */
	public List<News> getNewsByName(String name) {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<News> list=new ArrayList<News>();
		String sql="select * from News n join newsClass nc on n.newsClassId=nc.newsClassId where nc.newsClassName='"+name+"'";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsClassId=rs.getInt("newsClassId");
				String newsClassName=rs.getString("newsClassName");
				String newsClassDate=rs.getString("date");
				int newsId=rs.getInt("newsId");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String newsdate=rs.getString("date");
				int click=rs.getInt("click");
				
				News sc=new News(newsClassId, newsClassName,newsClassDate, newsId, title, info, newsdate, click);
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
	 * 所有前台新闻
	 * */
	public List<News> getAllNews() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<News> list=new ArrayList<News>();
		String sql="select * from News n join newsClass nc on n.newsClassId=nc.newsClassId";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsClassId=rs.getInt("newsClassId");
				String newsClassName=rs.getString("newsClassName");
				String newsClassDate=rs.getString("date");
				int newsId=rs.getInt("newsId");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String newsdate=rs.getString("date");
				int click=rs.getInt("click");
				
				News sc=new News(newsClassId, newsClassName,newsClassDate, newsId, title, info, newsdate, click);
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
	 * 根据id删除
	 * */
	public int DeleteNewsById(int id) {
		Connection conn=DBManager.getConnection();
		String sql="delete News where newsId="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	/*
	 * 添加 
	 * */
	public int AddNews(News xw) {
		Connection conn=DBManager.getConnection();
		String sql="insert into News(newsClassId,title,info,click)  values('"+xw.getNewsClassId()+"','"+xw.getTitle()+"','"+xw.getInfo()+"','"+xw.getClick()+"')";
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	

	@Override
	/*
	 * 修改
	 * */
	public int UpdateNews(HNews xw) {
		Connection conn=DBManager.getConnection();
		String sql="update News set newsClassId='"+xw.getNewsClassId()+"',title='"+xw.getTitle()+"',info='"+xw.getInfo()+"',click='"+xw.getClick()+"' where newsId="+xw.getNewsId();
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	/*
	 * 所有后台新闻
	 * */
	public List<HNews> getAllHNews() {
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();
		List<HNews> list=new ArrayList<HNews>();
		String sql="select * from News";
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int newsId=rs.getInt("newsId");
				int newsClassId=rs.getInt("newsClassId");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String newsdate=rs.getString("date");
				int click=rs.getInt("click");
				
				HNews sc=new HNews(newsId,newsClassId, title, info, newsdate, click);
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
	public int PlDelete(int id) {//后台根据id批量删除
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="DELETE FROM News WHERE NewsId="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}
	
}
