<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>进库管理</title>
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
		<li class="active"><a href="${ctx}/business/oilStockIn/">进库列表</a></li>
		<shiro:hasPermission name="business:oilStockIn:edit"><li><a href="${ctx}/business/oilStockIn/form">进库添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilStockIn" action="${ctx}/business/oilStockIn/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>进货日期：</label>
				<input name="entryDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${oilStockIn.entryDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>进货产品：</label>
				<form:input path="purchaseGname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>进货数量：</label>
				<form:input path="purchaseQuantity" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>进货单位：</label>
				<form:input path="purchaseUnit" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>进货价格：</label>
				<form:input path="purchasePrice" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>进货日期</th>
				<th>进货产品</th>
				<th>进货数量</th>
				<th>进货单位</th>
				<th>进价</th>
				<th>更新日期</th>
				<th>备注</th>
				<shiro:hasPermission name="business:oilStockIn:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilStockIn">
			<tr>
				<td><a href="${ctx}/business/oilStockIn/form?id=${oilStockIn.id}">
					<fmt:formatDate value="${oilStockIn.entryDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${oilStockIn.purchaseGname}
				</td>
				<td>
					${oilStockIn.purchaseQuantity}
				</td>
				<td>
					${fns:getDictLabel(oilStockIn.purchaseUnit, 'unit_in', '桶')}
				</td>
				<td>
					${oilStockIn.purchasePrice}
				</td>
				<td>
					<fmt:formatDate value="${oilStockIn.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilStockIn.remarks}
				</td>
				<shiro:hasPermission name="business:oilStockIn:edit"><td>
    				<a href="${ctx}/business/oilStockIn/form?id=${oilStockIn.id}">修改</a>
					<a href="${ctx}/business/oilStockIn/delete?id=${oilStockIn.id}" onclick="return confirmx('确认要删除该进库吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>