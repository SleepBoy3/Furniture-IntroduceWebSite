package com.ysd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.ImagesDao;
import com.ysd.dao.LiuYanDao;
import com.ysd.entity.Images;
import com.ysd.entity.Liuyan;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.DBManager;

public class LiuYanDaoImpl implements LiuYanDao {
	
	
	/**
	 * 前台添加留言
	 * */
	@Override
	public int setLiuYan(Liuyan ly) {
		Connection conn=DBManager.getConnection();//
		String sql="insert into Liuyan(name,telephone,email,message,huiFu,zhuangTai) values('"+ly.getName()+"','"+ly.getTelephone()+"','"+ly.getEmail()+"','"+ly.getInfo()+"','null','未回复')";
		int i=DBManager.executeUpdate(sql);//调用DBManager中的方法（executeUpdate()）把sql语句传进去，返回一条 成功的影响行数用int类型接受 
		return i;
		
	}
	
	
	
		/**
		 * 后台显示全部留言
		 * */
		@Override
		public List<Liuyan> getAllLiuYan() {
			Connection conn=null;
			Statement sta=null;
			ResultSet rs=null;
			conn=DBManager.getConnection();
			List<Liuyan> list=new ArrayList<Liuyan>();
			String sql="select * from [LiuYan]";
			try {
				sta=conn.createStatement();
				rs=sta.executeQuery(sql);
				while(rs.next()){
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String telephone=rs.getString("telephone");
					String email=rs.getString("email");
					String info=rs.getString("message");
					String date=rs.getString("date");
					String huifu=rs.getString("huiFu");
					String zhuangTai=rs.getString("zhuangTai");
					Liuyan sc=new  Liuyan(id,name,telephone,email,info,date,huifu,zhuangTai); 
					list.add(sc);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}


		/**
		 * 跟id删除
		 * */
		@Override
		public int DeleteById(int id) {
			Connection conn=DBManager.getConnection();
			String sql="delete liuYan where id="+id;
			int i=DBManager.executeUpdate(sql);
			return i;
		}


	

		/**
		 * 根据id搜索管理员要回复的具体那一条留言
		 * */
		@Override
		public Liuyan LiuYanHF(int id) {
			// TODO Auto-generated method stub
			Connection conn=null;
			Statement sta=null;
			ResultSet rs=null;
			conn=DBManager.getConnection();
			
			String sql="select * from [LiuYan] where id="+id;
			try {
				sta=conn.createStatement();
				rs=sta.executeQuery(sql);
				while(rs.next()){
					int id1=rs.getInt("id");
					String name=rs.getString("name");
					String telephone=rs.getString("telephone");
					String email=rs.getString("email");
					String info=rs.getString("message");
					String date=rs.getString("date");
					String huifu=rs.getString("huiFu");
					String zhuangTai=rs.getString("zhuangTai");
					return new  Liuyan(id1,name,telephone,email,info,date,huifu,zhuangTai); 
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 查找到回复留言
		 * 连接数据库后
		 * sql语句判定回复字段是否不等空
		 * 等空时把状态设置成已回复字段
		 * */
		@Override
		public int UpdateLiuYanHF(Liuyan ly) {
			// TODO Auto-generated method stub
			Connection conn=DBManager.getConnection();
			if(ly.getHuifu()!=null){
				String sql="update liuYan set huiFu='"+ly.getHuifu()+"',zhuangTai='已回复'   where id="+ly.getId();	
				int i=DBManager.executeUpdate(sql);
				return i;
			}else{
				String sql="update liuYan set huiFu='"+ly.getHuifu()+"',zhuangTai='未回复'   where id="+ly.getId();
				int i=DBManager.executeUpdate(sql);
				return i;
			}		
		}
		
		@Override
		public int PlDelete(int id) {//后台根据id批量删除
			Connection conn=DBManager.getConnection();//连接数据库
			String sql="DELETE FROM liuYan WHERE id="+id;
			int i=DBManager.executeUpdate(sql);
			return i;
		}

}
