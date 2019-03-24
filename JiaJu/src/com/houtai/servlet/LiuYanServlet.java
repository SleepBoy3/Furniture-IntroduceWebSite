package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.LiuYanDaoImpl;
import com.ysd.dao.impl.SheJiShiDaoImpl;
import com.ysd.entity.Liuyan;
import com.ysd.entity.SheJiShi;
import com.ysd.util.Result;




public class LiuYanServlet extends BaseServlet {
	/*
	 * 后台查寻留言所有
	 * */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		List<Liuyan> ly=new LiuYanDaoImpl().getAllLiuYan();
		request.setAttribute("ly", ly);
		
		request.getRequestDispatcher("/manae/LiuYan.jsp").forward(request, response);
	}
	/*
	 * 后台根据id删除
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");//获取到LiuYan.jsp页面中的id;
		int i=new LiuYanDaoImpl().DeleteById(Integer.parseInt(id));//int类型接收一个新的实现类中的一个方法赋给一个变量i;
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.print(Result.toClient(false,"删除失败！"));
		}
	}

	/*
	 *后台 根据id搜索出回复信息
	 * */
	public void HuiFu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();//向JSP页面输出结果
			String id=request.getParameter("id");//获取到LiuYan.jsp页面中的id;
			Liuyan hf=new LiuYanDaoImpl().LiuYanHF(Integer.parseInt(id));		
			request.setAttribute("hf", hf);//声明键和值;
			request.getRequestDispatcher("/manae/LiuYanHF.jsp").forward(request, response);	//转发到LiuYanHF.jsp中
	}

	/*
	 *后台 进行回复
	 * */
	public void hfly(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("id");//获取到LiuYanHF.jsp页面中的id;
		String lynr=request.getParameter("lynr");//获取到LiuYanHF.jsp页面中的用户修改好的留言内容;
		Liuyan sc=new Liuyan(Integer.parseInt(id), null, null, null, null, null, lynr, null);//实例化一个对象，把LiuYanHF.jsp页面中的用户修改好的值赋给变量sc
		int i=new LiuYanDaoImpl().UpdateLiuYanHF(sc);//int类型接收一条，实现类中的一个方法，并把用户修改好的变量放进去，赋给一个新的变量i;
		if(i>0){
			out.print(Result.toClient(true, "回复成功！"));
		}else{
			out.print(Result.toClient(true, "回复失败！"));
		}		
	}
	
	/*
	 *后台根据用户名搜索该给条数据
	 * */
	public void SouSuo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");//获取到LiuYanHF.jsp页面input的值
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<Liuyan> qb=new  LiuYanDaoImpl().getAllLiuYan();//实例化一个显示所有的对象
		List<Liuyan>  a =new ArrayList<Liuyan>();//实例化一个新的数组
			if(name!=null){
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getName().contains(name)){//如果用户输入的用户名含有留言用户的名字，
						a.add(qb.get(i));//追加到新数组中
					}else{
						if(i==qb.size()){//为了用户输出后没查到就报错,查不到数据让其显示全部的留言用户以及信息;
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("ly", a);//显示查到的数据
				}
			}
			request.getRequestDispatcher("/manae/LiuYan.jsp").forward(request, response);
	}
	
	/*
	 * 后台查询出未回复
	 * */
	public void WeiHF(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Liuyan> qb=new  LiuYanDaoImpl().getAllLiuYan();//实例化一个输出所有的对象
		List<Liuyan>  a =new ArrayList<Liuyan>();//实例化一个新的数组
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getZhuangTai().equals("未回复")){//如果状态字段显示未回复
						a.add(qb.get(i));//追加到新数组中
					}else{
						if(i==qb.size()){
							break;
						}else{
							continue;
						}
					}
				}
				request.setAttribute("ly", a);//显示查到的数据
			request.getRequestDispatcher("/manae/LiuYan.jsp").forward(request, response);
	}
	
	/*
	 * 后台查询以回复
	 * */
	public void YiHF(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Liuyan> qb=new  LiuYanDaoImpl().getAllLiuYan();
		List<Liuyan>  a =new ArrayList<Liuyan>();
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getZhuangTai().equals("已回复")){//如果状态字段显示以回复
						a.add(qb.get(i));//追加到新数组中
					}else{
						if(i==qb.size()){
							break;
						}else{
							continue;
						}
					}
				}
				request.setAttribute("ly", a);
			request.getRequestDispatcher("/manae/LiuYan.jsp").forward(request, response);
	}
	
	/*批量删除
	 * 
	 */
	public void piLiang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //向JSP页面输出结果
		request.setCharacterEncoding("UTF-8");
		String[] pl=request.getParameterValues("pl");
		int x=0;
		if(pl!=null){
			for(int i=0;i<pl.length;i++){
				x=new LiuYanDaoImpl().PlDelete(Integer.parseInt(pl[i]));
			}
			if(x>0){
				out.print(Result.toClient(true,"删除成功！"));
			}else{
				out.print(Result.toClient(false,"删除失败！"));
			}	
		}
	}
}
