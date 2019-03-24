<%@ page language="java" import="java.util.*,com.ysd.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            X-admin v1.0
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/JiaJu/manae/css/x-admin.css" media="all">
        
         <script type="text/javascript" src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/js/jquery-1.8.2.min.js"></script>
         <script src="./lib/layui/layui.js" charset="utf-8"></script>
        	<!-- 添加 -->
        <script type="text/javascript">
        
        	var layer,index,form
        	layui.use(['layer','form'],function(){
        		layer=layui.layer;
        		form.rendar;
        	})
        	
        	function Add(){
        		var data=$("#form").serialize();//获取文本框里面的值
        		
        		$.post("/JiaJu/NewsClassServlet?method=Add",data,//post 提交
        		function(res){
        			if(res.success){
        				alert(res.message);
        			}else{
        				alert(res.message);
        			}
        		},'json');
        		
        	}
        </script>
   </head>
    
    <body>
       
            <form id="form" class="layui-form" onsubmit="return Test(this)">
           
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>新闻类
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="newsClass" name="newsClass" required="" lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                 
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="Add()">
                        添加
                    </a>
                </div>
            </form>
       
       
    </body>

</html>
