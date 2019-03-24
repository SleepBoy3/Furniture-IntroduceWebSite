package com.ysd.dao;

import java.util.List;


import com.ysd.entity.HProduct;
import com.ysd.entity.ProductClass;
import com.ysd.entity.product;

public interface ProductDao {
	List<product> getAllproductByZhuTu();//前台首页精选产品
	List<product> getAllproductByClassName(String name);//前台根据名字查询对应产品分类的产品
	product getproductById(Integer id);//前台根据id查询
	/*List<product> getAllproduct();//获取前台全部产品	*/	
	
	
	List<product> getZhuTu();//前台产品展示出现的主图
	List<product> getFuTu(String id);//前台产品信息里的图片列
	
	
	
	/*List<product> getHAllProduct();//在后台显示所有关于产品有关的字段*/	
	int deleteById(int id);//后台根据id删除
	HProduct ProductById(int id);//后台查询的辅助方法，根据id获得该条数据
	int UpdateProduct(HProduct cp);//后台修改
	int AddProduct(product cp);//后台添加
	List<HProduct> HAllProduct();//后台获取全部商品
	int PlDelete(int id);//批量删除
	
}
