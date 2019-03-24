package com.houtai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.entity.HProduct;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;
import com.ysd.util.Result;



public class ProductServlet extends BaseServlet {
	/*
	 *后台修改用到的查询
	 * lei
	 */
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		String id=request.getParameter("id");
		HProduct cp=new ProductDaoImpl().ProductById(Integer.parseInt(id));//根据id查出这条数据
		request.setAttribute("cp",cp);
		List<ProductClass> lei=new ProductClassDaoImpl().getAllProductClass();//查询出所有产品类传到后台产品进行修改用
		request.setAttribute("lei", lei);
		request.getRequestDispatcher("/manae/UpdateProduct.jsp").forward(request, response);
	}
	
	/*
	 *后台查询出添加页面的下拉框内的值
	 */
	public void XiaLa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<ProductClass> lei=new ProductClassDaoImpl().getAllProductClass();//获取全部的产品类
		request.setAttribute("lei", lei);
		request.getRequestDispatcher("/manae/AddProduct.jsp").forward(request, response);
	}
	
	/*
	 *后台查询全部
	 */
	public void All(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		List<HProduct> cp=new ProductDaoImpl().HAllProduct();//获取全部的产品
		request.setAttribute("cp",cp);
		request.getRequestDispatcher("/manae/product.jsp").forward(request, response);//转发到jsp产品类页面
	}
	
	/*
	 *后台删除 
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String ProductId=request.getParameter("id");
		System.out.println(ProductId);
		
		int i=new ProductDaoImpl().deleteById(Integer.parseInt(ProductId));//根据id查出这条数据
		System.out.println(i);
		if(i>0){
			//out.print(Result.toClient(true, "删除成功！"));
		}else{
			out.println(Result.toClient(true, "删除失败！"));
		}
	}
	
	/*
	 *后台修改 
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String Id=request.getParameter("id");
		int productId=Integer.valueOf(Id);
		
		String productClassId=request.getParameter("productClassId");	
		int id=Integer.valueOf(productClassId);
		
		String productName=request.getParameter("productName");
	
		String caiZhi=request.getParameter("productCaiZhi");
		
		String brand=request.getParameter("productBrand");
		
		String Yprice=request.getParameter("Yprice");
		int yj=Integer.valueOf(Yprice);
		
		String Xprice=request.getParameter("Xprice");
		int xj=Integer.valueOf(Xprice);
		
		String color=request.getParameter("color");
		
		String size=request.getParameter("size");
		
		String style=request.getParameter("style");
		
		String GPS=request.getParameter("GPS");
		
		String dingZhi=request.getParameter("dingZhi");
		
		String zuZhuang=request.getParameter("zuZhuang");
		
		String sheJi=request.getParameter("sheJi");
		
		HProduct cp=new HProduct(productId, id, productName, caiZhi, yj, xj, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, null);
		int i=new ProductDaoImpl().UpdateProduct(cp);
		
		if(i>0){
			out.print(Result.toClient(true, "修改成功！"));
		}else{
			out.print(Result.toClient(false, "修改失败！"));
		}
	}
	
	/*
	 *后台添加 
	 */
	public void Add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");//设置编码格式
		PrintWriter out=response.getWriter();//向JSP页面输出结果
		String id=request.getParameter("fid");
		int productClassId=Integer.parseInt(id);
		String productName=request.getParameter("productName");
		String caiZhi=request.getParameter("caiZhi");	
		String brand=request.getParameter("brand");	
		String Yprice=request.getParameter("Yprice");
		int yj=Integer.valueOf(Yprice);
		String Xprice=request.getParameter("Xprice");
		int xj=Integer.valueOf(Xprice);		
		String color=request.getParameter("color");		
		String size=request.getParameter("size");		
		String style=request.getParameter("style");		
		String GPS=request.getParameter("GPS");		
		String dingZhi=request.getParameter("dingZhi");	
		String zuZhuang=request.getParameter("zuZhuang");
		String sheJi=request.getParameter("sheJi");		
		String click=request.getParameter("click");		
		product p=new product(productClassId, null, null, 0, productName, caiZhi, yj, xj, brand, size, style, color, GPS, dingZhi, zuZhuang, sheJi, null, 0, null, null,click);		
		int i=new ProductDaoImpl().AddProduct(p);
		if(i>0){
			out.print(Result.toClient(true, "添加成功！"));
		}else{
			out.print(Result.toClient(false, "添加失败！"));
		}
	}
	
	/*
	 * 后台搜索
	 * qb：全部产品
	 * a：新泛型数组
	 */
	public void SouSuo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		name=new String (name.getBytes("ISO-8859-1"),"UTF-8");//转中文（避免乱码）
		List<HProduct> qb=new  ProductDaoImpl().HAllProduct();
		List<HProduct>  a =new ArrayList<HProduct>();
			if(name!=null){
				for(int i=0;i<qb.size();i++){
					if(qb.get(i).getProductName().contains(name)){//如果模糊查询到了就放入新的泛型数组
						a.add(qb.get(i));
					}else{
						if(i==qb.size()){//如果数组循环完毕就跳出循环
							break;
						}else{
							continue;
						}
					}
					request.setAttribute("cp", a);
				}
			}else{
				request.setAttribute("cp", qb);
			}
			request.getRequestDispatcher("/manae/product.jsp").forward(request, response);
	}
	/*批量删除
	 * 
	 */
	public void piLiang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();//向JSP页面输出结果 
		request.setCharacterEncoding("UTF-8");
		String[] pl=request.getParameterValues("pl");
		int x=0;
		if(pl!=null){
			for(int i=0;i<pl.length;i++){
				x=new ProductDaoImpl().PlDelete(Integer.parseInt(pl[i]));
			}
			if(x>0){
				out.print(Result.toClient(true,"删除成功！"));
			}else{
				out.print(Result.toClient(false,"删除失败！"));
			}	
			
		}
	}
	
}
