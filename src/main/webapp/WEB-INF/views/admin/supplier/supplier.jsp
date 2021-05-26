<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Nhà Cung Cấp</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/nha-cung-cap/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/nha-cung-cap/addorupdate"
					method="POST" modelAttribute="supplier">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên nhà cung cấp</th>
								<th>Hình ảnh</th>
								<th>Điện Thoại</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập tên nhà cung cấp"
										style="max-width: 250px" path="name" /></td>
								<td><form:input type="text" placeholder="Hình ảnh"
										style="max-width: 150px" path="img" /></td>
								<td><form:input type="text" placeholder="Điện Thoại"
										style="max-width: 100px" path="phone" /></td>
								<td><form:input type="email" placeholder="Email"
										style="max-width: 150px" path="email" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm Nhà
							Cung Cấp</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 130px">
							<c:forEach var="item" items="${ suppliersPaginate }">
								<form:option value="${ item.id }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Nhà Cung Cấp</button>
					</div>
				</form:form>
				<hr class="soften" />
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên nhà cung cấp</th>
							<th>Hình ảnh</th>
							<th>Điện Thoại</th>
							<th>Email</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ suppliersPaginate.size() > 0 }">
							<c:forEach var="item" items="${ suppliersPaginate }">
								<tr>
									<td>${ item.id }</td>
									<td>${ item.name }</td>
									<td><img width="60" src="<c:url value="${ item.img }"/>"
										alt=""></td>
									<td>${ item.phone }</td>
									<td>${ item.email }</td>
									<td><a
										href="<c:url value="/quan-tri/nha-cung-cap/delete/${ item.id }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>
									<c:if
										test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == suppliersPaginate.size() }">
								</tr>
								<c:if test="${ (loop.index + 1) < suppliersPaginate.size() }">

								</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="pagination">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage }">
				<a href="<c:url value="/quan-tri/nha-cung-cap/${ loop.index }"/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<a href="<c:url value="/quan-tri/nha-cung-cap/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div>
</body>