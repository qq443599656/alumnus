<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>西北工业大学校友网后台 - 忘记密码</title>
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



	function isEmailOk() {
		var name = $("#user_email");
		if (name.val() == "") {
			$("#user_email_td").html("邮箱不能为空");
			name.focus();
			return false;
		}
		//验证邮件格式
		var reg = /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;
		if (!reg.test(name.val())) {
			$("#user_email_td").html("请填写正确邮箱！");
			name.focus();
			return false;
		} else {
			$.ajax({
				url : 'user_isEmailOk.action',
				// 数据发送方式  
				type : "post",
				// 接受数据格式  
				dataType : "json",
				// 要传递的数据  
				data : {
					user_email : $.trim($("#user_email").val())
				},
				// 回调函数，接受服务器端返回给客户端的值，即result值  
				success : function(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
					if (data == "ok") {
						$("#user_email_td").html("对不起，此邮箱未绑定任何用户！");
					} else {
						$("#user_email_td").html("邮箱正确!");
					}
				}
			});
		}
	}

	function updatePassword() {
		var divEmail = document.getElementById("user_email_td").innerHTML;
		if (divEmail != "邮箱正确!") {
			$("#user_submit_td").html("请按照要求填写邮箱！");
			return false;
		} else {
			$.ajax({
				url : 'user_forgetPassword.action',
				// 数据发送方式  
				type : "post",
				// 接受数据格式  
				dataType : "json",
				// 要传递的数据  
				data : {
					user_username : $.trim($("#user_username").val()),
					user_password : $.trim($("#user_password").val()),
					user_email : $.trim($("#user_email").val())
				},
				// 回调函数，接受服务器端返回给客户端的值，即result值  
				success : function(data) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据  
					if (data == "ok") {
						alert("请前去邮箱修改密码！");
						window.location.href = 'login.jsp';
					} else {
						alert("对不起，数据发生异常！");
						window.location.href = '404.jsp';
					}
				}
			});
		}
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
			<h3>忘记密码</h3>
			<form action="" target="_self">
				<table>
					<tr>
						<td><input type="email" onkeyup="isEmailOk()"
							class="form-control" id="user_email" name="user_email"
							placeholder="请输入您的电子邮件" required=""></td>
						<td>
							<div id="user_email_td"
								style="width: 200px; height: 30px; text-align: center;">请输入您的电子邮件</div>
						</td>
					</tr>
					<tr>
						<td>
							<div id="user_submit_td"
								style="width: 300px; height: 30px; text-align: center;"></div>
						</td>
					</tr>
					<tr>
						<td>
							<button type="button"
								class="btn btn-primary block full-width m-b"
								onclick="updatePassword()">点击修改密码</button>
						</td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.5"></script>
</body>

</html>