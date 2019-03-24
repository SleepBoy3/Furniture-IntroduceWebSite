package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.NewsClassDaoImpl;
import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.entity.HNews;
import com.ysd.entity.News;
import com.ysd.entity.NewsClass;
import com.ysd.util.Result;



public class NewsServlet extends BaseServlet {
	/*
	 * //查询所有
	 * */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		List<HNews> newsAll=new NewsDaoImpl().getAllHNews();
		request.setAttribute("xw", newsAll);
		request.getRequestDispatcher("/manae/News.jsp").forward(request, response);
	}
	
	
	
	/*
	 * //编辑中根据id查询的方法
	 * */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式

		String id=request.getParameter("id");
		News news=new NewsDaoImpl().getNewsById(Integer.parseInt(id));
		request.setAttribute("news",news);
		
		List<NewsClass> newsLei=new NewsClassDaoImpl().getAllNewsClass();
		 request.setAttribute("newsLei", newsLei);
		 
		request.getRequestDispatcher("/manae/UpdateNews.jsp").forward(request, response);
	}
	public void XiaLa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {//添加方法中下拉框
		request.setCharacterEncoding("UTF-8");//设置编码格式
		 List<NewsClass> newsLei=new NewsClassDaoImpl().getAllNewsClass();
		 request.setAttribute("newsLei", newsLei);//存值
		 request.getRequestDispatcher("/manae/AddNews.jsp").forward(request, response);
		
	}
	
	
	/*
	 * //删除
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");
		int i=new NewsDaoImpl().DeleteNewsById(Integer.parseInt(id));//调用删除方法
		if(i>0){
			out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.print(Result.toClient(false, "删除失败！"));
		}
	}
	/*
	 * //修改
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");
		String newsClass=request.getParameter("newsClass");
		String title=request.getParameter("title");
		String info=request.getParameter("info");
		String click=request.getParameter("click");//获取到文本框中的值
		HNews sc=new HNews(Integer.parseInt(id), Integer.parseInt(newsClass), title, info, null, Integer.parseInt(click));
		int i=new NewsDaoImpl().UpdateNews(sc);//调用实现类中的实现方法
		if(i>0){
			out.print(Result.toClient(true, "修改成功！"));
		}else{
			out.print(Result.toClient(false, "修改失败！"));
		}
	}
	
	/*
	 * //添加
	 * */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String newsClass=request.getParameter("newsClass");
		String title=request.getParameter("title");
		String info=request.getParameter("info");
		String click=request.getParameter("click");//获取到文本框中的值
		News sc=new News(Integer.parseInt(newsClass), null, null, 0, title, info, null,Integer.parseInt(click));
		int i=new NewsDaoImpl().AddNews(sc);//调用实现类中的实现方法
		if(i>0){
			out.print(Result.toClient(true, "添加成功！"));
		}else{
			out.print(Result.toClient(false, "添加失败！"));
		}
	}
	/*
	 *搜索方法
	 * 
	 * */
	public void chaXun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		String name=request.getParameter("name");
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<NewsClass> all=new NewsClassDaoImpl().getAllNewsClass();//调用根据新闻类别查询的方法
		List<NewsClass> a=new ArrayList<NewsClass>();
		if(name!=null){//当名字不等于空的时候
			for(int i=0;i<all.size();i++){//for循环
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
		request.getRequestDispatcher("/manae/News.jsp").forward(request, response);
	}
	/*批量删除
	 * 
	 */
	public void piLiang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();//向JSP页面输出结果 
		request.setCharacterEncoding("UTF-8");//设置编码格式
		String[] pl=request.getParameterValues("xz");
		int x=0;
		if(pl!=null){
			for(int i=0;i<pl.length;i++){
				x=new NewsDaoImpl().PlDelete(Integer.parseInt(pl[i]));
			}
			if(x>0){
				out.print(Result.toClient(true,"删除成功！"));
			}else{
				out.print(Result.toClient(false,"删除失败！"));
			}	
		}
	}
}

