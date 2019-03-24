package com.ysd.dao;

import java.util.List;

import com.ysd.entity.Admin;
import com.ysd.entity.HProduct;
import com.ysd.entity.ProductClass;

public interface LoginDao {
	Admin get(String name,String pass);//过滤器的接口
	
	List<Admin> getAll();//获取全部并显示
	int AddAdmin(Admin ad);//添加管理员
	int UpdateAdmin(Admin ad);//修改管理员      
	Admin getAllAdmin(int id);//修改获取全部管理员
	int PlDelete(int id);//后台批量删除
	int deleteById(int id);//删除
	
}
