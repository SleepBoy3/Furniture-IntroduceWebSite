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
         <!-- layui、Jq包 -->
        <link rel="stylesheet" href="/JiaJu/manae/lib/layui/css/layui.css" type="text/css"></link>
        <script  src="/JiaJu/manae/lib/layui/layui.js"></script>
        <script  src="JiaJu/manae/js/jquery-1.8.2.min.js"></script>
         <!-- 分页包 -->
        <script type="text/javascript" src="/JiaJu/manae/paging/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/JiaJu/manae/paging/jPages.js"></script>
         <script>
         var layer,index;
            layui.use(['element','laypage','layer','form'], function(){
                $ = layui.jquery;//jquery
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层
              form = layui.form();//弹出层
          });
              //以上模块根据需要引入
                    
            /*删除*/
            function LiuYan_del(obj,id){//把id传进来，因为要id进行搜索你要删除的是那条数据
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    $.post("/JiaJu/LiuYanServlet?method=delete",{//提交到LiuYanServlet中delete方法
                    id:id
                    },function(res){
                    		if(res.success){
                    			alert(res.message);
                    		}else{
                    			alert(res.message);
                    		}
                    	},'json');//以josn的方式把id提交到LiuYanServlet中delete方法
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                });
            }     
          // 回复留言;
            function LiuYan_hf(obj,id) {//把id传进来,因为要判断用户所要回复的是哪一条留言;
               	index=layer.open({
                          type:2,
                          title:'留言回复',
                          shadeClose:true,
                          shade:[0.8,'#393D49'],//遮罩层的背景颜色透明度
                          maxmin:true,//最大化
                          area:['600px','400px'],//弹框的大小
                          offset:['100px','400px'],//弹出框在页面的坐标
                          content:'/JiaJu/LiuYanServlet?method=HuiFu&id='+id,//跳转到LiuYanServlet中的一个方法HuiFu并把id传进去
                          end:function(layer,index){	
                          },cancel:function(index,layero){//执行编辑成功后自动刷新
                          		layer.close(index);
                        		location.href="/JiaJu/LiuYanServlet?method=All";
                          }
                         });
            }
            </script>
            <script>
            //留言搜索
           function LiuYan_ss(){
           var name=document.getElementById("name").value;//获取到文本框值
           	if(name==""){//如果框中值为空
           		alert("请输入你要搜索的留言人的姓名");//提示用户输入值
           		return;
           		}else{
           		window.location.href="/JiaJu/LiuYanServlet?method=SouSuo&name="+name;//转发LiuYanServlet中SouSuo方法并把名字传过去;
           		}
           }
           
           //未回复
           function LiuYan_whf(){//点击未回复是转发到LiuYanServlet中WeiHF的方法
           		window.location.href="/JiaJu/LiuYanServlet?method=WeiHF";
          	}
          	
          	//以回复
          	function LiuYan_yhf(){//点击以回复是转发到LiuYanServlet中YiHF的方法
           		window.location.href="/JiaJu/LiuYanServlet?method=YiHF";        
          	}
          	//批量删除
              function delAll(){
        		 layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    var data=$("#pl").serialize();
                    $.post("/JiaJu/LiuYanServlet?method=piLiang",data,
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
					perPage: 10
					
		});
		
          		});
          </script>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>会员管理</cite></a>
              <a><cite>评论列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="/JiaJu/LiuYanServlet?method=All" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <form class="layui-form x-center" action="" style="width:800px">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item"> 
                   
                    <div class="layui-input-inline">
                      <input type="text" name="name" id="name" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <input  class="layui-btn"  onclick="LiuYan_ss()"  lay-submit="" lay-filter="sreach"  value="搜索"><i class="layui-icon"></i>
                    </div>
                     <div class="layui-input-inline" style="width:80px;margin-left:100px;">
                        <input  class="layui-btn"  onclick="LiuYan_yhf()"  lay-submit="" lay-filter="sreach"  value="已回复"><i class="layui-icon"></i>
                    </div>
                    <div class="layui-input-inline" style="width:80px;margin-left:100px;">
                        <input  class="layui-btn"  onclick="LiuYan_whf()"  lay-submit="" lay-filter="sreach"  value="未回复"><i class="layui-icon"></i>
                    </div>
                  </div>
                </div> 
            </form>
        <div class="x-body">
        <%List<Liuyan> ly=(List<Liuyan>)request.getAttribute("ly"); 
        		if(ly!=null){
        %>
            <xblock>
            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
            <span class="x-right" style="line-height:40px">共有数据：<%=ly.size() %> 条</span>
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
                            姓名	
                        </th>
                         <th>
                            电话
                        </th>
                        <th>
                            邮箱
                        </th>
                        <th>
                            内容
                        </th>
                        <th>
      	       时间
                        </th>
                        <th>
                           回复
                        </th>
                        <th>
                          状态
                        </th>
                         <th>
                          操作
                        </th>
                    </tr> 
                </thead>
                <form id="pl">
                <tbody id="FenYe">
                   <% 
                		if(ly!=null){
                		for(int i=0;i<ly.size();i++){
                 %>
                    <tr>
                        <td>
                            <input type="checkbox" value="<%=ly.get(i).getId() %>" name="pl">
                        </td> 
                         <td >
                            <%=ly.get(i).getId() %>
                        </td>
                        <td>
                            <%=ly.get(i).getName() %>
                        </td>
                        <td>
                          <%=ly.get(i).getTelephone() %>
                        </td>
                        <td >
                          <%=ly.get(i).getEmail() %>
                        </td>
                        <td>
                           <a onclick="LiuYan_hf()"><%=ly.get(i).getInfo() %></a>
                        </td> 
                          <td>
                           <%=ly.get(i).getDate() %>
                        </td>  
                        <td class="td-status">                    
                           <%=ly.get(i).getHuifu() %>
                        </td>
                        <td class="td-status">                    
                           <%=ly.get(i).getZhuangTai() %>
                        </td>
                        <td class="td-manage">
                       <a style="text-decoration:none" title="回复" onclick="LiuYan_hf(this,<%=ly.get(i).getId()%>)">                      
                                <i class="layui-icon">&#xe601;</i>
                            </a>                         
                       <a title="删除" href="javascript:;" onclick="LiuYan_del(this,<%=ly.get(i).getId() %>)" 
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                    <%		}
                    	}
                    }  
                    %>
                </tbody>
                </form>
            </table>	
            <div class="holder"></div>    			         
        </div>              
    </body>
</html>