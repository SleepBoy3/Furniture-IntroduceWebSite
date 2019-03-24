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
        <meta name="viewport" content="width=device-width, initial-scale=, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/JiaJu/manae/css/x-admin.css" media="all">
         <link rel="stylesheet" href="/JiaJu/manae/css/x-admin.css" media="all">
        <link rel="stylesheet" href="/JiaJu/css/x-admin.css" media="all">
         <link rel="stylesheet" href="/JiaJu/css/x-admin.css" media="all">
           <!-- layui、Jq包 -->
          <link rel="stylesheet" href="/JiaJu/manae/lib/layui/css/layui.css" media="all">
        <script type="text/javascript" src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/js/jquery-1.8.2.min.js"></script> 
          <!-- 分页包 -->
        <script type="text/javascript" src="/JiaJu/manae/paging/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/paging/jPages.js"></script>
           <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

              //以上模块根据需要引入

                layer.ready(function(){ //为了layer.ext.js加载完毕再执行
                  layer.photos({
                    photos: '#x-img'
                    //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
                  });
                }); 
              
            });
            
            
            //添加
            function images_add(){
                   index=layer.open({
              type:2,
              title:'添加公司信息',
              shadeClose:true,
              shade:[0.8,'#393D49'],
              maxmin:true,
              area:['500px','400px'],
              
              content:'/JiaJu/ImagesServlet?method=XiaLa',
              end:function(layer,index){
              		},cancel:function(index,layero){//添加成功后自动刷新
              			layer.close(index);
              			location.href="/JiaJu/ImagesServlet?method=All";
              		}
              	});
            }
            
            //删除
            function Images_del(obj,id){
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据              
                    $.post("/JiaJu/ImagesServlet?method=delete",{
                    	id:id
                    },function(res){
                    	if(res.success){
                    		alert(res.message);
                    	}else{
                    		alert(res.message);
                    	}
                    },'json');
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                });
            }
            //批量删除
              function delAll(){
        		 layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    var data=$("#pl").serialize();
                    $.post("/JiaJu/ImagesServlet?method=piLiang",data,
                    function(res){
                    	if(res.success){
                    		alert(res.message);
                    	}else{
                    		alert(res.message);
                    	}
                    },'json');
                   
                });
          }
            
         
            </script>
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
					perPage: 4
					
		});
		
          		});
        
          </script>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>会员管理</cite></a>
              <a><cite>轮播列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
        <% List<Images> Imglist=(List<Images>)request.getAttribute("Imglist");//后台获取全部图片
         %>
            <xblock>
            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
            <button class="layui-btn" onclick="images_add()"><i class="layui-icon">&#xe608;</i>添加</button><span class="x-right" style="line-height:40px">共有数据：<%=Imglist.size() %> 条</span>
            </xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" name="" value="">
                        </th>
                        <th>
                            ID
                        </th>
                        <th>
                        图片路径
                        </th>
                        <th>
                      商品图片Id
                        </th>
                        
                        
                        <th>
                            热度值
                        </th>
                         <th>
                            是否主图
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>
               <form id="pl">
                <tbody id="FenYe">
                 <%
                	if(Imglist!=null){
                	for(int i=0;i<Imglist.size();i++){
                 %>
                    <tr>
                        <td>
                            <input type="checkbox" value="<%=Imglist.get(i).getId() %>" name="pl">
                        </td>
                        <td>
                            <%=Imglist.get(i).getId() %>
                        </td>
                        <td>
             
                            <img  src="<%=Imglist.get(i).getUrl() %>" style="width:200px;height:95px;" alt="" > 
                        </td>
                        <td >
                           <%=Imglist.get(i).getProductId() %>
                        </td>
                        <td >
                           <%=Imglist.get(i).getClick() %>
                        </td>
                        <td >
                           <%=Imglist.get(i).getZhuTu() %>
                        </td>
                        
                        <td class="td-manage">
                           
                            
                            <a title="删除" href="javascript:;" onclick="Images_del(this,<%=Imglist.get(i).getId() %>)" 
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                    <%}} %>
                </tbody>
                </form>
            </table>
				<div class="holder"></div> 
			</div>
        </body>
</html>