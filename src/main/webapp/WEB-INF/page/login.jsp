<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<jsp:include page="/WEB-INF/staticfile.jsp"></jsp:include>
<style type="text/css">
fieldset {
	width: 400px;
	margin: 0 auto;	
	position: absolute;
	top:30%;
	left:40%;
	text-align: left;
}

html,body{height:100%} 
body {
	/*display: table-cell;*/
	vertical-align: middle;
	text-align: center;
/* 	 background-color: #ccc; */
	 height: 100%;
	 width:100%;
	 position: relative;
}
</style>
</head>
<body>
	<fieldset>
		<lengd>登陆</lengd>
		<form class="layui-form" method="post" action="login">

			<div class="layui-form-item">
				<span class="layui-form-label">用户名</span>
				<div class="layui-input-block">
					<input class="layui-input" type="text" name="username"
						value="admin">
				</div>
			</div>
			<div class="layui-form-item">
				<span class="layui-form-label">密码</span>
				<div class="layui-input-block">
					<input class="layui-input" type="text" name="password"
						value="admin">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="button" class="layui-btn" lay-submit="" value="登录" onclick="loginAjax()" />
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					
<!-- 					<input type="button" class="layui-btn" lay-submit="" value="登录test" onclick="logintest()" /> -->
				</div>
			</div>
		</form>
	</fieldset>
	<script>
		var msg = '${msg}';

		var success = '${success}';
		if (msg) {
			layui.use('layer', function() {

				layer.msg(msg);
				if (success) {
					setTimeout(function(){
						location.href = "home";
					}, 100);
				}
			});
		}
		function loginAjax(){
			var param={username : $("input[name=username]").val(),
			        password : $("input[name=password]").val()};
			$.ajax({ 
		        type: "post", 
		        url: "<%=request.getContextPath()%>" + "/loginAjax", 
		        data: param, 
		        dataType: "json", 
		        success: function(data) { 
		        	//console.log(data);
		        	//return;
		        	layui.use('layer', function() { 
		        		layer.msg(data.msg);
		        	});
		            if(data.code == 0){
		                //登录成功
		                window.location.href = "home";
		            }
		        },
		        error: function(data) { 
		            alert("调用失败...."); 
		        }
		    });
		}
		function logintest(){
			var param={username : $("input[name=username]").val(),
			        password : $("input[name=password]").val()};
			$.ajax({ 
		        type: "post", 
		        url: "<%=request.getContextPath()%>" + "/checkLogin.json", 
		        data: param, 
		        dataType: "json", 
		        success: function(data) { 
		        	//console.log(data);
		        	//return;
		            if(data.success == false){
		                alert(data.errorMsg);
		            }else{
		                //登录成功
		                window.location.href = "<%=request.getContextPath()%>" +  "/loginsuccess.jhtml";
		            }
		        },
		        error: function(data) { 
		            alert("调用失败...."); 
		        }
		    });
		}
	</script>
</body>
</html>