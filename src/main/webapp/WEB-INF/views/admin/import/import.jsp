<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<head>
<title>Nhập - Hàng</title>

</head>
<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
	<c:redirect url="/quan-tri/"></c:redirect>
</c:if>
<body>
	<div class="row">
		<div class="span12">
			<div class="well well-small">
				<form:form action="nhap-hang/addorupdate" method="POST" modelAttribute="import">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Nhà Cung Cấp</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id_supplier"
										style="max-width: 170px">
										<c:forEach var="item" items="${ suppliers }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm Phiếu Nhập</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Số Phiếu Cần Sửa&emsp;
						<form:select name="id" path="id" style="max-width: 170px">
							<c:forEach var="item" items="${ imports }">
								<form:option value="${ item.id }">${ item.id }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Phiếu Nhập</button>
					</div>
				</form:form>
			</div>

			<hr class="soften" />
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Tên Nhà Cung Cấp</th>
						<th>Ngày lập</th>
						<th>Chi Tiết</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ imports }">
						<tr>
							<td>${ item.id }</td>
							<td>${ item.supplier }</td>
							<td>${ item.created_at }</td>
							<td><a class="btn btn-mini pull-right"
								href="<c:url value="nhap-hang/${ item.id }"/>">Xem thêm <span
									class="icon-plus"></span>
							</a></td>
							<td><a href="<c:url value="nhap-hang/delete/${ item.id }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
									class="icon-remove"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>