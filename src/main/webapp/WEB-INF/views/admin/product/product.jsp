<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Quản Lý</title>
</head>
<body>
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
						<li class=""><a href="index.html">Hãng </a></li>
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
	<div class="row">
		<div class="span12">
			<div class="well well-small">
				<form:form action="quan-ly" method="POST" modelAttribute="product">
					<table class="table table-bordered table-condensed">
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
							<tr>
								<td><form:input type="text" placeholder="Nhập tên sp"
										style="max-width: 170px" path="name" /></td>
								<td><form:input type="text" placeholder="Nhập link"
										style="max-width: 100px" path="img" /></td>
								<td><form:select name="categories" path="id_category"
										style="max-width: 100px">
										<c:forEach var="item" items="${ categories }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
								<td><form:select name="brands" path="id_brand"
										style="max-width: 100px">
										<c:forEach var="item" items="${ brands }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
								<td><form:input type="text" placeholder="Giá Bán"
										style="max-width: 140px" path="price" /></td>
								<td><form:input type="text" placeholder="Chi Tiết SP"
										style="max-width: 150px" path="detail" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						<button type="submit" class="shopBtn">Thêm Sản Phẩm</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" class="shopBtn">Sửa Sản Phẩm</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" class="shopBtn">Xóa Sản Phẩm</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;
					</div>
				</form:form>
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
								<td><img width="60" src="<c:url value="${ item.img }"/>"
									alt=""></td>
								<td>${ item.category }</td>
								<td>${ item.brand }</td>
								<td>${ item.amount }</td>
								<td>${ item.price }</td>
								<td><input style="max-width: 100px" size="16" type="text"
									value="${ item.detail }"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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