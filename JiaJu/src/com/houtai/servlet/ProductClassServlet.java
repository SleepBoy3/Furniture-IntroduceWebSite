package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.entity.ProductClass;
import com.ysd.util.Result;



public class ProductClassServlet extends BaseServlet {
	/*
	 * 后台修改用到的辅助方法
	 */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		String id=request .getParameter("id");
		ProductClass cpl=new ProductClassDaoImpl().getProductClassById(Integer.parseInt(id));//根据id查出这条数据
		request.setAttribute("cpl", cpl);
		request.getRequestDispatcher("manae/UpdateProductClass.jsp").forward(request, response);
	}
	
	/*
	 * 后台查询所有 
	 */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<ProductClass> list=new ProductClassDaoImpl().getAllProductClass();//查询出全部的产品类
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/manae/productClass.jsp").forward(request, response);//转发到jsp产品类页面
	}
	
	/*
	 * 后台删除 
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String ProductClassId=request.getParameter("id");
		int id=Integer.valueOf(ProductClassId);
		int i=new ProductClassDaoImpl().deleteById(id);//根据id删除这条数据
		
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.println(Result.toClient(true, "删除失败！"));
		}
		
	}
	
	/*
	 *后台添加
	 */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		
		String productClassName=request.getParameter("productClassName");
		ProductClass cpl=new ProductClass(0, productClassName,null);
		ProductClassDaoImpl a=new ProductClassDaoImpl();
		int i=a.AddProductClass(cpl);
		if(i>0){
			
			out.print(Result.toClient(true,"添加成功！"));
		}else{
			out.print(Result.toClient(false,"添加失败！"));
		}	
	}
	
	/*
	 *后台修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");
		String  productClassName=request.getParameter("productClassName");
		ProductClass sc=new ProductClass(Integer.parseInt(id), productClassName, null);//根据id查出这条数据
		int i=new ProductClassDaoImpl().UpdateProductClass(sc);
		if(i>0){
			out.print(Result.toClient(true, "修改成功！"));
			
		}else{
			out.print(Result.toClient(false, "修改失败！"));
			
		}

	}
	
	/*
	 *后台搜索
	 * qb：全部产品类
	 * a：新泛型数组
	 */
	public void SouSuo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<ProductClass> qb=new  ProductClassDaoImpl().getAllProductClass();
		List<ProductClass>  a =new ArrayList<ProductClass>();
			if(name!=null){
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getName().contains(name)){//如果模糊查询到了就放入新的泛型数组
						a.add(qb.get(i));
					}else{
						if(i==qb.size()){//如果数组循环完毕就跳出循环
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("list", a);
				}
			}
			request.getRequestDispatcher("/manae/productClass.jsp").forward(request, response);
	}

	
}
