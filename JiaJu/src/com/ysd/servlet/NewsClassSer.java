package com.ysd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.NewsClassDaoImpl;
import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.entity.News;
import com.ysd.entity.NewsClass;



public class NewsClassSer extends HttpServlet {

	/*
	 * 类别
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(name);
		List<News> news=new NewsDaoImpl().getNewsByName(name);
		request.setAttribute("news", news);
		
		List<NewsClass> lei=new NewsClassDaoImpl().getAllNewsClass();
		request.setAttribute("lei", lei);
		
		request.getRequestDispatcher("article_list.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
