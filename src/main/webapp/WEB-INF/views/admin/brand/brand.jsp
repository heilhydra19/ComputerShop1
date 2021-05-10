<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<style>
.aligncenter {
	text-align: center;
}
</style>
<head>
<title>Sản Phẩm</title>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class=""><a href="<c:url value="san-pham"/>">Sản Phẩm </a></li>
						<li class=""><a href="<c:url value="hang"/>">Hãng </a></li>
						<li class=""><a href="<c:url value="loai"/>">Loại </a></li>
						<li class=""><a href="<c:url value="nha-cung-cap"/>">Nhà CC </a></li>
						<li class=""><a href="<c:url value="nhap-hang"/>">Nhập </a></li>
						<li class=""><a href="<c:url value="hoa-don"/>">Hóa Đơn </a></li>
						<c:if test="${ not empty LoginInfo }">
							<li class=""><a href="quan-ly-nhan-vien">Nhân Viên </a></li>
						</c:if>
					</ul>
					<ul class="nav pull-right">
						<c:if test="${ empty LoginInfo and empty LoginEmplInfo}">
							<c:redirect url="/quan-tri/"></c:redirect>
						</c:if>
						<c:if test="${ not empty LoginInfo }">
							<li><a href="">${ LoginInfo.name }</a></li>
							<li><a href="<c:url value="/quan-tri/"/>">Đăng Xuất </a></li>
						</c:if>
						<c:if test="${ not empty LoginEmplInfo }">
							<li><a href="">${ LoginEmplInfo.name }</a></li>
							<li><a href="<c:url value="/quan-tri/"/>">Đăng Xuất </a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<form class="aligncenter" action="#" class="navbar-search pull-left">
				<input type="text" placeholder="Search" class="search-query span2">
			</form>
			<div class="well well-small">
				<form:form action="san-pham" method="POST" modelAttribute="brand">
					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Hãng</th>
								<th>Mô tả</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:select name="id" path="id"
										style="max-width: 100px">
										<c:forEach var="item" items="${ brands }">
											<form:option value="${ item.id }">${ item.name }</form:option>
										</c:forEach>
									</form:select></td>
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
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="update" class="shopBtn">Sửa
							Hãng</button>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="delete" class="shopBtn">Xóa
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ brands }">
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