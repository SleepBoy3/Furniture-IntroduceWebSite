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
        	//验证是否为空值
        	function Test(){
        		var productName=document.getElementById("productName").value;
        		if(productName==""){
        			alert("产品名不能为空！");
        			return false;
        		}
        			return true;	
        	}
        	//添加
        	function Add(){
        	if(Test()){	
        		var data=$("#form").serialize();
        		$.post("/JiaJu/ProductServlet?method=Add",data,function(res){ 
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
       
            <form id="form" class="layui-form" onsubmit="return Test(this)">
            <%List<ProductClass> lei=(List<ProductClass>) request.getAttribute("lei");//后台获取全部产品分类
             %>
                <div class="layui-form-item">
                    <label class="layui-form-label"><span class="x-red">*</span>产品类</label>
                    <div class="layui-input-inline" >
                        <select name="fid">
                        <%for(int i=0;i<lei.size();i++){ %>
                            <option value="<%=lei.get(i).getId() %>"><%=lei.get(i).getName() %></option>
                            <%} %>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品名称
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="productName" name="productName" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
             
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品材质
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="caiZhi" name="caiZhi" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品品牌
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="brand" name="brand" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品原价
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="Yprice" name="Yprice" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品现价
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="Xprice" name="Xprice" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品颜色
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="color" name="color" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品型号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="size" name="size" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品样式
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="style" name="style" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品定位
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="GPS" name="GPS" required="" lay-verify="required" 
                        autocomplete="off" class="layui-input">
                    </div>
                   
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        是否定制
                    </label>
                    
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="radio" id="dingZhi" name="dingZhi" value="是" checked title="是">
                            <input type="radio" id="dingZhi" name="dingZhi" value="否" title="否">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        是否组装
                    </label>
                    
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="是" checked title="是">
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="否" title="否">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>设计元素
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="sheJi" name="sheJi" required="" lay-verify="required" 
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
