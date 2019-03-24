package com.ysd.dao;

import java.util.List;

import com.ysd.entity.NewsClass;

public interface NewsClassDao {
	
	List<NewsClass> getAllNewsClass();//前后台查询全部
	
	int DelectNews(int id);//删除 
	int AddNews(NewsClass xwl);//添加
	NewsClass NewsByid(int id);//根据id查询一条数据
	int UpdateNews(NewsClass xwl);//修改
}
