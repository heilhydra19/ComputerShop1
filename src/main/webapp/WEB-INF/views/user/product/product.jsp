<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
.product-content {
	overflow-x: hidden;
}
</style>
</head>
<body>
	<!-- 
Body Section 
-->
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
				<li><a href="<c:url value="/"/>">Trang chủ</a> <span
					class="divider">/</span></li>
				<li><a href="<c:url value="/san-pham"/>">Danh sách sản phẩm</a>
					<span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/${ product.img }"/>"
										alt="" style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${ product.name }</h3>
						<hr class="soft" />
						<p>Loại Linh Kiện: ${ product.category }</p>
						<p>Hãng: ${ product.brand }</p>

						<form class="form-horizontal qtyFrm" method="get"
							action="<c:url value="/AddCart/${ product.id }"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true" value="${ product.price }" />₫</span></label>
							</div>
							<button type="submit" class="shopBtn">
								<span class=" icon-shopping-cart"></span> Thêm giỏ hàng
							</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Chi
							tiết sản phẩm</a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">${ product.detail }
					</div>
					<div class="tab-pane fade" id="profile">

						<c:set var="countList" value="${ productByIDCategory.size() }" />
						<c:if test="${ productByIdCategory.size() > 6 }">
							<c:set var="countList" value="6" />
						</c:if>

						<c:forEach var="item" items="${ productByIdCategory }" begin="1"
							end="${ countList }" varStatus="loop">
							<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/${ item.img }"/>"
										alt="">
								</div>
								<div class="span6">
									<h5>${ item.name }</h5>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${ product.price }" />
											₫
										</h3>
										<div class="btn-group">
											<a href="product_details.html" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Add to cart</a> <a
												href="product_details.html" class="shopBtn">VIEW</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft" />
						</c:forEach>

					</div>

				</div>

			</div>
		</div>
	</div>

</body>