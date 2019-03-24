package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.LiuYanDaoImpl;
import com.ysd.dao.impl.LoginDaoImpl;
import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.entity.Admin;
import com.ysd.entity.HProduct;
import com.ysd.entity.Liuyan;
import com.ysd.entity.News;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;
import com.ysd.util.Result;

public class LoginServlet extends BaseServlet {
	/*
	 * 登录
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		Admin admin=new LoginDaoImpl().get(name, pass);
		if(admin.getName().equals(name)&&admin.getPass().equals(pass)){
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("pass", pass);
			out.print(Result.toClient(true, "登陆成功！"));
			
		}else{
			if(!name.equals(admin.getName())){
				out.print(Result.toClient(false, "用户名输入错误"));
			}else{
				out.print(Result.toClient(false, "密码输入错误"));		
			}
		}
	}
	/*
	 * 查询所有
	 */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<Admin> list=new LoginDaoImpl().getAll();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/manae/Admin.jsp").forward(request, response);
	}
	
	/*添加
	 * 
	 */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String username=request.getParameter("username");
		String password=request.getParameter("password");		
		String qrPass=request.getParameter("qrPass");
		if(password.equals(qrPass)){//密码和确认密码一致
			Admin ad=new Admin(0,username,password);		
			int i=new LoginDaoImpl().AddAdmin(ad);
			if(i>0){
				//out.print(Result.toClient(true, "添加成功！"));
			}else{
				out.print(Result.toClient(false, "添加失败！"));
		}
		}else{
			//out.print(Result.toClient(false, "密码不一致！"));
		}
	}

	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		String id=request.getParameter("id");
		Admin ad=new LoginDaoImpl().getAllAdmin(Integer.parseInt(id));
		
		request.setAttribute("ad",ad);
		
		request.getRequestDispatcher("/manae/UpdateAdmin.jsp").forward(request, response);
	}
	/*
	 * 修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)//改
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String Id=request.getParameter("id");
		int id=Integer.valueOf(Id);
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		Admin cp=new Admin(id, username, password);
		int i=new LoginDaoImpl().UpdateAdmin(cp);
		
		if(i>0){
			out.print(Result.toClient(true, "修改成功！"));
		}else{
			out.print(Result.toClient(false, "修改失败！"));
		}
	}
	/*
	 * 删除
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)//删
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		
		int i=new LoginDaoImpl().deleteById(Integer.parseInt(id));	
		System.out.println(i);
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.println(Result.toClient(true, "删除失败！"));
		}
	}
	/*
	 * 查询
	 */
	public void chaxun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		username=new String (username.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<Admin> qb=new LoginDaoImpl().getAll();
		List<Admin> a =new ArrayList<Admin>();//新数组
			if(username!=null){
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getName().contains(username)){
						a.add(qb.get(i));
					}else{
						if(i==qb.size()){
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("list", a);
				}
			}
			request.getRequestDispatcher("/manae/Admin.jsp").forward(request, response);

	}
	/*批量删除
	 * 
	 */
	public void piLiang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //向JSP页面输出结果
		request.setCharacterEncoding("UTF-8");//设置编码格式
		String[] pl=request.getParameterValues("pl");
		int x=0;
		if(pl!=null){
			for(int i=0;i<pl.length;i++){
				x=new LoginDaoImpl().PlDelete(Integer.parseInt(pl[i]));
			}
			if(x>0){
				out.print(Result.toClient(true,"删除成功！"));
			}else{
				out.print(Result.toClient(false,"删除失败！"));
			}	
			System.out.println(x);
		}
	}
}
