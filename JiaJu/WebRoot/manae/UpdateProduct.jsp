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
    		HProduct cp=(HProduct)request.getAttribute("cp");		
     %>
     		  //编辑
              function product_Upd(id){
              	 layer.confirm('确认要修改吗？',function(index){
              		var data=$("#form").serialize();
              		  $.post("/JiaJu/ProductServlet?method=update&id=<%=cp.getProductId()%>",data,
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
   			<%List<ProductClass> cpl=(List<ProductClass>)request.getAttribute("lei");//后台获取全部产品分类
   			 %>
   			
             <form id="form" class="layui-form" onsubmit="return Test(this)" >
              <div class="layui-form-item">
                    <label class="layui-form-label"><span class="x-red">*</span>产品类</label>
                    <div class="layui-input-inline" >
                        <select name="productClassId">
                        <% for(int i=0;i<cpl.size();i++){%>
                            <option value="<%=cpl.get(i).getId() %>"><%=cpl.get(i).getName()%></option>
                            <%} %>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>产品名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="productName" name="productName" required="" lay-verify="required" value="<%=cp.getProductName() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                 
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>材质
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="productCaiZhi" name="productCaiZhi" required="" lay-verify="required" value="<%=cp.getCaiZhi() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>品牌
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="productBrand" name="productBrand" required="" lay-verify="required" value="<%=cp.getBrand() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>原价
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="Yprice" name="Yprice" required="" lay-verify="required" value="<%=cp.getYprice() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>现价
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="Xprice" name="Xprice" required="" lay-verify="required" value="<%=cp.getXprice() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>颜色
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="color" name="color" required="" lay-verify="required" value="<%=cp.getColor() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>型号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="size" name="size" required="" lay-verify="required" value="<%=cp.getSize() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>样式
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="style" name="style" required="" lay-verify="required" value="<%=cp.getStyle() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>款式定位
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="GPS" name="GPS" required="" lay-verify="required" value="<%=cp.getGPS() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
               
                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        是否定制
                    </label>
                    
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                         <%if(cp.getDingZhi().equals("是")){ %>
                            <input type="radio" id="dingZhi" name="dingZhi" value="<%=cp.getDingZhi() %>" checked="checked" title="是">
                            <input type="radio" id="dingZhi" name="dingZhi" value="否" title="否">
                       	<%} else{%>
                       	 <input type="radio" id="dingZhi" name="dingZhi" value="是"  title="是">
                            <input type="radio" id="dingZhi" name="dingZhi" value="<%=cp.getDingZhi() %>" checked="checked" title="否">
                       	<%} %>
                        </div>
                    </div>
                </div>
                  <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        是否组装
                    </label>
                    
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                          <%if(cp.getZuZhuang().equals("是")){ %>
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="<%=cp.getZuZhuang() %>" checked="checked title="是">
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="否" title="否">
                        <%}else{ %>
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="是"  title="是">
                            <input type="radio" id="zuZhuang" name="zuZhuang" value="<%=cp.getZuZhuang() %>" checked="checked" title="否">
                        <%} %>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="username" class="layui-form-label">
                        <span class="x-red">*</span>设计元素
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="sheJi" name="sheJi" required="" lay-verify="required" value="<%=cp.getSheJi() %>"
                        autocomplete="off" class="layui-input">
                    </div>    
                </div>
                
              
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <a class="layui-btn" lay-filter="add" lay-submit="" onclick="product_Upd(<%=cp.getProductId()%>)">
                        修改
                    </a>
                </div>
            </form>
       
       
    </body>

</html>
