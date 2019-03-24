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
<section class="pro-list">
	
   <aside class="pro-leftsidebar">
        <ul>
            <li>
                <a>产品搜索</a>
                <ul id="pro-search">
                    <li><a><input type="text"  class="pro-search"><a class="pro-search-btn">搜索</a></a></li>
                </ul>
            </li>
            <li>
                <a>产品分类</a>
                <ul id="pro-category">
                <%
        	List<ProductClass> fenlei=(List<ProductClass>)request.getAttribute("fenlei");
        		if(fenlei!=null){
        		for(int i=0;i<fenlei.size();i++){
         %>
                    <li class="on"><a href="ProductClassSer?name=<%=fenlei.get(i).getName() %>"><%=fenlei.get(i).getName() %></a></li>
                   
                   	<%} 
            }%>
                </ul>
            </li>
        </ul>
    </aside>
<%
		product list1=(product)request.getAttribute("cpinfo");//前台获取到对应id的产品信息
			if(list1!=null){
			
	 %>
    <aside class="pro-rightsidebar">
        <header>
            <p></p>
            <span><%=list1.getProductClassName() %></span>
            <div class="product-nav"><a href="IndexSer">首页 </a>&#62;<a href="ProductAllSer">产品展示</a>&#62;<a href="ProductAllSer">椅子</a></div>
        </header>
        <main>
            <div class="pro-right-left">
                <div class="pro-details-img"><img src="<%=list1.getUrl()%>"></div>
				
                <div class="pro-detalis-carousel">
                    <div class="am-slider am-slider-default am-slider-carousel" data-am-flexslider="{itemWidth: 112, itemMargin: 4,move:5,  controlNav: false ,  slideshow: true}">
                        <ul class="am-slides pro-details">
                        <%List<product> list2=(List<product>) request.getAttribute("ft");//前台根据id获取对应的产品信息以显示图片
                		  if(list2!=null){
                		  for(int i=0;i<list2.size();i++){
                		  if(list2.get(i).getZhuTu().equals("是")||list2.get(i).getZhuTu().equals("否")){
                 		%>
                            <li><img src="<%=list2.get(i).getUrl() %>" /></li>
                           <%}}} %>
                        </ul>
                    </div>
                </div>
				
            </div>
            <div class="pro-right-right">
                <ul class="pro-right-info-constant">
                    <li>产品名称:</li>
                    <li>产品材质:</li>
                    <li>产品售价:</li>
                    <li>市场价:</li>
                </ul>
                <ul class="pro-right-info-variable">
                    <li><%=list1.getProductName() %></li>
                    <li><%=list1.getCaiZhi() %></li>
                    <li>$<%=list1.getYprice() %></li>
                    <li>$<%=list1.getXprice() %></li>
                </ul>
            </div>

            <div class="am-tabs pro-tabs" data-am-tabs>
                <ul class="am-tabs-nav am-nav am-nav-tabs">
                    <li class="am-active"><a href="#tab1">详细说明1</a></li>
                  
                </ul>

                <div class="am-tabs-bd">
                    <div class="am-tab-panel am-active" id="tab1">
                        <ul>
                            <li>
                                <span class="pro-tabs-constant">品牌:</span>
                                <span class="pro-tabs-variable"><%=list1.getBrand() %></span>
                            </li>
                            <li>
                                <span class="pro-tabs-constant">是否组装:</span>
                                <span class="pro-tabs-variable"><%=list1.getZuZhuang() %></span>
                            </li>
                            <li>
                                <span class="pro-tabs-constant">是否可定制:</span>
                                <span class="pro-tabs-variable"><%=list1.getDingZhi() %></span>
                            </li>
                            <li>
                                <span class="pro-tabs-constant">型号:</span>
                                <span class="pro-tabs-variable"><%=list1.getSize() %></span>
                            </li>
                            <li>
                                <span class="pro-tabs-constant">颜色分类:</span>
                                <span class="pro-tabs-variable"><%=list1.getColor() %></span>
                            </li>
                            <li>
                                <span class="pro-tabs-constant">设计元素:</span>
                                <span class="pro-tabs-variable"><%=list1.getSheJi() %></span>
                            </li> <li>
                            <span class="pro-tabs-constant">风格:</span>
                            <span class="pro-tabs-variable"><%=list1.getStyle() %></span>
                        </li>
                            <li>
                                <span class="pro-tabs-constant">款式定位:</span>
                                <span class="pro-tabs-variable"><%=list1.getGPS() %></span>
                            </li>
                        </ul>
                    </div>
                    <div class="am-tab-panel" id="tab2">2</div>
                    <div class="am-tab-panel" id="tab3">3</div>
                    <div class="am-tab-panel" id="tab4">4</div>
                </div>
            </div>
        </main>
    </aside>
	<%} %>
</section>

<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>

</html>