<%@page import="com.ysd.entity.Images"%>
<%@ page language="java" import="java.util.*,com.ysd.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'head.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  <body>
    <header>
    <div class="header-top">
        <div class="width-center">
            <div class="header-logo "><img src="images/logo.png" alt=""></div>
            <div class="header-title div-inline">
                <strong>家具设计公司</strong>
                <span>www.sixsixsix.com</span>
            </div>
        </div>
    </div>
    <div class="header-nav">
        <button class="am-show-sm-only am-collapsed font f-btn" data-am-collapse="{target: '.header-nav'}">Menu <i
                class="am-icon-bars"></i></button>
        <nav>
        <ul class="header-nav-ul am-collapse am-in">
            <li class="on"><a href="IndexSer" name="index">首页</a></li>
            <li><a href="AboutSer" name="about">关于我们</a></li>
            <li><a href="ProductClassSer?name=椅子系列" name="show">产品展示</a></li>
            <li><a href="NewsClassSer?name=行业新闻" name="new">新闻资讯</a></li>
            <li><a href="ContactSer" name="message">联系我们</a>
           
           
                <div class="secondary-menu">
                    <ul><li><a href="message.jsp" class="message"></a></li></ul>
                </div>
            </li>
            <li id="ht"><a href="/JiaJu/manae/index.jsp" >前往后台</a> 
        </ul>
        </nav>
    </div>

</header>
<div class="am-slider am-slider-default" data-am-flexslider="{playAfterPaused: 8000}">
    <ul class="am-slides">
    <%
    	List<Images> list=(List<Images>)request.getAttribute("lb");//前台获取轮播图
    		if(list!=null){
    		for(int i=0;i<list.size();i++){
     %>
       
        <li><a href="AboutSer"><img src="<%=list.get(0).getUrl() %>" alt="" ></a></li>
        <li><a href="AboutSer"><img src="<%=list.get(1).getUrl() %>" alt="" ></a></li>
        
        <%}} %>
    </ul>
</div>>
  </body>
</html>
