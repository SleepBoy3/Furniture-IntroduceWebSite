<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
        <link rel="stylesheet" href="/JiaJu/manae/lib/layui/css/layui.css" media="all">
        <script type="text/javascript" src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script type="text/javascript" src="JiaJu/manae/js/jquery-1.8.2.min.js"></script>
        
        <script src="./lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="./js/x-layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            
              //自定义验证规则
              form.verify({
                nikename: function(value){
                  if(value.length < 1){
                    return '昵称至少得1个字符啊';
                  }
                }
                ,pass: [/(.+){3,12}$/, '密码必须3到12位']
                ,qrPass: function(value){
                    if($('#password').val()!=$('#qrPass').val()){
                        return '两次密码不一致';
                    }
                }
              });
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
        </script>
        <script type="text/javascript">
        	$(function(){
        var layer,index,form;
        	layui.use(['form','layer'],function(){
        	 	$ = layui.jquery;
				form = layui.form();       	 
        	 	upload = layui.upload;
        		layer=layui.layer;
        	});
        
        });
        		
        	 /* 管理员添加 */
        	function Test(){
        		var username=document.getElementById("username").value;
        		var password=document.getElementById("password").value;
        		var qrPass=document.getElementById("qrPass").value;
        		if(username==""&&password==""&&qrPass==""){
        			alert("内容不能为空！");
        			return false;
        		}
        			return true;	
        	}
        	function Add(){
        	if(Test()){
        	var data=$("#form").serialize();
        		$.post("/JiaJu/LoginServlet?method=Add",data,
        		function(res){
        			if(res.success){
        				alert(res.message);
        			}else{
        				alert(res.message);
        			}
        		},'json');
        		}
        	}
        </script>
    </head>
    
    <body>
        <div class="x-body">
            <form class="layui-form" id="form">
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        <span class="x-red">*</span>用户名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="username" name="username" required="" lay-verify="nikename"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_pass" class="layui-form-label">
                        <span class="x-red">*</span>密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="password" name="password" required="" lay-verify="pass"
                        autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        3到16个字符
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                        <span class="x-red">*</span>确认密码
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" id="qrPass" name="qrPass" required="" lay-verify="qrPass"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <button  class="layui-btn" lay-filter="add" lay-submit="" onclick="Add()">
                        增加
                    </button>
                </div>
            </form>
        </div>
        
    </body>

</html>