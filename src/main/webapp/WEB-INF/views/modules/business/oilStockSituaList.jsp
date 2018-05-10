<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>库存情况管理</title>
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
		<li class="active"><a href="${ctx}/business/oilStockSitua/">库存情况列表</a></li>
		<%-- <shiro:hasPermission name="business:oilStockSitua:edit"><li><a href="${ctx}/business/oilStockSitua/form">仓库添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="oilStockSitua" action="${ctx}/business/oilStockSitua/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品序号：</label>
				<form:input path="prpSn" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="gname" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>销售总量：</label>
				<form:input path="saleno" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>库存总量：</label>
				<form:input path="factno" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>进价：</label>
				<form:input path="purchasePrice" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>阈值：</label>
				<form:input path="threshold" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>产品序号</th>
				<th>产品名称</th>
				<th>销售总量</th>
				<th>库存总量</th>
				<th>库存</th>
				<th>进价</th>
				<th>阈值</th>
				<th>更新日期</th>
				<!-- <th>备注</th> -->
				<%-- <shiro:hasPermission name="business:oilStockSitua:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilStockSitua">
			<tr>
				<td><a href="${ctx}/business/oilStockSitua/form?id=${oilStockSitua.id}">
					${oilStockSitua.prpSn}
				</a></td>
				<td>
					${oilStockSitua.gname}
				</td>
				<td>
					${oilStockSitua.saleno}
				</td>
				<td>
					${oilStockSitua.factno}
				</td>
				<td>
					${oilStockSitua.factno-oilStockSitua.saleno}
				</td>
				<td>
					${oilStockSitua.purchasePrice}
				</td>
				<td>
					${oilStockSitua.threshold}
				</td>
				<td>
					<fmt:formatDate value="${oilStockSitua.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					${oilStockSitua.remarks}
				</td> --%>
				<%-- <shiro:hasPermission name="business:oilStockSitua:edit"><td>
    				<a href="${ctx}/business/oilStockSitua/form?id=${oilStockSitua.id}">修改</a>
					<a href="${ctx}/business/oilStockSitua/delete?id=${oilStockSitua.id}" onclick="return confirmx('确认要删除该库存情况吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>