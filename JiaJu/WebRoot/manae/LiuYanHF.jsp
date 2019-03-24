<%@ page language="java" import="java.util.*,com.ysd.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
            // 当用户回复完成点击确定时会执行这个方法           
          function LiuYan_hf(id){//把id传进来
         		 var data=$("#form").serialize();//获取到from表单中所有值
     			  $.post("/JiaJu/LiuYanServlet?method=hfly&id="+id,data,//转发到LiuYanServlet中hfly方法并把id传进来，;
     	  				function(res){
                        		if(res.success){
                        			alert(res.message);
                        		}else{
                        			alert(res.message);
                        			}
                        	}
                        ,'json');
                        }
        </script>      
   </head>
    
    <body>
    <%
    		Liuyan hf=(Liuyan)request.getAttribute("hf");
     %>
             <form id="form" class="layui-form" onsubmit="return Test(this)">               
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>回复内容
                    </label>
                    <div class="layui-input-inline">
                    /*input中调用回复的内容*/
                        <input type="text" id="lynr" name="lynr" required="" lay-verify="required" value="<%=hf.getHuifu() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
             
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="LiuYan_hf(<%=hf.getId() %>)" />
                        回复
                    </a>
                </div>
            </form>              
    </body>

</html>
