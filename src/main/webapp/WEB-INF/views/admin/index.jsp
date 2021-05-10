<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
</head>
<body>
	<div class="well aligncenter">
		<h5>Đăng Nhập</h5>
		<form:form action="quan-ly" method="POST" modelAttribute="account">
			<div class="control-group">
				<label class="control-label" for="inputEmail">Tên đăng nhập</label>
				<div class="controls">
					<form:input type="text" class="span3" placeholder="Username"
						path="username" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">Mật khẩu</label>
				<div class="controls">
					<form:input type="password" class="span3" placeholder="Password"
						path="password" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="defaultBtn">Đăng Nhập</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
