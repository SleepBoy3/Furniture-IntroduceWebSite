// JavaScript Document
window.onload = function(){
	showChater();
	scrollChater();
}
window.onscroll = scrollChater;
window.onresize = scrollChater;

function FocusItem(obj)
{
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj)
{
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
		case "userName":
			if(obj.value == "") {
				msgBox.innerHTML = "用户名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.innerHTML = "确认密码不能为空";
				msgBox.className = "error";
				return false;
			} else if(obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次输入的密码不相同";
				msgBox.className = "error";
				return false;
			}
			break;
		case "veryCode":
			if(obj.value == "") {
				msgBox.innerHTML = "验证码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}

function checkForm(frm)
{
	var els = frm.getElementsByTagName("input");
	for(var i=0; i<els.length; i++) {
		if(typeof(els[i].getAttribute("onblur")) == "function") {
			if(!CheckItem(els[i])) return false;
		}
	}
	return true;
}

function showChater()
{
	var _chater = document.createElement("div");
	_chater.setAttribute("id", "chater");
	var _dl = document.createElement("dl");
	var _dt = document.createElement("dt");
	var _dd = document.createElement("dd");
	var _a = document.createElement("a");
	_a.setAttribute("href", "#");
	_a.onclick = openRoom;
	_a.appendChild(document.createTextNode("在线聊天"));
	_dd.appendChild(_a);
	_dl.appendChild(_dt);
	_dl.appendChild(_dd);
	_chater.appendChild(_dl);
	document.body.appendChild(_chater);
}

function openRoom()
{
	window.open("chat-room.html","chater","status=0,scrollbars=0,menubar=0,location=0,width=600,height=400");
}

function scrollChater()
{
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92 + "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25 + "px";
}

function inArray(array, str)
{
	for(a in array) {
		if(array[a] == str) return true;
	}
	return false;
}

function setCookie(name,value)
{
  var Days = 30;
  var exp  = new Date();
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
}

function getCookie(name)
{
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}

function delCookie(name)
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
}

function goBuy(id, price)
{
	var newCookie = "";
	var oldCookie = getCookie("product");
	if(oldCookie) {
		if(inArray(oldCookie.split(","), id)) {
			newCookie = oldCookie;
		} else {
			newCookie = id + "," + oldCookie;
		}
	} else {
		newCookie = id;
	}
	
	setCookie("product", newCookie);
	location.href = "shopping.jsp";
}

function delShopping(id)
{var xhr;
if(window.XMLHttpRequest){
	xhr=new XMLHttpRequest();
	
	}else{
	xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
		
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){

location.reload("shopping.jsp");//刷新


	}}
	
	xhr.open("get", "deleteGWSer?id="+id);
	xhr.send(null);
	//var tr = document.getElementById("product_id_"+ id);
//	var oldCookie = getCookie("product");
//	if(oldCookie) {
//		var oldCookieArr = oldCookie.split(",");
//		var newCookieArr = new Array();
//		for(c in oldCookieArr) {
//			var cookie = parseInt(oldCookieArr[c]);
//			if(cookie != id) newCookieArr.push(cookie);
//		}
//		var newCookie = newCookieArr.join(",");
//		setCookie("product", newCookie);
//	}
	//if(tr) tr.parentNode.removeChild(tr);
}

function reloadPrice(id, status)
{
var xhr;
if(window.XMLHttpRequest){
	xhr=new XMLHttpRequest();
	
	}else{
	xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
		
	xhr.onreadystatechange=function(){
		
		
	}
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_"+id);
	//alert(price * number.value);
	
	
	if(status){
		
		number.value++;
		xhr.open("get", "updataGWSer?action=jia&id="+id,true);
		//alert("jia");
	} else {
		if(number.value== 1) {
		
			return false;
		} else {
			number.value--;
	
			xhr.open("get", "updataGWSer?action=jian&id="+id,true);
		}
	}
	xhr.send(null);
	priceBox.innerHTML = "￥" + (price * number.value).toFixed(1);//格式化为小数点为一位
	
}