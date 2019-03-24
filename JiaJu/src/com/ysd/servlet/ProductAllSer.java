package com.ysd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;

public class ProductAllSer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");//设置输出内容的编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");//设置输出的类型
		PrintWriter out=response.getWriter();
		List<product> cx=new ArrayList<product>();
		String jg=request.getParameter("ss");
		//前台产品搜索
		if(jg!=null){//如果输入的值不为空进这里
			List<product> cp=new ProductDaoImpl().getZhuTu();//查询出所有产品并且图片为主图
			jg=new String (jg.getBytes("ISO-8859-1"),"UTF-8");
			for(int i=0;i<cp.size();i++){
				if(cp.get(i).getProductName().contains(jg)){//模糊查询
					cx.add(cp.get(i));
					
				}else{
					continue;
				}
				
			}
			request.setAttribute("cp", cx);
		}else{//如果为空进这里
			List<product> cp=new ProductDaoImpl().getZhuTu();//查询出所有产品并且图片为主图
			request.setAttribute("cp", cp);
		}
						
		List<ProductClass> fenlei=new ProductClassDaoImpl().getAllProductClassTopSi();//前台首页的产品分类
		request.setAttribute("fenlei", fenlei);
		
		request.getRequestDispatcher("productAll.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
