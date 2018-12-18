<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<jsp:include page="/WEB-INF/staticfile.jsp"></jsp:include>
<style>
body {
	margin: 10px;
}

.demo-carousel {
	height: 200px;
	line-height: 200px;
	text-align: center;
}

.w-auto {
	width: auto;
}

#paibaidialog {
	display: none;
	padding: 10px;
}

#paibaidialog {
	display: none;
	padding: 10px;
}

.layui-form-label {
	width: auto;
}

.subbtn {
	float: right;
	margin-right: 50px;
	margin-top: 5px;
	margin-bottom: 5px;
}
#datatable1{
width:auto;
}
</style>
</head>
<body>
	<div class="layui-btn-group demoTable" style="display: none">
		<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
		<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
		<button class="layui-btn" data-type="isAll">验证是否全选</button>
	</div>
	<form method="get" class="layui-form" id="searchform">
		<div class="layui-form-item">
			<div class="layui-inline">
				<span class="layui-form-label">姓名</span>
				<div class="layui-input-inline">
					<input class="layui-input" type="text" name="peopleName" value="">
				</div>
			</div>

			<div class="layui-inline">
				<span class="layui-form-label">日期</span>
				<div class="layui-input-inline">
					<input class="layui-input" type="text" name="startdate"
						id="startdate" value="">
				</div>
				<span class="layui-form-label w-auto">-</span>
				<div class="layui-input-inline">
					<input class="layui-input" type="text" name="enddate" id="enddate"
						value="">
				</div>
			</div>

			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="button" class="layui-btn" lay-submit="" value="查询"
						onclick="loaddata()" />
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="button" class="layui-btn" value="排班"
						onclick="showpaibaidialog()" />
				</div>
			</div>
		</div>
	</form>
	<table class="" lay-data="" id="datatable1">
	</table>


	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		var datatable;
// 		layui
// 				.use(
// 						'table',
// 						function() {
// 							var table = layui.table;
// 							datatable = table;
// 							//监听表格复选框选择
// 							table.on('checkbox(demo)', function(obj) {
// 								console.log(obj)
// 							});
// 							//监听工具条
// 							table.on('tool(demo)', function(obj) {
// 								var data = obj.data;
// 								if (obj.event === 'detail') {
// 									layer.msg('ID：' + data.id + ' 的查看操作');
// 								} else if (obj.event === 'del') {
// 									layer.confirm('真的删除行么', function(index) {
// 										obj.del();
// 										layer.close(index);
// 									});
// 								} else if (obj.event === 'edit') {
// 									layer.alert('编辑行：<br>'
// 											+ JSON.stringify(data))
// 								}
// 							});

// 							var $ = layui.$, active = {
// 								getCheckData : function() { //获取选中数据
// 									var checkStatus = table
// 											.checkStatus('idTest'), data = checkStatus.data;
// 									layer.alert(JSON.stringify(data));
// 								},
// 								getCheckLength : function() { //获取选中数目
// 									var checkStatus = table
// 											.checkStatus('idTest'), data = checkStatus.data;
// 									layer.msg('选中了：' + data.length + ' 个');
// 								},
// 								isAll : function() { //验证是否全选
// 									var checkStatus = table
// 											.checkStatus('idTest');
// 									layer.msg(checkStatus.isAll ? '全选' : '未全选')
// 								}
// 							};

// 							$('.demoTable .layui-btn').on('click', function() {
// 								var type = $(this).data('type');
// 								active[type] ? active[type].call(this) : '';
// 							});
// 						});

		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#startdate' //指定元素
					,type: 'month'
			});//执行一个laydate实例
			laydate.render({
				elem : '#enddate' //指定元素
					,type: 'month'
			});
			laydate.render({
				elem : '#selectmonth' //指定元素
				,type: 'month'
			});
		});
var paibaidialogindex;
		function showpaibaidialog() {
			layui.use('layer', function() {
				paibaidialogindex=layer.open({
					type : 1,
					content : $('#paibaidialog')
				//这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
				});
			});
		}
		function poststartpaiban(btn) {

			$(btn).attr("disable", true);
			$.ajax({
				url : "api/paiban/startpaiban",
				type : "get",
				data : $("#paibaidialog form").serialize(),
				success : function(data) {
					//layer.msg(data);
					if(data.code==0||data.code==200){
						layer.close(paibaidialogindex);
							layer.msg("操作成功");
							loaddata();
					}else{
					   layer.msg(data.msg);
					}
				},
				error : function() {
					layer.msg("系统错误");
				},
				complete : function() {
					$(btn).removeAttr("disable");
				}
			})
		}
		function loaddata() {

			layui.use('table', function() {
				var table = layui.table;
					  
					  //展示已知数据
					  table.render({
					    elem: '#datatable1',
					    url:'<%=request.getContextPath()%>/api/paiban/getlist'
					    ,cols: [[ //标题栏
					    	{
								field : 'id',
								width : 80,
								sort : true,
								title : "ID"
							}
								 , {
								field : 'peopleName',
								width : 80,
								title : "姓名"
							}, {
								field : 'date',
								width : 180,
								sort : true,
								title : "日期"
							}, {
								field : 'remark',
								width : "",
								sort : true,
								title : "备注"
							} 
					    ]]
					    //,data: data1.data
					    //,skin: 'line' //表格风格
					    ,even: true
					    ,page: true //是否显示分页
					    //,limits: [5, 7, 10]
					    ,limit: 30 //每页默认显示的数量
					    ,where:util.getformDataToJson("#searchform")
					  });

				}); //重载表格
		}
		$(function() {
			loaddata();
		});
		
	</script>
	<div id="paibaidialog">
		<form method="post" class="layui-form">
			<div class="layui-form-item">
				<div class="layui-inline">
					<span class="layui-form-label">日期</span>

					<div class="layui-input-inline">
						<input class="layui-input" type="text" name="selectmonth"
							id="selectmonth" value="">
					</div>
				</div>
				<div class="layui-input-block">
					<input type="button" class="layui-btn subbtn" lay-submit=""
						value="开始排班" onclick="poststartpaiban()" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>