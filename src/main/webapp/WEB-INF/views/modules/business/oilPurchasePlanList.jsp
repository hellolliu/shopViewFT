<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>进货计划管理</title>
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
		<li class="active"><a href="${ctx}/business/oilPurchasePlan/">进货计划列表</a></li>
		<shiro:hasPermission name="business:oilPurchasePlan:edit"><li><a href="${ctx}/business/oilPurchasePlan/form">进货计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilPurchasePlan" action="${ctx}/business/oilPurchasePlan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>进货计划：</label>
				<form:input path="planName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>总容量：</label>
				<form:input path="totalAmount" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>进货日期：</label>
				<input name="expDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${oilPurchasePlan.expDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>进货计划</th>
				<th>总数量</th>
				<!-- <th>总金额</th> -->
				<!-- <th>总容量</th> -->
				<th>进货日期</th>
				<th>更新日期</th>
				<th>备注</th>
				<shiro:hasPermission name="business:oilPurchasePlan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilPurchasePlan">
			<tr>
				<td><a href="${ctx}/business/oilPurchasePlan/form?id=${oilPurchasePlan.id}">
					${oilPurchasePlan.planName}
				</a></td>
				<td>
					${oilPurchasePlan.totalAmountNum}
				</td>
				<%-- <td>
					${oilPurchasePlan.totalAmountDue}
				</td> --%>
				<%-- <td>
					${oilPurchasePlan.totalAmount}
				</td> --%>
				<td>
					<fmt:formatDate value="${oilPurchasePlan.expDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oilPurchasePlan.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilPurchasePlan.remarks}
				</td>
				<shiro:hasPermission name="business:oilPurchasePlan:edit"><td>
    				<a href="${ctx}/business/oilPurchasePlan/form?id=${oilPurchasePlan.id}">修改</a>
					<a href="${ctx}/business/oilPurchasePlan/delete?id=${oilPurchasePlan.id}" onclick="return confirmx('确认要删除该进货计划吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>