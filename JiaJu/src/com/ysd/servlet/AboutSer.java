package com.ysd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.SheJiShiDaoImpl;
import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.SheJiShi;
import com.ysd.entity.gongSiInfo;

public class AboutSer extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		List<gongSiInfo> gsjs=new gongSiInfoDaoImpl().getAllGongSiInfo();//前台获取公司信息
		request.setAttribute("gsjs", gsjs);
		
		List<SheJiShi> sjs=new SheJiShiDaoImpl().getSheJiShiTopSi();//前台获取设计师信息
		request.setAttribute("sjs", sjs);
		
		request.getRequestDispatcher("about.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
