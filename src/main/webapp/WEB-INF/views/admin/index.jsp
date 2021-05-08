<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Quản Lý</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<div class="well well-small">

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Sản Phẩm</th>
							<th>Hình Ảnh</th>
							<th>Loại</th>
							<th>Hãng</th>
							<th>Đơn Giá</th>
							<th>Chi Tiết</th>
						</tr>
					</thead>
					<tbody>
						<form:form action="AddSave" method="POST" modelAttribute="product">
							<tr>
								<td><form:input type="text" class="span3" placeholder="Nhập tên sp" path="name"/></td>
								<!--  <td><img width="60"
									src="<c:url value="/assets/user/img/${ item.url_img }"/>"
									alt=""></td>
								<td>${ item.category }</td>
								<td>${ item.brand }</td>
								<td>${ item.price }</td>
								<td><input style="max-width: 360px" size="16" type="text"
									value="${ item.detail }"></td>-->
							</tr>
						</form:form>
					</tbody>
				</table>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Mã</th>
							<th>Sản Phẩm</th>
							<th>Hình Ảnh</th>
							<th>Loại</th>
							<th>Hãng</th>
							<th>Số Lượng</th>
							<th>Đơn Giá</th>
							<th>Chi Tiết</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ products }">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.name }</td>
								<td><img width="60"
									src="<c:url value="/${ item.url_img }"/>"
									alt=""></td>
								<td>${ item.category }</td>
								<td>${ item.brand }</td>
								<td>${ item.amount }</td>
								<td>${ item.price }</td>
								<td><input style="max-width: 360px" size="16" type="text"
									value="${ item.detail }"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="products.html" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Tiếp tục mua sắm </a> <a
					href="<c:url value="/checkout"/>"
					class="shopBtn btn-large pull-right">Thanh Toán <span
					class="icon-arrow-right"></span></a>

			</div>
		</div>
	</div>
	<!--  <content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" + id).val();
			window.location = "EditCart/" + id + "/" + quanty;
		});
	</script></content>-->
</body>