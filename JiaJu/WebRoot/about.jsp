<%@ page language="java" import="java.util.*,com.ysd.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>某某家具设计公司企业官网-模板之家</title>
    ﻿<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="images/favicon.png">
<link rel='icon' href='favicon.ico' type='image/x-ico' />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/default.min.css?t=227" />
<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript" src="lib/jquery/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="lib/amazeui/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script type="text/javascript" src="lib/handlebars/handlebars.min.js"></script>
<script type="text/javascript" src="lib/iscroll/iscroll-probe.js"></script>
<script type="text/javascript" src="lib/amazeui/amazeui.min.js"></script>
<script type="text/javascript" src="lib/raty/jquery.raty.js"></script>
<script type="text/javascript" src="js/main.min.js?t=1"></script>
</head>
<body>
<jsp:include page="/HeadSer"></jsp:include><!-- 引入页眉 -->

<section class="about-section">
	<%
		List<gongSiInfo> list1=(List<gongSiInfo>)request.getAttribute("gsjs");//前台获取公司信息 
			if(list1!=null){
	%>
    <div>
        <span>
            <article><%=list1.get(1).getTitle() %></article>
            <h6>COMPANY INTRODUCTION</h6>
        </span>
        <span></span>
    </div>
    <div></div>
    <div class="about-content">
        <div class="about-image"> <img src="./images/banner3.jpg" alt=""></div>

        <article><p><%=list1.get(1).getInfo() %></p>
            	 <p><%=list1.get(1).getInfo() %></p>
        </article>


    </div>

    <div class="about-box">
        <div class="about-leftbox">
            <img src="<%=list1.get(0).getUrl() %>" alt="">
        </div>
        <div class="about-rightbox">
            <h1><%=list1.get(0).getTitle() %></h1>
            <p>CORPORATE CULTURE</p>
            <article><%=list1.get(0).getInfo() %></article>
        </div>
    </div>
 		<%} %>
    <div class="about-team">
   
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <p>第四组</p>
            <span style="padding-left:10px;">Group Four</span>
        </div>
        <div class="about-team-headimg">
         <%
    	List<SheJiShi> list2=(List<SheJiShi>)request.getAttribute("sjs");
    		if(list2!=null){
    		for(int i=0;i<list2.size();i++){
     %>
        <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
            <img src="<%=list2.get(i).getTuPian() %>" alt="">
            <p><%=list2.get(i).getName() %></p>
            <span><%=list2.get(i).getInfo()%></span>
        </div>
       <%} }%>
        </div>
        <div class="about-slogan">
            <div>
            <p></p>
            </div>
        </div>
        
    </div>
   
</section>

<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>
</html>