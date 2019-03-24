package com.ysd.dao;
import java.util.List;
import com.ysd.entity.SheJiShi;
public interface SheJiShiDao {
	List<SheJiShi> getSheJiShiTopSi();//前台设计师

	//后台
	List<SheJiShi> getAllSheJiShi();//查询全部设计师
	SheJiShi SheJiShiById(int id);//根据id查询;
	int DeleteById(int id);//后台根据id删除
	int AddSheJiShi(SheJiShi sjs);//后台添加
	int updateSheJiShi(SheJiShi  sjs);//修改
	int PlDelete(int id);//后台批量删除
	
}

