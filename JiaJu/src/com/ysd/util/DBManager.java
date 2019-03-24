package com.ysd.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	private static final String driverNaem="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433;databaseName=Project";
	private static final String user="sa",pwd="123@qwe";
	public static Connection getConnection(){
		try {
			Class.forName(driverNaem);
			return DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int executeUpdate(String sql){
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		try {
			conn = getConnection();
			sta = conn.createStatement();
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getErrorCode()*(-1);
		}
		finally{
			closeAll(conn,sta,null);
		}
		
	}
	public static void closeAll(Connection conn,Statement sta,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(sta!=null)
				sta.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int executeQuery(String sql){
		Connection conn=null;
		Statement sta=null;
		ResultSet rs=null;
		try {
			conn = getConnection();
			sta = conn.createStatement();
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
