<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Đăng Ký Tài Khoản</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ categories }">
						<li><a href='<c:url value="/san-pham/loai${ item.id }"/>'><span
								class="icon-circle-blank"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>
				</ul>
			</div>
			<a class="shopBtn btn-block" href="#">Upcoming products <br></a>
			<br> <br>
			<c:forEach var="item" items="${ upcomingproduct }" varStatus="loop">
				<ul class="nav nav-list promowrapper">
					<li>
						<div class="thumbnail">
							<a class="zoomTool"
								href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
								title="add to cart"><span class="icon-search"></span> QUICK
								VIEW</a> <img src="<c:url value="${ item.img }"/>"
								alt="bootstrap ecommerce templates">
							<div class="caption">
								<h4>
									<a class="defaultBtn"
										href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>">VIEW</a>
									<span class="pull-right">$22.00</span>
								</h4>
							</div>
						</div>
					</li>
					<li style="border: 0">&nbsp;</li>
				</ul>
			</c:forEach>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
			<li><a href="<c:url value="/"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Đăng Nhập/Đăng Ký</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Đăng Ký Tài Khoản</h5>
						<br />
						<form:form action="dang-ky" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input type="email" class="span3"
										placeholder="Nhập địa chỉ Email" path="email" />

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật Khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="Nhập mật khẩu" path="password" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Họ và Tên</label>
								<div class="controls">
									<form:input type="text" class="span3"
										placeholder="Nhập họ và tên" path="name" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Số Điện
									Thoại</label>
								<div class="controls">
									<form:input type="text" class="span3"
										placeholder="Nhập địa chỉ" path="phone" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="defaultBtn">Đăng Ký</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Đăng Nhập</h5>
						<form:form action="dang-nhap" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Tên Đăng
									Nhập</label>
								<div class="controls">
									<form:input type="email" class="span3"
										placeholder="Nhập địa chỉ Email" path="username" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									Khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="Nhập mật khẩu" path="password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng Nhập</button>
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>