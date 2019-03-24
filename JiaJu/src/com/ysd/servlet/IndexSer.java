package com.ysd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.News;
import com.ysd.entity.ProductClass;
import com.ysd.entity.gongSiInfo;
import com.ysd.entity.product;


public class IndexSer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		gongSiInfo gsjs=new gongSiInfoDaoImpl().getGongSiInfo();//前台首页获取公司介绍
		request.setAttribute("gsjs", gsjs);
		
		List<ProductClass> fenlei=new ProductClassDaoImpl().getAllProductClassTopSi();//产品类
		request.setAttribute("fenlei", fenlei);
		
		List<product> jx=new ProductDaoImpl().getAllproductByZhuTu();//前台首页精选产品
		request.setAttribute("jx", jx);
		
		List<News> touTiao=new NewsDaoImpl().getTouTiao();
		request.setAttribute("touTiao", touTiao);
		 
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

}
