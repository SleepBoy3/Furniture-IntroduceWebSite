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
        
         <script type="text/javascript" src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/js/jquery-1.8.2.min.js"></script>
         <script src="./lib/layui/layui.js" charset="utf-8"></script>
       
       <!--  <script>
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
        </script> -->
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
        	<!-- 添加 -->
        <script type="text/javascript">
        
        	 	var layer,index,form
        	layui.use(['layer','form'],function(){
        		layer=layui.layer;
        		form.rendar;
        	})

        	/* function Test(){
        		var newsClass=document.getElementById("newsClass").value;
        		var title=document.getElementById("title").value;
        		var info=document.getElementById("info").value;
        		var click=document.getElementById("click").value;
        		var newsClassId=document.getElementById("newsClassId").value;
        		if(newsClass==""&&title==""&&info==""){
        			alert("产品类名不能为空！");
        			return false;
        		}
        			return true;	
        	} */
        	function Add(){

        		/* var newsClass=document.getElementById("newsClass").value;
        		var title=document.getElementById("title").value;
        		var info=document.getElementById("info").value;
        		var click=document.getElementById("click").value;
        		var newsClassId=document.getElementById("newsClassId").value; */
        		var data=$("#form").serialize();
        		$.post("/JiaJu/NewsServlet?method=Add",data,
        		function(res){
        			if(res.success){
        				alert(res.message);
        			}else{
        				alert(res.message);
        			}
        		},'json');
        		
        	}
        	 <%
        	 		Admin ad=(Admin) request.getAttribute("ad");
        	 		if(ad!=null){
        	  %>
        	/* 修改 */
        	function update(id){
        		layer.confirm('确认要修改吗？',function(index){
              	
        		var data=$("#form").serialize();
              		  $.post("/JiaJu/LoginServlet?method=update&id=<%=ad.getId() %>",data,
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
   </head>
    
    <body>
            <form class="layui-form" onsubmit="return Test(this)" id="form">
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>用户名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="username" name="username" required="" lay-verify="required" value="<%=ad.getName() %>"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                  <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="password" name="password" required="" lay-verify="required" value="<%=ad.getPass()%>"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                
              
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="update(<%=ad.getId()%>)">
                        修改
                    </a>
                </div>
                <%} %>
            </form>
       
       
    </body>

</html>