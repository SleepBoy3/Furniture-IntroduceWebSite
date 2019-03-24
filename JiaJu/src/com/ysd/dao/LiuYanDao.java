package com.ysd.dao;

import java.util.List;

import com.ysd.entity.Images;
import com.ysd.entity.Liuyan;
public interface LiuYanDao {
	int setLiuYan(Liuyan ly);//前台获取留言

	List<Liuyan> getAllLiuYan();//后台获取全部留言
	int DeleteById(int id);//后台根据id删除
	Liuyan LiuYanHF(int id);//根据id搜索;
	int UpdateLiuYanHF(Liuyan ly);//修改留言回复
	int PlDelete(int id);//后台批量删除
}




