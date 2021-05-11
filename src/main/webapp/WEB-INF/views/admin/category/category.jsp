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
	<div class="row">
		<div class="span12">
			<form class="aligncenter" action="#" class="navbar-search pull-left">
				<input type="text" placeholder="Search" class="search-query span2">
			</form>
			<div class="well well-small">
				<form:form action="loai" method="POST" modelAttribute="category">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Loại</th>
								<th>Mô tả</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id"
										style="max-width: 100px">
										<c:forEach var="item" items="${ categories }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
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
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Loại</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="delete" class="shopBtn">Xóa
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ categories }">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.name }</td>
								<td><input style="max-width: 300px" size="16" type="text"
									value="${ item.description }"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>