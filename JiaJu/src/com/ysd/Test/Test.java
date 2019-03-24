package com.ysd.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ysd.dao.impl.ImagesDaoImpl;
import com.ysd.dao.impl.LiuYanDaoImpl;
import com.ysd.dao.impl.LoginDaoImpl;
import com.ysd.dao.impl.NewsClassDaoImpl;
import com.ysd.dao.impl.NewsDaoImpl;
import com.ysd.dao.impl.ProductClassDaoImpl;
import com.ysd.dao.impl.ProductDaoImpl;
import com.ysd.dao.impl.SheJiShiDaoImpl;
import com.ysd.dao.impl.gongSiInfoDaoImpl;
import com.ysd.entity.Images;
import com.ysd.entity.Liuyan;

import com.ysd.entity.Admin;
import com.ysd.entity.HNews;
import com.ysd.entity.News;
import com.ysd.entity.NewsClass;
import com.ysd.entity.ProductClass;
import com.ysd.entity.SheJiShi;
import com.ysd.entity.gongSiInfo;
import com.ysd.entity.product;
import com.ysd.util.DBManager;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Admin admin=new LoginDaoImpl().get("aaa","aaa");
		System.out.println(admin);
		}
	}
	

