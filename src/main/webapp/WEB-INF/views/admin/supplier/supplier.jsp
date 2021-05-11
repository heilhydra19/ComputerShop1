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
			<form class="aligncenter" action="#" class="navbar-search pull-left">
				<input type="text" placeholder="Search" class="search-query span2">
			</form>
			<div class="well well-small">
				<form:form action="nha-cung-cap" method="POST" modelAttribute="supplier">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên nhà cung cấp</th>
								<th>Hình ảnh</th>
								<th>Điện Thoại</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id"
										style="max-width: 70px">
										<c:forEach var="item" items="${ suppliers }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
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
						<button type="submit" name="add" class="shopBtn">Thêm
							Nhà Cung Cấp</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Nhà Cung Cấp</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="delete" class="shopBtn">Xóa
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ suppliers }">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.name }</td>
								<td><img width="60" src="<c:url value="${ item.img }"/>"
									alt=""></td>
								<td>${ item.phone }</td>
								<td>${ item.email }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>