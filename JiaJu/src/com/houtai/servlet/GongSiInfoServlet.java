package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.SheJiShiDaoImpl;
import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.ProductClass;
import com.ysd.entity.SheJiShi;
import com.ysd.entity.gongSiInfo;
import com.ysd.util.Result;



/*
 * 后台获取全部公司信息
 */
public class GongSiInfoServlet extends BaseServlet {
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<gongSiInfo> info=new gongSiInfoDaoImpl().getGongSiInfoH();//获取全部公司信息
		request.setAttribute("info", info);
		request.getRequestDispatcher("/manae/GongSiInfo.jsp").forward(request, response);
	}
	/*public void delete(HttpServletRequest request, HttpServletResponse response)//删除
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		int i=new gongSiInfoDaoImpl().DeleteById(Integer.parseInt(id));
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.print(Result.toClient(false,"删除失败！"));
		}
	}*/
	/*
	 * 修改的辅助方法，根据id查询
	 */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		String id=request.getParameter("id");
		gongSiInfo gsxx=new gongSiInfoDaoImpl().gongSiInfoByid(Integer.parseInt(id));//根据id查询出这条数据
		System.out.println(gsxx);
		request.setAttribute("gsxx",gsxx);
		request.getRequestDispatcher("/manae/UpdateGongSiInfo.jsp").forward(request, response);
	}
	/*
	 * 后台添加
	 */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String imgUrl=null;
		String tp=request.getParameter("tp");
		String title=request.getParameter("title");
		String info=request.getParameter("info");
		String telephone=request.getParameter("telephone");
		String zsTelephone=request.getParameter("zsTelephone");
		String email=request.getParameter("email");
		String diZhi=request.getParameter("diZhi");
		imgUrl="images/"+tp;//变为可在页面上显示的路径
		gongSiInfo xx=new gongSiInfo(0, imgUrl, title, info, telephone, zsTelephone, email, diZhi);
		int i=new gongSiInfoDaoImpl().AddgongSiInfo(xx);
			if(i>0){
				out.print(Result.toClient(true,"添加成功！"));
			}else{
				out.print(Result.toClient(false,"添加失败！"));
			}
	}
	/*
	 * 后台修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置输出内容的编码格式
		request.setCharacterEncoding("UTF-8");//设置编码格式
		response.setContentType("text/html");//设置输出的类型；
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String imgUrl=null;
		int i=0;
		String tp=request.getParameter("tp");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String info=request.getParameter("info");
		String telephone=request.getParameter("telephone");
		String zsTelephone=request.getParameter("zsTelephone");
		String email=request.getParameter("email");
		String diZhi=request.getParameter("diZhi");
		imgUrl="images/"+tp;//变为可在页面上显示的路径
		if(!tp.equals("undefined")){//如果图片路径不为空进这里						
			gongSiInfo gsxx=new gongSiInfo(Integer.parseInt(id), imgUrl, title, info, telephone, zsTelephone, email, diZhi);
			 i=new gongSiInfoDaoImpl().UpdateGongSiInfo(gsxx);
		}
		else {//如果图片路径为空进这里
			gongSiInfo gsxx=new gongSiInfoDaoImpl().gongSiInfoByid(Integer.parseInt(id));//根据id查询这条数据
			gongSiInfo gsxx1=new gongSiInfo(Integer.parseInt(id), gsxx.getUrl(), title, info, telephone, zsTelephone, email, diZhi);
			 i=new gongSiInfoDaoImpl().UpdateGongSiInfo(gsxx1);
		}
		if(i>0){
			out.print(Result.toClient(true,"修改成功！"));
		}else{
			out.print(Result.toClient(false,"修改失败！"));
		}
	}
	/*
	 * 后台上传图片的时候将图片放入指定的文件夹
	 */
	public void SaveImages(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();//向JSP页面输出结果             
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
	    		
	/*
	 * 后台搜索
	 */
	public void chaxun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<gongSiInfo> qb=new  gongSiInfoDaoImpl().getGongSiInfoH();//获取全部
		List<gongSiInfo>  a =new ArrayList<gongSiInfo>();//新的泛型数组
			if(name!=null){//如果不为空进这里
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getTitle().contains(name)){//如果模糊查询到了就放入新的泛型数组
						a.add(qb.get(i));
					}else{
						if(i==qb.size()){//当数组循环完毕时跳出
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("info", a);
				}
			}
			request.getRequestDispatcher("/manae/GongSiInfo.jsp").forward(request, response);
	}


	}

