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
		<!-- 分页包 -->
        <script type="text/javascript" src="/JiaJu/manae/paging/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/paging/jPages.js"></script>
		<!-- 分页样式 -->
 <style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
body{color:#000;font-family:microsoft yahei;}

/* content */
div#content{width:700px;margin:40px auto 0 auto;}
div#content ul#itemContainer li{display:inline-block;margin:5px;zoom:1;*display:inline;}
div#content ul#itemContainer ll li img{vertical-align:bottom;width:125px;height:125px;}
.holder{margin:15px 0;text-align:center;}
.holder a{font-size:12px;cursor:pointer;margin:0 5px;color:#000;padding:2px 5px;}
.holder a:hover{background-color:#eee;color:#FF4242;}
.holder a.jp-previous{margin-right:15px;}
.holder a.jp-next{margin-left:15px;}
.holder a.jp-current, a.jp-current:hover{color:#FF4242;font-weight:bold;}
.holder a.jp-disabled, a.jp-disabled:hover{color:#eee;}
.holder a.jp-current, a.jp-current:hover,.holder a.jp-disabled, a.jp-disabled:hover{cursor:default;background:none;}
.holder span{margin:0 5px;}
</style>  
			<!-- 分页 -->
          <script type="text/javascript">
          		$(function(){
          			$("div.holder").jPages({
					containerID: "FenYe",
					previous: "上一页",
					next: "下一页",
					perPage: 8					
		});
          		});
          </script>
</head>
<body>
<jsp:include page="/HeadSer"></jsp:include><!-- 引入页眉 -->
<section class="pro-list">
				
    <aside class="pro-leftsidebar">
        <ul>
            <li>
                <a>产品搜索</a>              
                	<ul id="pro-search">
                	<form  method="get" action="ProductAllSer" onsubmit="start(this)">
                       <li><a><input type="text"  class="pro-search" id="ss" name="ss"></a><a><input type="submit" class="pro-search-btn" value="搜索"></a></li> 
                 	</form> 
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

    <aside class="pro-rightsidebar">
     <%               
 				List<product> chanpin=(List<product>)request.getAttribute("cp");//前台显示对应产品分类的产品
                 %>
        <header>
                    <p></p>
            <span><%=chanpin.get(0).getProductClassName() %></span>
        </header>
        <ul  id="FenYe">
        <%for(int i=0;i<chanpin.size();i++){ %>
            <li>
                <a href="ProductInfoSer?id=<%=chanpin.get(i).getProductId()%>">
                    <div class="img-box">
                        <img src="<%=chanpin.get(i).getUrl()%>" style="height:230px;">
                        <p><%=chanpin.get(i).getProductName() %></p>
                    </div>
                </a>
            </li>
 	<%} %>
        </ul>
		<div class="holder"></div> 
    </aside>
</section>

<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>
</html>