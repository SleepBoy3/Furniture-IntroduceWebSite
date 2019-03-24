package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.gongSiInfoDao;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.DBManager;



public class gongSiInfoDaoImpl implements gongSiInfoDao {

	@Override
	public List<gongSiInfo> getAllGongSiInfo() {//前台关于我们获取公司信息
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<gongSiInfo> list=new ArrayList<gongSiInfo>();
		String sql="select * from [gongSiInfo] where Ext='2'";//查询ext为2的那条数据
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String url=rs.getString("url");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String telephone=rs.getString("telephone");
				String zsTelephone=rs.getString("zsTelephone");
				String email=rs.getString("[e-mail");
				String diZhi=rs.getString("DiZhi");
				gongSiInfo sc=new gongSiInfo(id, url, title, info, telephone, zsTelephone, email, diZhi);
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
	public gongSiInfo getGongSiInfo() {//前台获取公司介绍
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		
		String sql="select * from [gongSiInfo] where Ext='1'";//查询ext为1的那条数据
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String url=rs.getString("url");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String telephone=rs.getString("telephone");
				String zsTelephone=rs.getString("zsTelephone");
				String email=rs.getString("[e-mail");
				String diZhi=rs.getString("DiZhi");
				return new gongSiInfo(id, url, title, info, telephone, zsTelephone, email, diZhi);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<gongSiInfo> getGongSiInfoH() {//后台获取全部公司信息
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		List<gongSiInfo> list=new ArrayList<gongSiInfo>();
		String sql="select * from [gongSiInfo]";//查询全部公司信息
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String url=rs.getString("url");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String telephone=rs.getString("telephone");
				String zsTelephone=rs.getString("zsTelephone");
				String email=rs.getString("[e-mail");
				String diZhi=rs.getString("DiZhi");
				gongSiInfo sc=new gongSiInfo(id, url, title, info, telephone, zsTelephone, email, diZhi);
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*@Override
	public int DeleteById(int id) {//后台删除
		Connection conn=DBManager.getConnection();
		String sql="delete gongSiInfo where id="+id;
		int i=DBManager.executeUpdate(sql);
		return i;
	}*/

	@Override
	public int AddgongSiInfo(gongSiInfo gsxw) {//后台添加
		// TODO Auto-generated method stub
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="insert into gongSiInfo(url,title,info,telephone,zsTelephone,[[e-mail],diZhi) values('"+gsxw.getUrl()+"','"+gsxw.getTitle()+"'," +"'"+gsxw.getInfo()+"','"+gsxw.getTelephone()+"','"+gsxw.getZsTelephone()+"','"+gsxw.getEmail()+"','"+gsxw.getDiZhi()+"')";//添加获取到的数据到数据库
		int i=DBManager.executeUpdate(sql);
		return i;
	}

	@Override
	public gongSiInfo gongSiInfoByid(int id) {//后台修改的辅助方法
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		conn=DBManager.getConnection();//连接数据库
		String sql=" select * from [gongSiInfo] where id="+id;//根据id查询数据
		try {
			sta=conn.createStatement();
			rs=sta.executeQuery(sql);
			while(rs.next()){
				int Id=rs.getInt("id");
				String url=rs.getString("url");
				String title=rs.getString("title");
				String info=rs.getString("info");
				String telephone=rs.getString("telephone");
				String zsTelephone=rs.getString("zsTelephone");
				String email=rs.getString("[e-mail");
				String diZhi=rs.getString("DiZhi");
				System.out.println(url);
				return   new gongSiInfo(Id, url, title, info, telephone, zsTelephone, email, diZhi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public int UpdateGongSiInfo(gongSiInfo gsxx) {//后台修改
		// TODO Auto-generated method stub
		Connection conn=DBManager.getConnection();//连接数据库
		String sql="update gongSiInfo set url='"+gsxx.getUrl()+"',title='"+gsxx.getTitle()+"',info='"+gsxx.getInfo()+"',telephone='"+gsxx.getTelephone()+"',zsTelephone='"+gsxx.getZsTelephone()+"',[[e-mail]='"+gsxx.getEmail()+"',diZhi='"+gsxx.getDiZhi()+"' where id="+gsxx.getId();//根据获取到的值修改id匹配的数据
		
		int i=DBManager.executeUpdate(sql);
		
		return i;
	}

}
