<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>西北工业大学校友网后台 - 登录</title>
<%
	pageContext.setAttribute("app_path", request.getContextPath());
%>

<meta name="keywords" content="西北工业大学校友网后台">
<meta name="description" content="西北工业大学校友网后台">

<link rel="shortcut icon" href="favicon.ico">
<link href="${app_path}/resources/css/bootstrap.min.css?v=3.3.5"
	rel="stylesheet">
<link href="${app_path}/resources/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet">
<link href="${app_path}/resources/css/animate.min.css" rel="stylesheet">
<link href="${app_path}/resources/css/style.min.css?v=4.0.0"
	rel="stylesheet">
<base target="_blank">
<script type="text/javascript"
	src="${app_path}/resources/js/jquery-1.8.0.min.js"></script>
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
	function login() {
		var name = $("#user_username");
		if (name.val() == "") {
			alert("用户名不能为空");
			name.focus();
			return false;
		}
		var password = $("#user_password");
		if (password.val() == "") {
			alert("密码不能为空");
			password.focus();
			return false;
		}
		$.ajax({
			url : 'user_login.action',
			// 数据发送方式  
			type : "post",
			// 接受数据格式  
			dataType : "json",
			// 要传递的数据  
			data : {
				user_username : $("#user_username").val(),
				user_password : $("#user_password").val()
			},
			// 回调函数，接受服务器端返回给客户端的值，即result值  
			success : function(data) {
				//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
				if (data == "ok") {
					window.location.href = 'user_index.action';
				} else if (data == "userNo") {
					alert("您输入的用户名或密码错误！请重试！");
				} else if (data == "noActivation") {
					alert("您输入的用户未激活，请先激活！");
				} else if (data == "no") {
					alert("数据异常！登陆失败！");
				} else if (data == "noState") {
					alert("用户已经登陆，无法继续登录！");
				}
			}
		});
	}
</script>
</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">
					<img src="${app_path}/resources/images/xibeigongyedaxue.png">
				</h1>

			</div>
			<h3>欢迎使用西北工业大学校友网管理系统</h3>
			<form id="form1">
				<div class="form-group">
					<input id="user_username" name="user_username" type="text"
						class="form-control" placeholder="用户名" required="">
				</div>
				<div class="form-group">
					<input id="user_password" name="user_password" type="password"
						class="form-control" placeholder="密码" required="">
				</div>
				<button type="button" class="btn btn-primary block full-width m-b"
					onclick="login()">登 录</button>
				<p class="text-muted text-center">
					<a href="forgetPassword.jsp" target="_self"><small>忘记密码了？</small></a>
					| <a href="register.jsp" target="_self">注册一个新账号</a>
				</p>
			</form>
		</div>
	</div>
</body>

</html>