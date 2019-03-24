package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.NewsClassDaoImpl;
import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.entity.HNews;
import com.ysd.entity.NewsClass;
import com.ysd.util.Result;

public class NewsClassServlet extends BaseServlet {
	/*
	 *查询所有
	 * */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			 List<NewsClass> newsLei=new NewsClassDaoImpl().getAllNewsClass();
			 request.setAttribute("xw", newsLei);
			 request.getRequestDispatcher("/manae/NewsClass.jsp").forward(request, response);
	}
	/*
	 * 编辑中所用的根据id查询
	 * */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		System.out.println(Integer.parseInt(id));
		NewsClass news=new NewsClassDaoImpl().NewsByid(Integer.parseInt(id));
		request.setAttribute("news",news);
		request.getRequestDispatcher("/manae/UpdateNewsClass.jsp").forward(request, response);
	}
	/*
	 * 删除
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		List<NewsClass> newsLei=new NewsClassDaoImpl().getAllNewsClass();
		for(int i=0;i<newsLei.size();i++){
			if(!newsLei.get(i).getNewsClassName().equals("家具新闻")||
			   !newsLei.get(i).getNewsClassName().equals("行业新闻")||
			   !newsLei.get(i).getNewsClassName().equals("公司新闻")){
				int x=new NewsClassDaoImpl().DelectNews(Integer.parseInt(id));
					if(x>0){
						out.print(Result.toClient(true, "删除成功！"));
					}else{
						out.print(Result.toClient(false, "删除失败！"));
					}
			}else{
				out.print("基础信息不能删除");
			}	
		}
	}
	/*
	 * 修改
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");
		String newsClassName=request.getParameter("newsClass");
		NewsClass sc=new NewsClass(Integer.parseInt(id), newsClassName, null);
		int i=new NewsClassDaoImpl().UpdateNews(sc);
		if(i>0){
			out.print(Result.toClient(true, "修改成功！"));
		}else{
			out.print(Result.toClient(false, "修改失败！"));
		}
	}
	
	
	
	/*
	 * 添加
	 * */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String newsClass=request.getParameter("newsClass");
		NewsClass sc=new NewsClass(0,newsClass,null);
		int i=new  NewsClassDaoImpl().AddNews(sc);
		if(i>0){
			out.print(Result.toClient(true, "添加成功！"));
		}else{
			out.print(Result.toClient(false, "添加失败！"));
		}
	}
	/*
	 * 搜索
	 * */
	public void chaXun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<NewsClass> all=new NewsClassDaoImpl().getAllNewsClass();//调用根据新闻类别查询的方法
		List<NewsClass> a=new ArrayList<NewsClass>();
		if(name!=null){
			for(int i=0;i<all.size();i++){
				if(all.get(i).getNewsClassName().contains(name)){//将输出name值与数据库中的值进行匹配
					a.add(all.get(i));
				}else{
					if(i==all.size()){
						break;
					}else{
						continue;
					}
				}
				request.setAttribute("xw", a);
			}
		}
		request.getRequestDispatcher("/manae/NewsClass.jsp").forward(request, response);
	}
}
