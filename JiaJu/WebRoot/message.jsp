<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script>
	function start(){
		var name=document.getElementsByName("username");
		var telephone=document.getElementsByName("tel");
		var email=document.getElementsByName("email");
		var info=document.getElementsByName("info");
		if(name==""){
			alert("name不能为空");
			return false;
		}else if(telephone==""){
			alert("telephone不能为空");
			return false;
		}else if(email==""){
			alert("email不能为空");
			return false;
		}else if(info==""){
			alert("info不能为空");
			return false;
		}
	
	return true;
	window.localhost.href="/JiaJu/message.jsp";
	}
</script>
</head>
<body>
<jsp:include page="/HeadSer"></jsp:include><!-- 引入页眉 -->
<div>
    <header class="header-article-list">
        <h1>在线留言</h1>

    </header>
<div>
   <form class="message-form" method="post" action="LiuyanSer" onsubmit="start(this)">

       <label>姓名
           <input type="text" name="username" id="username">
           <span>*</span>
       </label>


       <label>电话
           <input type="text" name="tel" id="tel">
           <span>*</span>
       </label>


       <label>邮箱
           <input type="email" name="email" id="emali">
           <span>*</span>
       </label>


       <label>内容
           <textarea type="info" name="info" id="info"></textarea>
           <span>*</span>
       </label>


       <button type="submit" class="am-btn am-btn-danger">提交</button>
   </form>
</div>
</div>
<jsp:include page="/FootSer"></jsp:include><!-- 引入页脚 -->
</body>
</html>