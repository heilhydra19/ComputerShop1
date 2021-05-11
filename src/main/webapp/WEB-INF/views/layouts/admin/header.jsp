<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<header id="header">
	<div class="row aligncenter">
		<h1>
			<img
				src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png"/>"
				alt="bootstrap sexy shop">
		</h1>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<c:if test="${ not empty LoginInfo or not empty LoginEmplInfo}">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class=""><a href="<c:url value="san-pham"/>">Sản Phẩm
						</a></li>
						<li class=""><a href="<c:url value="hang"/>">Hãng </a></li>
						<li class=""><a href="<c:url value="loai"/>">Loại </a></li>
						<li class=""><a href="<c:url value="nha-cung-cap"/>">Nhà
								CC </a></li>
						<li class=""><a href="<c:url value="nhap-hang"/>">Nhập </a></li>
						<li class=""><a href="<c:url value="hoa-don"/>">Hóa Đơn </a></li>
						<c:if test="${ not empty LoginInfo }">
							<li class=""><a href="quan-ly-nhan-vien">Nhân Viên </a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</c:if>
</div>