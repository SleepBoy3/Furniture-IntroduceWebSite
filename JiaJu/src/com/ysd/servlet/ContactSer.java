package com.ysd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.gongSiInfo;
import com.ysd.entity.Liuyan;

public class ContactSer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		gongSiInfo list=new gongSiInfoDaoImpl().getGongSiInfo();//前台获取公司介绍
		request.setAttribute("gsxx", list);
		
		request.getRequestDispatcher("contact.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
