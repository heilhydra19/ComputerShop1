<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Hãng Sản Xuất</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/hang/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/hang/addorupdate"
					method="POST" modelAttribute="brand">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên Hãng</th>
								<th>Mô tả</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập tên hãng"
										style="max-width: 200px" path="name" /></td>
								<td><form:input type="text" placeholder="Mô tả"
										style="max-width: 300px" path="description" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm
							Hãng</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 130px">
							<c:forEach var="item" items="${ brandsPaginate }">
								<form:option value="${ item.id }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Hãng</button>
					</div>
				</form:form>
				<hr class="soften" />
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Mã</th>
							<th>Tên Hãng</th>
							<th>Chi Tiết</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ brandsPaginate.size() > 0 }">
							<c:forEach var="item" items="${ brandsPaginate }">
								<tr>
									<td>${ item.id }</td>
									<td>${ item.name }</td>
									<td><input style="max-width: 300px" size="16" type="text"
										value="${ item.description }"></td>
									<td><a
										href="<c:url value="/quan-tri/hang/delete/${ item.id }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>
									<c:if
										test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == brandsPaginate.size() }">
								</tr>
								<c:if test="${ (loop.index + 1) < brandsPaginate.size() }">

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
						href="<c:url value="/quan-tri/hang/search/${ keyword }/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/hang/search/${ keyword }/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${ empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/hang/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/hang/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
</body>