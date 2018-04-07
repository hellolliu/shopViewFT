<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出库表管理</title>
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
		<li class="active"><a href="${ctx}/business/oilStockOut/">出库表列表</a></li>
		<shiro:hasPermission name="business:oilStockOut:edit"><li><a href="${ctx}/business/oilStockOut/form">出库表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilStockOut" action="${ctx}/business/oilStockOut/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>de_name：</label>
				<form:input path="deName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>delivery_date：</label>
				<input name="deliveryDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${oilStockOut.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>outbound_gname：</label>
				<form:input path="outboundGname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>outbound_quantity：</label>
				<form:input path="outboundQuantity" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>outbound_units：</label>
				<form:input path="outboundUnits" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>c_address：</label>
				<form:input path="cAddress" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>de_name</th>
				<th>delivery_date</th>
				<th>outbound_gname</th>
				<th>outbound_quantity</th>
				<th>outbound_units</th>
				<th>c_address</th>
				<th>update_date</th>
				<th>remarks</th>
				<shiro:hasPermission name="business:oilStockOut:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilStockOut">
			<tr>
				<td><a href="${ctx}/business/oilStockOut/form?id=${oilStockOut.id}">
					${oilStockOut.deName}
				</a></td>
				<td>
					<fmt:formatDate value="${oilStockOut.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilStockOut.outboundGname}
				</td>
				<td>
					${oilStockOut.outboundQuantity}
				</td>
				<td>
					${oilStockOut.outboundUnits}
				</td>
				<td>
					${oilStockOut.cAddress}
				</td>
				<td>
					<fmt:formatDate value="${oilStockOut.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilStockOut.remarks}
				</td>
				<shiro:hasPermission name="business:oilStockOut:edit"><td>
    				<a href="${ctx}/business/oilStockOut/form?id=${oilStockOut.id}">修改</a>
					<a href="${ctx}/business/oilStockOut/delete?id=${oilStockOut.id}" onclick="return confirmx('确认要删除该出库表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>