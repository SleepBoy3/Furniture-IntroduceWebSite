package com.ysd.dao;

import java.util.List;

import com.ysd.entity.HNews;
import com.ysd.entity.News;

public interface NewsDao {
	//前台用到的方法
	List<News> getAllNews();//查询出全部新闻
	List<News> getTouTiao();//精选
	News getNewsById(int id);//前后台根据id查询出一条数据
	List<News> getNewsByName(String name);//根据新闻名查询出一条数据
	
	
	//后台用到的方法
	int DeleteNewsById(int id);//删除
	int AddNews(News xw);//添加
	int UpdateNews(HNews xw);//修改
	List<HNews> getAllHNews();
	int PlDelete(int id);//后台批量删除
}
