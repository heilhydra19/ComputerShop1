<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Thanh Toán</title>
</head>
<c:if test="${ empty LoginInfo}">
	<c:redirect url="/dang-ky"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${ categories }">
						<li><a href='<c:url value="/san-pham/${ item.id }"/>'><span
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
				<li><a href="<c:url value="/"/>">Trang chủ</a> <span
					class="divider">/</span></li>
				<li class="active">Thanh Toán</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span9">
					<div class="well">
						<br />
						<form:form action="checkout" method="POST" modelAttribute="bills"
							class="form-horizontal">
							<h3>Thanh toán đơn hàng</h3>
							<div class="control-group">
								<div class="controls">
									<form:hidden path="id_user" value="${ loginInfo.id }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa Chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="address" rows="5" cols="30" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Thanh Toán"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>

			</div>

		</div>
	</div>
</body>