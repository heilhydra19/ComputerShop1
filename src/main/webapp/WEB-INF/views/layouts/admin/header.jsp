<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
    text-align: center;
}
</style>
<header id="header">

	<div class="row">
		<div class="aligncenter">
			<h1>
				<a class="logo" href="index.html"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png" />"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<li class="active"><a href="index.html">Sản Phẩm </a></li>
					<li class=""><a href="index.html">Hãng  </a></li>
					<li class=""><a href="index.html">Loại </a></li>
					<li class=""><a href="index.html">Nhập Hàng </a></li>
					<li class=""><a href="index.html">Hóa Đơn </a></li>
				</ul>
				<form action="#" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="search-query span2">
				</form>
				<ul class="nav pull-right">
					<li class=""><a href="index.html">Đăng Xuất </a></li>
				</ul>
				
			</div>
		</div>
	</div>
</div>