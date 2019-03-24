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
        <link rel="stylesheet" href="./manae/css/x-admin.css" media="all">
        
         <script  src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script src="/JiaJu/manae/js/jquery-1.8.2.min.js"></script>
         <script src="./lib/layui/layui.js" charset="utf-8"></script>
       
         <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
              ss
              //监听提交
              form.on('submit(add)', function(data){
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("增加成功", {icon: 6},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
                return false;
              });  
            });
            <%
              ProductClass cpl=(ProductClass)request.getAttribute("cpl");//后台获取所有产品类
              	
              %>
              //修改
              function productClass_Upd(){
              	layer.confirm('确认要修改吗？',function(index){
              		var productClassName=document.getElementById("productClassName").value;
              		  $.post("/JiaJu/ProductClassServlet?method=update&id=<%=cpl.getId( )%>",{
              			productClassName:productClassName
                        	},
                        	function(res){
                        		if(res.success){
                        			alert(res.message);
                        		}else{
                        			alert(res.message);
                        		}
                        	}
                        ,'json');
              		 $(obj).parents("tr").remove();
                       layer.msg('已修改!',{icon:1,time:1000});
                   });
              }
              
        </script> 
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        
    
        </script>
       
        
   </head>
    
    <body>
       
            <form id="form" class="layui-form" onsubmit="return Test(this)">
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品类名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="productClassName" name="productClassName" required="" lay-verify="required"  value="<%=cpl.getName() %>" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                
              
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="productClass_Upd()">
                        修改
                    </a>
                </div>
            </form>
       
       
    </body>

</html>
