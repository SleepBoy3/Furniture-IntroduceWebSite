package com.ysd.dao;

import java.util.List;

import com.ysd.entity.Images;
import com.ysd.entity.ProductClass;

public interface ImagesDao {
	List<Images> getAllLunBoImages();//前台头部轮播
	
	List<Images> getAll();//后台全部图片
	int DeleteById(int id);//后台根据id删除
	int AddImages(Images i);//后台添加图片
	int PlDelete(int id);//后台批量删除
}