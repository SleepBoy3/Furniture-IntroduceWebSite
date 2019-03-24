package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.entity.HProduct;
import com.ysd.entity.Images;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;
import com.ysd.util.Result;



public class ImagesServlet extends BaseServlet {
	/*
	 * 后台查出所有产品为下拉框服务
	 */
	public void XiaLa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		
		List<HProduct> cp=new ProductDaoImpl().HAllProduct();//获得产品的所有名
		request.setAttribute("cp", cp);
		request.getRequestDispatcher("manae/AddImages.jsp").forward(request, response);
	}
	/*
	 * 后台获取全部图片
	 */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<Images> Imglist=new ImagesDaoImpl().getAll();//调用接口里的方法
		request.setAttribute("Imglist", Imglist);//存值
		request.getRequestDispatcher("/manae/Images.jsp").forward(request, response);//转发
	}
	/*
	 * 后台删除
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");
		int i=new ImagesDaoImpl().DeleteById(Integer.parseInt(id));//根据id删除这条数据
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.print(Result.toClient(false, "删除失败！"));
		}
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
	
			String imagesId=request.getParameter("ImagesProductId");
			int ImagesProductId=Integer.valueOf(imagesId);
			String ImagesHot=request.getParameter("ImagesHot");
			String click=request.getParameter("click");
			
			imgUrl="images/"+tp;//变为可在页面上显示的路径
			Images img=new Images(0,ImagesProductId,imgUrl,click, ImagesHot);
			ImagesDaoImpl a=new ImagesDaoImpl();
			int i=a.AddImages(img);
			
			if(i>0){
				out.print(Result.toClient(true,"添加成功！"));
			}else{
				out.print(Result.toClient(false,"添加失败！"));
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
					x=new ImagesDaoImpl().PlDelete(Integer.parseInt(pl[i]));
				}
				if(x>0){
					out.print(Result.toClient(true,"删除成功！"));
				}else{
					out.print(Result.toClient(false,"删除失败！"));
				}	
				
			}
		}
	
	
}

