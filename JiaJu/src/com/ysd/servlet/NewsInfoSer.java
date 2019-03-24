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




public class NewsInfoSer extends HttpServlet {
	/*
	 * 新闻内容
	 * */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		News news=new NewsDaoImpl().getNewsById(id);
		List<News> newsAll=new NewsDaoImpl().getAllNews();//查询全部
		News xw=new News();
		for(int i=id-1;i>=0;i--){//上一篇
			xw=new NewsDaoImpl().getNewsById(i); 
			if(xw!=null){
				request.setAttribute("sxw", xw);
				break;
			}
		}
		for(int i=id+1;i<newsAll.size()+1;i++){//下一篇
				xw=new NewsDaoImpl().getNewsById(i); 
				if(xw!=null){
					request.setAttribute("xxw", xw);
					break;
				}
		}
		request.setAttribute("news", news);
		
		List<NewsClass> lei=new NewsClassDaoImpl().getAllNewsClass();
		request.setAttribute("lei", lei);
		
		request.getRequestDispatcher("article_list_content.jsp").forward(request, response);
		
			
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
