<%@ page language="java" import="java.util.*,com.ysd.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
         <!-- layui、Jq包 -->
        <link rel="stylesheet" href="/JiaJu/manae/lib/layui/css/layui.css" media="all">
        <script type="text/javascript" src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script type="text/javascript" src="JiaJu/manae/js/jquery-1.8.2.min.js"></script>
        <!-- 分页包 -->
        <script type="text/javascript" src="/JiaJu/manae/paging/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/paging/jPages.js"></script>
        <script>
        	var layer,index
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

              //以上模块根据需要引入
              
            });

           
             /*用户-添加*/
            function Add(){//添加
              index=layer.open({
              type:2,
              title:'添加产品类',
              shadeClose:true,
              shade:[0.8,'#393D49'],
              maxmin:true,
              area:['500px','300px'],
              content:'manae/AddAdmin.jsp',
              end:function(layer,index){
              },cancel:function(index,layero){//添加成功后自动刷新
                     layer.close(index);
                    location.href="/JiaJu/LoginServlet?method=All";
                  }
              });
            }
           

            
            // 用户-编辑
            function update(id) {//修改
						index=layer.open({
                          type:2,
                          title:'编辑产品类',
                          shadeClose:true,
                          shade:[0.8,'#393D49'],//遮罩层的背景颜色透明度
                          maxmin:true,//最大化
                          area:['500px','300px'],
                          content:'/JiaJu/LoginServlet?method=get&id='+id,//跳转
                          end:function(layer,index){	
                          },cancel:function(index,layero){//执行编辑成功后自动刷新
                          		layer.close(index);
                        		location.href="/JiaJu/LoginServlet?method=All";
                          }
                         });
            }
           
            /*用户-删除*/
            function deleteById(obj,id){//删除
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    $.post("/JiaJu/LoginServlet?method=delete",{
                    	id:id
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
                    layer.msg('已删除!',{icon:1,time:1000});
                });
            }
            
            //批量删除
              function delAll(){
        		 layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    var data=$("#pl").serialize();
                    $.post("/JiaJu/LoginServlet?method=piLiang",data,
                    function(res){
                    	if(res.success){
                    		alert(res.message);
                    		window.location.href="/JiaJu/LoginServlet?method=All";
                    	}else{
                    		alert(res.message);
                    		window.location.href="/JiaJu/LoginServlet?method=All";
                    	}
                    },'json');
                   
                });
          }
            </script>
   <script>
           function chaxun(){
           var username=document.getElementById("name").value;
           	if(username==""){
           		alert("请输入你要搜索的用户名");
           		return;
           	}else{
           		window.location.href="/JiaJu/LoginServlet?method=chaxun&username="+username;
           		}
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
					perPage: 5
					
		});
		
          		});
          </script>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>管理员管理</cite></a>
              <a><cite>管理员列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="/JiaJu/LoginServlet?method=All" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
             <form class="layui-form x-center" action="" style="width:800px">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item"> 
                   
                    <div class="layui-input-inline">
                      <input type="text" name="name" id="name"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <input class="layui-btn" onclick="chaxun()" lay-submit="" lay-filter="sreach"  value="搜索"><i class="layui-icon"></i>
                    </div>
                  </div>
                </div> 
            </form>
            <%List<Admin> list1=(List<Admin>) request.getAttribute("list");
            if(list1!=null){
             %>
            <xblock>
            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
            <button class="layui-btn" onclick="Add()"><i class="layui-icon">&#xe608;</i>添加</button><span class="x-right" style="line-height:40px">共有数据：<%=list1.size() %> 条</span></xblock>
            <%} %>
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
                            用户名
                        </th>
                        <th>
                            密码
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>
                <form id="pl">
                <tbody id="FenYe">
                <%
                	List<Admin> list=(List<Admin>) request.getAttribute("list");
            			if(list!=null){
            			for(int i=0;i<list.size();i++){
             	%>
                    <tr>
                        <td>
                            <input type="checkbox" value="<%=list.get(i).getId() %>" name="pl">
                        </td>
                        <td>
                            <%=list.get(i).getId() %>
                        </td>
                        <td>
                            <%=list.get(i).getName() %>
                        </td>
                        <td class="td-status">   
                        <%=list.get(i).getPass() %>
                        </td>
                        <td class="td-manage">
                            <!-- <a style="text-decoration:none" onclick="member_stop(this,'10001')" href="javascript:;" title="停用">
                                <i class="layui-icon">&#xe601;</i>
                            </a>
                            <a title="编辑" href="javascript:;" onclick="member_edit('编辑','member-edit.jsp','4','','510')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a> -->
                            <a style="text-decoration:none"  onclick="update(<%=list.get(i).getId() %>)"
                            href="javascript:;" title="修改密码">
                                <i class="layui-icon">&#xe631;</i>
                            </a>
                            <a title="删除" href="javascript:;" onclick="deleteById(this,<%=list.get(i).getId() %>)" 
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                  
                </tbody>
                <%}
                } %>
                </form>
            </table>
			<div class="holder"></div>  
        </div>
        </body>
</html>