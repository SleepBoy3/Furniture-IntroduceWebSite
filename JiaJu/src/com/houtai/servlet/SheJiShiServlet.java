package com.houtai.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.SheJiShiDaoImpl;
import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.SheJiShi;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.Result;

public class SheJiShiServlet extends BaseServlet {

	/**
	 * 后台查寻所有
	 * */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式

		List<SheJiShi> sjs=new SheJiShiDaoImpl().getAllSheJiShi();
		request.setAttribute("sjs", sjs);
		request.getRequestDispatcher("/manae/SheJiShi.jsp").forward(request, response);
	}
	/**
	 * 后台添加
	 * */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String imgUrl=null;
		String tp=request.getParameter("tp");
		String name=request.getParameter("SheJiShiName");
		String info=request.getParameter("SheJiShiInfo");
		
		imgUrl="images/"+tp;//并把得到的图片名字拼接到项目中
		SheJiShi sjs=new SheJiShi(0, imgUrl, name, info);
		int i=new SheJiShiDaoImpl().AddSheJiShi(sjs);
		if(i>0){
			out.print(Result.toClient(true,"添加成功！"));
		}else{
			out.print(Result.toClient(false,"添加失败！"));
		}	
			
}
	
	/**
	 * 后台根据id删除
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		
		String id=request.getParameter("id");
		int i=new SheJiShiDaoImpl().DeleteById(Integer.parseInt(id));
		if(i>0){
			//out.print(Result.toClient(true,"删除成功！"));
		}else{
			out.print(Result.toClient(false,"删除失败！"));
		}
		
	}
	
	/**
	 * 后台根据id搜索
	 * */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		String id=request.getParameter("id");
		System.out.println(Integer.parseInt(id));
		SheJiShi sjs=new SheJiShiDaoImpl().SheJiShiById(Integer.parseInt(id));
		request.setAttribute("sjs",sjs);
		request.getRequestDispatcher("/manae/UpdateSheJiShi.jsp").forward(request, response);
		
		
	}
	
	/**
	 * 后台根据搜索到后修改
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)//修改
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String imgUrl=null;
		String tp=request.getParameter("tp");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String info=request.getParameter("SheJiShiInfo");
		if(!tp.equals("undefined")){//如果图片路径不为空进这里	
			imgUrl="images/"+tp;//并把得到的图片名字拼接到项目中
			SheJiShi sjs=new SheJiShi(Integer.parseInt(id), imgUrl, name, info);
			int i=new SheJiShiDaoImpl().updateSheJiShi(sjs);				
			if(i>0){
				out.print(Result.toClient(true,"添加成功！"));
			}else{
				out.print(Result.toClient(false,"添加失败！"));
			}
		}else {//如果图片路径为空进这里
			SheJiShi sjs=new SheJiShiDaoImpl().SheJiShiById(Integer.parseInt(id));
			SheJiShi sjs1=new SheJiShi(Integer.parseInt(id), sjs.getTuPian(), name, info);
			int i=new SheJiShiDaoImpl().updateSheJiShi(sjs1);
			if(i>0){
				out.print(Result.toClient(true,"修改成功！"));
			}else{
				out.print(Result.toClient(false,"修改失败！"));
			}
		}
		
	}
	/**
	 * 后台上传图片
	 * */
	public void SaveImages(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //向JSP页面输出结果               
		SmartUpload smart=new SmartUpload();//创建smartupload
		smart.setCharset("UTF-8");//设置字符集
		smart.initialize(getServletConfig(), request, response);//初始化
		try {
			smart.upload();//上传文件
			smart.save("/images");
			smart.save("J:\\2018-6-19     完成项目\\前台模版\\JiaJu\\WebRoot\\images");//保存文件到指定位置(save只提供路径，使用原文件名上传)
			String filename=smart.getFiles().getFile(0).getFileName();
			out.print(Result.toClient(true, filename));
		} catch (SmartUploadException e) {
			out.print(Result.toClient(false, e.getMessage()));
			e.printStackTrace();
		}
	}
	
	/**
	 * 后台根据名字模糊查询
	 * */
	public void chaxun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");//获取到SheJiShi.jsp页面input的值
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<SheJiShi> qb=new SheJiShiDaoImpl().getSheJiShiTopSi();//实例化一个显示所有的对象
		List<SheJiShi>  a =new ArrayList<SheJiShi>();//实例化一个新的数组
			if(name!=null){
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getName().contains(name)){//如果用户输入的设计师名包含设计师的名字,
						a.add(qb.get(i));//追加到新数组中
					}else{
						if(i==qb.size()){//为了用户输出后没查到就报错,查不到数据让其显示全部的留言用户以及信息;
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("sjs", a);//显示查到的数据
				}
			}else{
				request.setAttribute("sjs", qb);;//没查到的数据显示全部
			}
			request.getRequestDispatcher("/manae/SheJiShi.jsp").forward(request, response);

	}
	
	/*批量删除
	 * 
	 */
	public void piLiang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();//向JSP页面输出结果 
		request.setCharacterEncoding("UTF-8");//设置编码格式
		String[] pl=request.getParameterValues("pl");
		int x=0;
		if(pl!=null){
			for(int i=0;i<pl.length;i++){
				x=new SheJiShiDaoImpl().PlDelete(Integer.parseInt(pl[i]));
			}
			if(x>0){
				out.print(Result.toClient(true,"删除成功！"));
			}else{
				out.print(Result.toClient(false,"删除失败！"));
			}	
			
		}
	}
}

