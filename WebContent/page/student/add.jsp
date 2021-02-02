<%@page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增</title>
		<link rel="stylesheet" href="<%=basePath%>static/css/styles.css" />
		<link rel="stylesheet" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="<%=basePath%>static/js/jquery-3.4.1.min.js"type="text/javascript"></script>
		<script src="<%=basePath%>static/js/jquery-validation-1.19.3/jquery.validate.js"></script>
		<script src="<%=basePath%>static/js/jquery-validation-1.19.3/localization/messages_zh.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#addForm").validate({
					rules:{
						stuNo:{
							required:true,
							digits:true
						},
						stuName:"required",
						pwd:{
							required:true,
							minlength:6,
							maxlength:15
						}
					},
					messages:{
						/* stuNo:"学号不能为空",
						stuName:"姓名不能为空",
						pwd:"密码不能为空" */
					}
				});
			});	
		</script>
	</head>
<body>
	<div class="add">
		<form id="addForm" action="<%=basePath%>student?method=add" method="post">
			<table class="tableadd" style="width: 50%;">
				<tr>
					<td>学号</td>
					<td style="color: red;"><input type="text" name="stuNo" autocomplete="off"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td style="color: red;"><input type="text" name="stuName" autocomplete="off"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td style="color: red;"><input type="password" name="pwd" value="123456">	初始密码为123456</td>
				</tr>
				<tr>
					<td colspan="4" align="left">
						<button class="edit" type="button" onclick="window.history.go(-1)">
							<i class="fa fa-arrow-left"></i> 返回
						</button>
						<button class="submit" type="submit">
							<i class="fa fa-save"></i> 提交
						</button>
					</td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>