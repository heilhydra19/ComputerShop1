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
			<div class="well well-small">
				<form:form action="hoa-don" method="POST" modelAttribute="bill">
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
											<form:option value="${ item.id }">${ item.name }</form:option>
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
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						Số hóa đơn Cần Sửa&emsp;<form:select name="id" path="id"
										style="max-width: 170px">
										<c:forEach var="item" items="${ bills }">
											<form:option value="${ item.id }">${ item.id }</form:option>
										</c:forEach>
									</form:select>&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Hoá Đơn</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="delete" class="shopBtn">Xóa
							Hoá Đơn</button>
					</div>
				</form:form>
			</div>

			<hr class="soften" />
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Tên User</th>
						<th>Địa Chỉ</th>
						<th>Ngày lập</th>
						<th>Chi Tiết</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ bills }">
						<tr>
							<td>${ item.id }</td>
							<td>${ item.user }</td>
							<td>${ item.address }</td>
							<td>${ item.created_at }</td>
							<td><a class="btn btn-mini pull-right" href="<c:url value="hoa-don/${ item.id }"/>">Xem thêm
									<span class="icon-plus"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>