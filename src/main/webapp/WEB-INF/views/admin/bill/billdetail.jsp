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
				<form:form action="${ id }/addorupdate" method="POST"
					modelAttribute="billDetail">
					Mã Hóa Đơn&emsp;<form:input path="id_bill" value="${ id }"
						style="max-width: 150px" />
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Sản Phẩm</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id_product"
										style="max-width: 170px">
										<c:forEach var="item" items="${ products }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
								<td><form:input placeholder="Số Lượng"
										style="max-width: 300px" path="amount" /></td>
								<td><form:input placeholder="Đơn Giá"
										style="max-width: 300px" path="price" /></td>
							</tr>
						</tbody>
					</table>
					<div class="controls">
						&emsp;&emsp;
						<button type="submit" name="add" class="shopBtn">Thêm</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Dòng Cần Tương Tác&emsp;
						<form:select name="id" path="id" style="max-width: 170px">
							<c:forEach var="item" items="${ billDetails }">
								<form:option value="${ item.id }">${ item.product }</form:option>
							</c:forEach>
						</form:select>
						&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa</button>
					</div>
				</form:form>
			</div>

			<hr class="soften" />
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã Sản Phẩm</th>
						<th>Tên Sản Phẩm</th>
						<th>Số Lượng</th>
						<th>Đơn Giá</th>
						<th>Thành Tiền</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${ billDetails }">
						<tr>
							<td>${ item.id_product }</td>
							<td>${ item.product }</td>
							<td>${ item.amount }</td>
							<td>${ item.price }</td>
							<td>${ item.price * item.amount}</td>
							<td><a href="<c:url value="${ id }/delete/${ item.id }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
									class="icon-remove"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pull-right">Tổng Tiền: ${ totalPrice }</div>
		</div>
	</div>
</body>