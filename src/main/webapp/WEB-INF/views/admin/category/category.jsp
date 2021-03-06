<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Loại Sản Phẩm</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<c:remove var="url" />
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/loai/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
				
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/loai/addorupdate"
					method="POST" modelAttribute="category">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên Loại</th>
								<th>Mô tả</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập tên loại"
										style="max-width: 200px" path="name" /></td>
								<td><form:input type="text" placeholder="Mô tả"
										style="max-width: 300px" path="description" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm
							Loại</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 130px">
							<c:forEach var="item" items="${ categoriesPaginate }">
								<form:option value="${ item.id }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Loại</button>
					</div>
				</form:form>
				<hr class="soften" />
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Mã</th>
							<th>Tên Loại</th>
							<th>Chi Tiết</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ categoriesPaginate.size() > 0 }">
							<c:forEach var="item" items="${ categoriesPaginate }">
								<tr>
									<td>${ item.id }</td>
									<td>${ item.name }</td>
									<td><input style="max-width: 300px" size="16" type="text"
										value="${ item.description }"></td>
									<td><a
										href="<c:url value="/quan-tri/loai/delete/${ item.id }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>
									<c:if
										test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == categoriesPaginate.size() }">
								</tr>
								<c:if test="${ (loop.index + 1) < categoriesPaginate.size() }">

								</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<c:if test="${ not empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/loai/search/${ keyword }/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/loai/search/${ keyword }/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${ empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/loai/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/loai/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
</body>