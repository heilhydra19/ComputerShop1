<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Người Dùng</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter"
				action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/search"
				class="navbar-search pull-left" method="POST">
				<input type="text" placeholder="Search" class="search-query span2"
					name="keyword">
			</form>
			<div class="well well-small">
				<form:form
					action="${pageContext.request.contextPath}/quan-tri/nguoi-dung/addorupdate"
					method="POST" modelAttribute="user">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên người dùng</th>
								<th>Hình ảnh</th>
								<th>Điện Thoại</th>
								<th>Email</th>
								<th>Quyền</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập tên người dùng"
										style="max-width: 250px" path="name" /></td>
								<td><form:input type="text" placeholder="Hình ảnh"
										style="max-width: 150px" path="img" /></td>
								<td><form:input type="text" placeholder="Điện Thoại"
										style="max-width: 100px" path="phone" /></td>
								<td><form:input type="email" placeholder="Email"
										style="max-width: 150px" path="email" /></td>
								<td><form:select name="id_role" path="id_role"
										style="max-width: 70px">
										<c:forEach var="item" items="${ roles }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
						</tbody>
					</table>
					<hr class="soften" />
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên Đăng Nhập</th>
								<th>Mật Khẩu</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập Đăng Nhập"
										style="max-width: 400px" path="username" /></td>
								<td><form:input type="text" placeholder="Nhập Mật Khẩu"
										style="max-width: 400px" path="password" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm Tài
							Khoản</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 130px">
							<c:forEach var="item" items="${ usersPaginate }">
								<form:option value="${ item.id_user }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Tài Khoản</button>
					</div>
				</form:form>
				<hr class="soften" />
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên người dùng</th>
							<th>Hình ảnh</th>
							<th>Điện Thoại</th>
							<th>Email</th>
							<th>Tên Đăng Nhập</th>
							<th>Quyền</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ usersPaginate.size() > 0 }">
							<c:forEach var="item" items="${ usersPaginate }">
								<tr>
									<td>${ item.id }</td>
									<td>${ item.name }</td>
									<td><img width="60" src="<c:url value="${ item.img }"/>"
										alt=""></td>
									<td>${ item.phone }</td>
									<td>${ item.email }</td>
									<td>${ item.username }</td>
									<td>${ item.role_name }</td>
									<td><a
										href="<c:url value="/quan-tri/nguoi-dung/deleteAccount/${ item.id }"/>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>
									<c:if
										test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == usersPaginate.size() }">
								</tr>
								<c:if test="${ (loop.index + 1) < usersPaginate.size() }">

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
						href="<c:url value="/quan-tri/nguoi-dung/search/${ keyword }/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a
						href="<c:url value="/quan-tri/nguoi-dung/search/${ keyword }/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${ empty keyword }">
		<div class="pagination">
			<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${ (loop.index) == paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/nguoi-dung/${ loop.index }"/>"
						class="active">${ loop.index }</a>
				</c:if>
				<c:if test="${ (loop.index) != paginateInfo.currentPage }">
					<a href="<c:url value="/quan-tri/nguoi-dung/${ loop.index }"/>">${ loop.index }</a>
				</c:if>
			</c:forEach>
		</div>
	</c:if>
</body>