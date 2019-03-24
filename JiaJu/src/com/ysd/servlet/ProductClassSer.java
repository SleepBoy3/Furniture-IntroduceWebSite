package com.ysd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;

public class ProductClassSer extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name=request.getParameter("name");//获取首页面点击产品类的名字
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");//转成中文
		
		List<product> cp=new ProductDaoImpl().getAllproductByClassName(name);//前台根据名字查询对应产品分类的产品
		request.setAttribute("cp",cp);
		
		List<ProductClass> fenlei=new ProductClassDaoImpl().getAllProductClass();//产品类
		request.setAttribute("fenlei", fenlei);				
		
		request.getRequestDispatcher("productlist.jsp").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
