<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Quản Lý</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/san-pham/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/san-pham/addorupdate"
					method="POST" modelAttribute="product">
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
								<td><form:input placeholder="Nhập tên sp"
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
										style="max-width: 130px" path="price" /></td>
								<td><form:input type="text" placeholder="Chi Tiết SP"
										style="max-width: 140px" path="detail" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" value="" class="shopBtn">Thêm
							Sản Phẩm</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 130px">
							<c:forEach var="item" items="${ productsPaginate }">
								<form:option value="${ item.id }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Sản Phẩm</button>
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
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ productsPaginate.size() > 0 }">
							<c:forEach var="item" items="${ productsPaginate }">
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
									<td><a
										href="<c:url value="/quan-tri/san-pham/delete/${ item.id }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>
									<c:if
										test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == productsPaginate.size() }">
								</tr>
								<c:if test="${ (loop.index + 1) < productsPaginate.size() }">

								</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div><c:if test="${ not empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/san-pham/search/${ keyword }/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/san-pham/search/${ keyword }/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${ empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/san-pham/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/san-pham/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
</body>