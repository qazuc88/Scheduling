<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title></title>
<jsp:include page="/WEB-INF/staticfile.jsp"></jsp:include>
<style>
html, body {
	height: 100%
}

body {
	margin: 10px;
}

.demo-carousel {
	height: 200px;
	line-height: 200px;
	text-align: center;
}

#talbe {
	width: 100%;
	height: 100%;
	/* 	background-color: #ccc; */
}

* {
	/* 	border: solid 1px red; */
	
}

.layui-nav {
	text-align: left;
}

#navleft {
	width: 200px;
	margin-top: 5px;
	vertical-align: top;
}

#logo {
	width: 200px;
	font-size: 30px;
	font-weight: bolder;
	padding-left: 50px;
	background: url(<%=kye.Config.SiteRoot%>/content/img/logo.png)
		no-repeat;
	background-position: 10px center;
	background-size: 30px 30px;
	height: 100%;
	line-height: 60px;
}

#main {
	width: 100%;
	height: 100%;
	border: 0px;
}

.fr {
	float: right;
}

.fl {
	float: left;
}

.menu {
	background-color: #393D49;
	height: 60px;
	color: #fff;
}
</style>
</head>
<body>
	<div class="menu">
		<div>
			<ul class="layui-nav layui-bg-black fr">
				<li class="layui-nav-item">
					<%-- 					<% (ShiroUser) SecurityUtils.getSubject().getPrincipal();  String username = user.username; %> --%>
					<%-- 					<%=username %> --%> <a href="logout">hi,${username} 退出登录</a>
				</li>
				<li class="layui-nav-item"><a href="javascript:;">系统设置</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">权限管理</a>
						</dd>
					</dl></li>
			</ul>
		</div>
		<div class="fl" id="logo">自动排班系统</div>
	</div>
	<table id="talbe">
		<tr>
			<td class="layui-bg-black" id="navleft"><ul
					class="layui-nav layui-nav-tree layui-inline layui-bg-black"
					lay-filter="demo" style="margin-right: 10px;">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">值日排班</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="paibanlist" target="main">排班查看</a>
							</dd>
							<dd>
								<a href="people/list" target="main">值日人员</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">用户设置</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="login/updateinfo" target="main">密码修改</a>
							</dd>
						</dl></li>
				</ul></td>
			<td></td>

			<td style="height: 100%; width: 100%"><iframe id="main"
					name="main" src="<%=kye.Config.SiteRoot%>/paibanlist"> </iframe></td>
		</tr>
	</table>
	<script>
		layui.use('element', function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

			//监听导航点击
			element.on('nav(demo)', function(elem) {
				//console.log(elem)
				//layer.msg(elem.text());
			});
		});
	</script>
</body>
</html>