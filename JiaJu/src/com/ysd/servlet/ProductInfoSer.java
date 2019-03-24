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

public class ProductInfoSer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		product cpinfo=new ProductDaoImpl().getproductById(Integer.parseInt(id));//前台根据id查询对应的产品信息
		request.setAttribute("cpinfo", cpinfo);
		
		List<ProductClass> fenlei=new ProductClassDaoImpl().getAllProductClassTopSi();//产品类
		request.setAttribute("fenlei", fenlei);
		
		List<product> ft=new ProductDaoImpl().getFuTu(id);//前台产品详细信息的图片列
		request.setAttribute("ft", ft);
		
		request.getRequestDispatcher("productdetails.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
