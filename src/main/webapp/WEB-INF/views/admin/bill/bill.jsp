<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Hóa - đơn</title>

</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/hoa-don/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/hoa-don/addorupdate"
					method="POST" modelAttribute="bill">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Khách Hàng</th>
								<th>Địa Chỉ</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id_user"
										style="max-width: 170px">
										<c:forEach var="item" items="${ users }">
											<form:option value="${ item.id_user }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
								<td><form:input placeholder="Địa Chỉ"
										style="max-width: 300px" path="address" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm Hoá
							Đơn</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Số hóa đơn Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 170px">
							<c:forEach var="item" items="${ billsPaginate }">
								<form:option value="${ item.id }">${ item.id }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Hoá Đơn</button>
					</div>
				</form:form>
			</div>

			<hr class="soften" />
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Tên Khách Hàng</th>
						<th>Địa Chỉ</th>
						<th>Ngày lập</th>
						<th>Chi Tiết</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${ billsPaginate.size() > 0 }">
						<c:forEach var="item" items="${ billsPaginate }">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.user }</td>
								<td>${ item.address }</td>
								<td>${ item.created_at }</td>
								<td><a class="btn btn-mini pull-right"
									href="<c:url value="/quan-tri/hoa-don/bill${ item.id }"/>">Xem
										thêm <span class="icon-plus"></span>
								</a></td>
								<td><a
									href="<c:url value="/quan-tri/hoa-don/delete/${ item.id }"/>"
									class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
								</a></td>
								<c:if
									test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == billsPaginate.size() }">
							</tr>
							<c:if test="${ (loop.index + 1) < billsPaginate.size() }">

							</c:if>
					</c:if>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<c:if test="${ not empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/hoa-don/search/${ keyword }/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/hoa-don/search/${ keyword }/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${ empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/hoa-don/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/hoa-don/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
</body>