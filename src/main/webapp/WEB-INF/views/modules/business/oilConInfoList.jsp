<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同信息表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/business/oilConInfo/">合同信息表列表</a></li>
		<shiro:hasPermission name="business:oilConInfo:edit"><li><a href="${ctx}/business/oilConInfo/form">合同信息表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilConInfo" action="${ctx}/business/oilConInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品名称：</label>
				<form:input path="gname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>订单号：</label>
				<form:input path="orderNumber" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>收货地址：</label>
				<form:input path="shippingAdd" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>产品名称</th>
				<th>订单号</th>
				<th>收货地址</th>
				<th>总量</th>
				<th>更新日期</th>
				<th>备注</th>
				<shiro:hasPermission name="business:oilConInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilConInfo">
			<tr>
				<td><a href="${ctx}/business/oilConInfo/form?id=${oilConInfo.id}">
					${oilConInfo.gname}
				</a></td>
				<td>
					${oilConInfo.orderNumber}
				</td>
				<td>
					${oilConInfo.shippingAdd}
				</td>
				<td>
					${oilConInfo.totalAmount}
				</td>
				<td>
					<fmt:formatDate value="${oilConInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilConInfo.remarks}
				</td>
				<shiro:hasPermission name="business:oilConInfo:edit"><td>
    				<a href="${ctx}/business/oilConInfo/form?id=${oilConInfo.id}">修改</a>
					<a href="${ctx}/business/oilConInfo/delete?id=${oilConInfo.id}" onclick="return confirmx('确认要删除该合同信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>