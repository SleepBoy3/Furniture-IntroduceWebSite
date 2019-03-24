package com.ysd.dao;

import java.util.List;

import com.ysd.entity.ProductClass;

public interface ProductClassDao {
	List<ProductClass> getAllProductClassTopSi();//前台获取前四个产品分类
	
	
	List<ProductClass> getAllProductClass();//后台获取所有产品分类
	ProductClass getProductClassById(int id);//后台修改的辅助方法，根据id获取该条数据
	int deleteById(int id);//后台删除
	int AddProductClass(ProductClass cpl);//后台查询全部数据
	int UpdateProductClass(ProductClass cpl);//后台修改
}
