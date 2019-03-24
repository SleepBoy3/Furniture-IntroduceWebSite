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

<section class="index-section">
    <div>
        <span></span>
        <span></span>
    </div>
    <div class="index-content">
        <section class="index-content-section-first"><div><img src="images/sectionbanner.png" alt=""></div> </section>
        <section class="index-content-section-second">
            <div>
            <%
            	gongSiInfo c=(gongSiInfo)request.getAttribute("gsjs");//前台获取新闻介绍
                        		if(c!=null){
            %>
                <div class="index-auto">
            <article><%=c.getTitle() %></article>
            <h6>COMPANY INTRODUCTION</h6>
            <main><%=c.getInfo() %><a class="index-button" href="AboutSer" style="font-size:18px;">查看详情</a>
                </div>
             <%} %>
            </div>
        </section>
    </div>
</section>

<section class="index-product">
    <main>
        <ul>
        <%
        	List<ProductClass> fenlei=(List<ProductClass>)request.getAttribute("fenlei");
        		if(fenlei!=null){
        		for(int i=0;i<fenlei.size();i++){
         %>
            <li class="index-active"><a style="display:block;padding-top:46px;font-size:21px;" href="ProductClassSer?name=<%=fenlei.get(i).getName()%>"><%=fenlei.get(i).getName()%></a></li>
            	<%} 
            }%>
        </ul>
    </main>
    <main></main>
    <main></main>
</section>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
<section class="index-margin-bottom">
    <div class="index-morecase">
        <span></span>
        <a href="ProductAllSer">MORE &#62; &#62;</a>
    </div>
    <div class="index-content">
        <div class="product-list">
           <%
           		List<product> jx=(List<product>)request.getAttribute("jx");//前台获取精选产品
           			if(jx!=null){
           			for(int i=0;i<jx.size();i++){
            %>
          
            <div class="am-u-sm-6 am-u-md-6 am-u-lg-4">
                <a href="ProductInfoSer?id=<%=jx.get(i).getProductId()%>">
                    <img src="<%=jx.get(i).getUrl() %>" />
                </a>
            </div>
           	 <%} 
            }%>
        </div>
    </div>
</section>


<section class="index-margin-bottom">
    <div class="index-morecase">
        <span></span>
        <a href="NewsAllSer">MORE &#62; &#62;</a>
    </div>
    <div class="index-content">


        <div class="new-index">
       		 
            
             <ul>
                <li><img  src="images/productlogo.png" alt=""> </li>
                 <%
        			List<News> touTiao=(List<News>)request.getAttribute("touTiao");
        				if(touTiao!=null){
        				
        	 %>
        	  
                <li>  <a href="NewsInfoSer?id=<%=touTiao.get(0).getNewsId()%>"><h3><%=touTiao.get(0).getTitle() %></h3>
                    <article><%=touTiao.get(0).getInfo() %></article></a></li>
            </ul>
            <ul>
            <%for(int i=1;i<touTiao.size();i++){ %>
                <li><a href="NewsInfoSer?id=<%=touTiao.get(i).getNewsId()%>"><h3><%=touTiao.get(i).getTitle() %></h3>
                    <article><%=touTiao.get(i).getInfo() %>
                    </article>
                </a></li>
               
                <%}
			} %>
              
            </ul>
				
        </div>
    </div>
</section>

<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>
</html>