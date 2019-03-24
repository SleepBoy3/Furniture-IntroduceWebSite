package com.ysd.dao;

import java.util.List;

import com.ysd.entity.gongSiInfo;

public interface gongSiInfoDao {
	List<gongSiInfo> getAllGongSiInfo();//前台关于我们获取公司信息
	gongSiInfo getGongSiInfo();//前台首页，脚部，联系我们公司介绍
	
	
	List<gongSiInfo> getGongSiInfoH();//后台获取全部公司信息
	/*int DeleteById(int id);//后台根据id删除*/	
	int AddgongSiInfo(gongSiInfo  gsxw);//后台添加
	gongSiInfo gongSiInfoByid(int id);//后台修改的辅助方法
	int UpdateGongSiInfo(gongSiInfo gsxx);//后台修改
}
