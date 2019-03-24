package com.ysd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.LiuYanDaoImpl;
import com.ysd.entity.Liuyan;



public class LiuyanSer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置输出内容的编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");//设置输出的类型；
		PrintWriter out=response.getWriter();
				//获取页面文本框的值
				String name=request.getParameter("username");
				//name=new String (name.getBytes("ISO-8859-1"),"UTF-8");
				String telephone=request.getParameter("tel");
				String email=request.getParameter("email");
				String info=request.getParameter("info");
				//info=new String (info.getBytes("ISO-8859-1"),"UTF-8");
				Liuyan ly=new Liuyan(0,name, telephone, email, info,null,null,null);//实例化一个Liuyan对象，把从页面中得到的数据赋给ly
				LiuYanDaoImpl lyadd=new LiuYanDaoImpl();//实例化一个LiuyanDaoImpl实现类对象赋给变量lyadd
				int i=lyadd.setLiuYan(ly);
				
				if(i>0){
						out.println("<script> alert('提交成功');location.href='/JiaJu/message.jsp';</script>");
				}else{
						out.println("<script> alert('提交失败');location.href='/JiaJu/message.jsp';</script>");
						
					
				}
				
			}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
