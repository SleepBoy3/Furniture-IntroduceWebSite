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
        
          <link rel="stylesheet" href="/JiaJu/manae/css/x-admin.css" media="all">
        <link rel="stylesheet" href="/JiaJu/manae/layui/css/layui.css">
         <script type="text/javascript" src="/JiaJu/manae/layui/layui.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/js/jquery-1.8.2.min.js"></script>
       
        <script type="text/javascript">
              $(function(){
       layui.use(['upload','form','layer'],function(){
        	 //	$ = layui.jquery;
				//form = layui.form();       	 
        	 	upload = layui.upload;
        		layer=layui.layer;
        	 
  			//选完文件后不自动上传
  			upload.render({
    			elem: '#test8',
    			url: 'SheJiShiServlet?method=SaveImages',
    			auto: false,
    			bindAction: '#test9',
    			done: function(res){
      				console.log(res);
    			}
  			});
 			});
  		});
         var img;
  $(function(){
  $("#test9").click(function(){
  		img=$("#div span").text();//获取div把获取到的图片名放在span标签内,并赋给img
  });
  });
            // 用户-编辑
           <%
             SheJiShi sjs=(SheJiShi)request.getAttribute("sjs");
              	
              %>
              function SheJiShi_Upd(){
              	 layer.confirm('确认要修改吗？',function(index){
              		var data=$("#form").serialize();
              		  $.post("/JiaJu/SheJiShiServlet?method=update&id=<%=sjs.getId()%>&tp="+img,data,
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
        
             <form id="form" class="layui-form" onsubmit="return Test(this)">
            	<div class="layui-upload" id="div">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  <button type="button" class="layui-btn layui-btn-normal" id="test8" >选择文件</button>
				  <button type="button" class="layui-btn" id="test9">开始上传</button>
				</div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>名字
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" required="" lay-verify="required" value="<%=sjs.getName()%>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
              
                 <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>资料
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="SheJiShiInfo" name="SheJiShiInfo" required="" lay-verify="required" value="<%=sjs.getInfo() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                  
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="SheJiShi_Upd()">
                        修改
                    </a>
                </div>
            </form>
       
       
    </body>

</html>
