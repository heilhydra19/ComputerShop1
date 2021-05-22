<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Khách Hàng</title>
</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<form class="aligncenter" action="#" class="navbar-search pull-left">
				<input type="text" placeholder="Search" class="search-query span2">
			</form>
			<div class="well well-small">
				<form:form action="khach-hang/addorupdate" method="POST"
					modelAttribute="customer">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Tên khách hàng</th>
								<th>Hình ảnh</th>
								<th>Điện Thoại</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input placeholder="Nhập tên khách hàng"
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
						<button type="submit" name="add" class="shopBtn">Thêm
							Khách Hàng</button>
						&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 100px">
							<c:forEach var="item" items="${ customers }">
								<form:option value="${ item.id }">${ item.name }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Khách Hàng</button>
					</div>
				</form:form>
				<hr class="soften" />
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên khách hàng</th>
							<th>Hình ảnh</th>
							<th>Điện Thoại</th>
							<th>Email</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ customers }">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.name }</td>
								<td><img width="60" src="<c:url value="${ item.img }"/>"
									alt=""></td>
								<td>${ item.phone }</td>
								<td>${ item.email }</td>
								<td><a href="<c:url value="khach-hang/delete/${ item.id }"/>"
									class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>