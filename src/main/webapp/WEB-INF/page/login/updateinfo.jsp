<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/staticfile.jsp"></jsp:include>
</head>
<body>

	<form class="layui-form" action="" id="form1">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-inline">
				<input type="password" name="password" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-inline">
				<input type="password" name="passwordnew" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" onclick="updateinfoajax()"
					value="保存" />
			</div>
		</div>
	</form>
	<script>
		function updateinfoajax() {
			util.ajax({
				url : "updateinfoajax",
				type : "post",
				formid: "form1",
				success : function(data) {
					util.showmsg(data.msg);
					if (data && data.code == 0) {
						//util.showmsg(data.msg);

					}
				},
				error : function() {
					util.showmsg("系统错误");
				}

			});
		}
	</script>
</body>
</html>