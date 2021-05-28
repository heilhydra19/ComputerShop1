<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Sản - phẩm</title>
</head>
<body>
	<div class="well well-small">
		<ul class="breadcrumb">
			<li><a href="<c:url value="/"/>">Trang chủ</a> <span class="divider">/</span></li>
			<li><a href="<c:url value="/san-pham"/>">Danh sách sản phẩm</a></li>
		</ul>

		<c:if test="${ productsPaginate.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">

					<c:forEach var="item" items="${ productsPaginate }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>" class="overlay"></a> <a
									class="zoomTool"
									href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a
									href="<c:url value="/chi-tiet-san-pham/${ item.id }"/>"><img
									src="<c:url value="/assets/user/img/${ item.img }"/>" alt=""></a>
								<div class="caption cntr">
									<p>${ item.name }</p>
									<p>
										<strong> <fmt:formatNumber type="number"
												groupingUsed="true" value="${ item.price }" /> ₫
										</strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/AddCart/${ item.id }"/>" title="add to cart"> Add to
											cart </a>
									</h4>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == productsPaginate.size() }">
				</ul>
			</div>
			<c:if test="${ (loop.index + 1) < productsPaginate.size() }">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>
	</div>
	<div class="pagination">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${ loop.index }"/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div>

</body>