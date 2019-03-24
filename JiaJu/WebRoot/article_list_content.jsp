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

<div>
  
    <header class="header-article-list">
  
        <div class="article-position">
        <%News sxw=(News)request.getAttribute("sxw"); //接收ser传过来的值
        	if(sxw!=null){
        %>
          <a  href="NewsInfoSer?id=<%=sxw.getNewsId()%>">
              <span>上一篇</span>
              <span><%=sxw.getTitle() %></span>
          </a>
          <%}else{ %>
          
       		 <span>上一篇</span>
              <span>已经么上一篇了</span>
        <%} %>
        </div> 
        
         <ul>
           <% 
    		List<NewsClass> newsClass=(List<NewsClass>)request.getAttribute("lei");//接收ser传过来的值
    		
    			if(newsClass!=null){ 
    			for(int i=0;i<newsClass.size();i++){ %>
            <li><a href="NewsClassSer?name=<%=newsClass.get(i).getNewsClassName()%>"><%=newsClass.get(i).getNewsClassName() %></a></li>
            	<%} }%>
        </ul>
       <div class="article-more-btn">
         <%News xxw=(News)request.getAttribute("xxw"); 
        	if(xxw!=null){
        %>
            <a href="NewsInfoSer?id=<%=xxw.getNewsId()%>">
                <span>下一篇</span>
                <span><%=xxw.getTitle() %></span>
            </a>
            <%}else{
         %>
       		 <span>下一篇</span>
                <span>没有了</span>
         <%} %>
        </div> 
        
    </header>

    <section class="article-content">
    	<%
    		News news=(News)request.getAttribute("news");//接收ser传过来的值
    			if(news!=null){
       	 %>
            <h4><%=news.getTitle() %></h4>
        <main>
            <p><%=news.getInfo() %></p>
				<%} %>
        </main>
    </section>
    
</div>
<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>
</html>