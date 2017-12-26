<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.xaccp.alumni.entity.User"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright"
	content="All Rights Reserved, Copyright (C) 2013, Wuyeguo, Ltd." />
<title>西北工业大学后台管理系统</title>
<%
	User user = (User) request.getSession().getAttribute("User");
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/wu.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/icon.css" />
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>


</head>
<body class="easyui-layout">
	<!-- begin of header -->
	<div class="wu-header"
		data-options="region:'north',border:false,split:true">
		<div class="wu-header-left">
			<h1>西北工业大学后台管理系统</h1>
		</div>
		<div class="wu-header-right">
			<p>
				<strong class="easyui-tooltip" title="2条未读消息"><%=user.getUser_username()%></strong>，欢迎您！
			</p>
			<p>
				<a href="user_invalidateSession.action">安全退出</a>
			</p>
		</div>
	</div>
	<!-- end of header -->
	<!-- begin of sidebar -->
	<div class="wu-sidebar"
		data-options="region:'west',split:true,border:true,title:'导航菜单'"
		style="width: 250px;">
		<div class="easyui-accordion" data-options="border:false,fit:true">
			<div title="校友注册审核" data-options="iconCls:'icon-application-cascade'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="html/校友注册审核/smartAssessment.html" iframe="0">智能审核</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users"
						data-link="html/校友注册审核/artificialAssessment.html" iframe="0">人工审核</a></li>
				</ul>
			</div>
			<div title="校友信息管理"
				data-options="iconCls:'icon-application-form-edit'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-application-osx-error"
						data-link="html\校友信息管理\infoManagement.html" iframe="0">校友信息管理</a></li>
					<li iconCls="icon-cog"><a href="javascript:void(0)"
						data-icon="icon-application-osx-error"
						data-link="html\校友信息管理\contactManagement.html" iframe="0">校友交往信息</a></li>
					<li iconCls="icon-user-group"><a href="javascript:void(0)"
						data-icon="icon-application-osx-error"
						data-link="html\校友信息管理\synthesizeInfoQuery.html" iframe="0">校友综合查询</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-application-osx-error"
						data-link="html\校友信息管理\infoExcel.html" iframe="0">校友信息导出</a></li>
					<li iconCls="icon-cog"><a href="javascript:void(0)"
						data-icon="icon-application-osx-error"
						data-link="html\校友信息管理\statisticsInfoManagement.html" iframe="0">统计信息管理</a></li>
				</ul>
			</div>
			<div title="校友会机构" data-options="iconCls:'icon-creditcards'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="html\校友会机构\alumniAssociationManagement.html" iframe="0">校友会管理</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">机构管理</a></li>
					<li iconCls="icon-user-group"><a href="javascript:void(0)"
						data-icon="icon-user-group" data-link="temp/layout-3.html"
						iframe="0">圈子管理</a></li>
					<li iconCls="icon-book"><a href="javascript:void(0)"
						data-icon="icon-book" data-link="temp/layout-3.html" iframe="0">机构名单导出</a></li>
					<li iconCls="icon-cog"><a href="javascript:void(0)"
						data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">社区成员管理</a></li>
				</ul>
			</div>
			<div title="校友活动管理" data-options="iconCls:'icon-cart'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">活动管理</a></li>
				</ul>
			</div>
			<div title="校友服务管理" data-options="iconCls:'icon-bricks'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">校友综合服务管理</a></li>
				</ul>
			</div>
			<div title="校友联络管理" data-options="iconCls:'icon-chart-curve'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">联络管理</a></li>
				</ul>
			</div>
			<div title="校友互动管理" data-options="iconCls:'icon-creditcards'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">校友互动管理</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">相册管理</a></li>
				</ul>
			</div>
			<div title="权限管理" data-options="iconCls:'icon-creditcards'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">菜单权限管理</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">校友信息权限管理</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">用户组管理</a></li>
				</ul>
			</div>
			<div title="配置管理" data-options="iconCls:'icon-wrench'"
				style="padding: 5px;">
				<ul class="easyui-tree wu-side-tree">
					<li iconCls="icon-chart-organisation"><a
						href="javascript:void(0)" data-icon="icon-chart-organisation"
						data-link="layout-3.html" iframe="0">属性管理</a></li>
					<li iconCls="icon-users"><a href="javascript:void(0)"
						data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">用户管理</a></li>
					<li iconCls="icon-user-group"><a href="javascript:void(0)"
						data-icon="icon-user-group" data-link="temp/layout-3.html"
						iframe="0">权限管理</a></li>
					<li iconCls="icon-book"><a href="javascript:void(0)"
						data-icon="icon-book" data-link="temp/layout-3.html" iframe="0">日志管理</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- end of sidebar -->
	<!-- begin of main -->
	<div class="wu-main" data-options="region:'center'">
		<div id="wu-tabs" class="easyui-tabs"
			data-options="border:false,fit:true">
			<div title="首页"
				data-options="closable:false,iconCls:'icon-tip',cls:'pd3'">
				<p
					style="font-family: '微软雅黑'; font-size: 20px; text-align: center; font-weight: bold;">欢迎使用西北工业大学后台管理系统</p>
				<img src="images/西工大门头.png" width="100%" height="100%" />
			</div>
		</div>
	</div>
	<!-- end of main -->
	<!-- begin of footer -->
	<div class="wu-footer"
		data-options="region:'south',border:true,split:true"
		style="height: 50px; background-image: url(images/bg_header_1.jpg); padding: 10px; font-family: '微软雅黑'; font-weight: bolder; text-align: center; font-size: 15px; color: #FAFAFA;">
		&copy; 版权所有，盗版必究！</div>
	<!-- end of footer -->
	<script type="text/javascript">
		$(function() {
			$('.wu-side-tree a').bind("click", function() {
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe') == 1 ? true : false;
				addTab(title, url, iconCls, iframe);
			});
		})

		/**
		 * Name 载入树形菜单 
		 */
		$('#wu-side-tree').tree({
			url : 'temp/menu.php',
			cache : false,
			onClick : function(node) {
				var url = node.attributes['url'];
				if (url == null || url == "") {
					return false;
				} else {
					addTab(node.text, url, '', node.attributes['iframe']);
				}
			}
		});

		/**
		 * Name 选项卡初始化
		 */
		$('#wu-tabs').tabs({
			tools : [ {
				iconCls : 'icon-no',
				border : false,
				handler : function() {
					$('#wu-datagrid').datagrid('reload');
					$('#wu-datagrid').onClick(closeAll());
				}
			} ]
		});

		/**
		 * Name 添加菜单选项
		 * Param title 名称
		 * Param href 链接
		 * Param iconCls 图标样式
		 * Param iframe 链接跳转方式（true为iframe，false为href）
		 */
		function addTab(title, href, iconCls, iframe) {
			var tabPanel = $('#wu-tabs');
			if (!tabPanel.tabs('exists', title)) {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'
						+ href + '" style="width:100%;height:100%;"></iframe>';
				if (iframe) {
					tabPanel.tabs('add', {
						title : title,
						content : content,
						iconCls : iconCls,
						fit : true,
						cls : 'pd3',
						closable : true
					});
				} else {
					tabPanel.tabs('add', {
						title : title,
						href : href,
						iconCls : iconCls,
						fit : true,
						cls : 'pd3',
						closable : true
					});
				}
			} else {
				tabPanel.tabs('select', title);
			}
		}
		/**
		 * Name 移除菜单选项
		 */
		function removeTab() {
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab) {
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
		//关闭所有的tab  
		function closeAll() {
			var tiles = new Array();
			var tabs = $('#wu-tabs').tabs('tabs');
			var len = tabs.length;
			if (len > 0) {
				for (var j = 0; j < len; j++) {
					var a = tabs[j].panel('options').title;
					tiles.push(a);
				}
				for (var i = 1; i < tiles.length; i++) {
					$('#wu-tabs').tabs('close', tiles[i]);
				}
			}
		}
	</script>
</body>
</html>
