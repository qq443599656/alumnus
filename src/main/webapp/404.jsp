<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	pageContext.setAttribute("app_path", request.getContextPath());
%>
<head>

<link rel="stylesheet" href="${app_path}/resources/css/main.css" type="text/css"
	media="screen, projection" />
<!-- main stylesheet -->
<link rel="stylesheet" type="text/css" media="all" href="${app_path}/resources/css/tipsy.css" />
<!-- Tipsy implementation -->

<script type="text/javascript" src="${app_path}/resources/js/jquery-1.8.0.min.js"></script> <!-- uiToTop implementation -->
<script type="text/javascript" src="${app_path}/resources/js/custom-scripts.js"></script>
<script type="text/javascript" src="${app_path}/resources/js/jquery.tipsy.js"></script> <!-- Tipsy -->

<script type="text/javascript">
	$(document).ready(function() {

		universalPreloader();

	});

	$(window).load(function() {

		//remove Universal Preloader
		universalPreloaderRemove();

		rotate();
		dogRun();
		dogTalk();

		//Tipsy implementation
		$('.with-tooltip').tipsy({
			gravity : $.fn.tipsy.autoNS
		});

	});
</script>


<title>404 - Not found</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>

	<!-- Universal preloader -->
	<div id="universal-preloader">
		<div class="preloader">
			<img src="${app_path}/resources/images/universal-preloader.gif" alt="universal-preloader"
				class="universal-preloader-preloader" />
		</div>
	</div>
	<!-- Universal preloader -->

	<div id="wrapper">
		<!-- 404 graphic -->
		<div class="graphic"></div>
		<!-- 404 graphic -->
		<!-- Not found text -->
		<div class="not-found-text">
				<h1 class="not-found-text">找不到页面了,<br />对不起!</h1>
		</div>
		<!-- Not found text -->


		<div class="dog-wrapper">
			<!-- dog running -->
			<div class="dog"></div>
			<!-- dog running -->

			<!-- dog bubble talking -->
			<div class="dog-bubble"></div>

			<!-- The dog bubble rotates these -->
			<div class="bubble-options">
				<p class="dog-bubble">咦，找不到页面啦? 没关系, 看我多可爱!</p>
				<p class="dog-bubble">
					<br /> 旺! 旺!
				</p>
				<p class="dog-bubble">
					<br /> 不要担心! 有我在!
				</p>
				<p class="dog-bubble">
					我想要一块饼干<br />
					<img style="margin-top: 8px" src="${app_path}/resources/images/cookie.png" alt="cookie" />
				</p>
				<p class="dog-bubble">
					<br /> 天啊!好无聊啊!
				</p>
				<p class="dog-bubble">
					<br /> 我可以过来吗
				</p>
				<p class="dog-bubble">或者我只是在兜圈子?不…</p>
				<p class="dog-bubble">
					<br /> 好吧，我现在要走了。
				</p>
				<p class="dog-bubble">
					我想我看到了<br />
					<img style="margin-top: 8px" src="${app_path}/resources/images/cat.png" alt="cat" />
				</p>
				<p class="dog-bubble">我要过去了,
					旺旺@_@</p>
			</div>
			<!-- The dog bubble rotates these -->
			<!-- dog bubble talking -->
		</div>

		<!-- planet at the bottom -->
		<div class="planet"></div>
		<!-- planet at the bottom -->
	</div>

	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>