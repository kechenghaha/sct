<%@page contentType="text/html; charset=utf-8" %>
<% 
   String path = request.getContextPath(); 
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增</title>
		<link rel="stylesheet" href="<%=basePath%>static/css/styles.css" />
		<link rel="stylesheet" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="<%=basePath%>static/js/jquery-3.4.1.min.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="add">
			<table class="tableadd" style="width: 30%;">
				<tr>
					<td>用户名</td>
					<td><input type="text"></td>
					<td>用户名</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text"></td>
					<td>用户名</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<button class="edit">
							<i class="fa fa-arrow-left"></i>
							返回
						</button>
						<button class="remove">
							<i class="fa fa-save"></i>
							提交
						</button>
					</td>
				</tr>
				
			</table>
			
		</div>
	</body>
</html>
