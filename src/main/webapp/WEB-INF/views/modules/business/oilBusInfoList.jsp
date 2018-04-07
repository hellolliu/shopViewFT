<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>业务信息管理</title>
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
		<li class="active"><a href="${ctx}/business/oilBusInfo/">业务信息列表</a></li>
		<shiro:hasPermission name="business:oilBusInfo:edit"><li><a href="${ctx}/business/oilBusInfo/form">业务信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilBusInfo" action="${ctx}/business/oilBusInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>c_name：</label>
				<form:input path="cName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>per_name：</label>
				<form:select path="perName" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>com_address：</label>
				<form:input path="comAddress" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>c_name</th>
				<th>per_name</th>
				<th>intention</th>
				<th>brand</th>
				<th>dosage</th>
				<th>flow_number</th>
				<th>com_address</th>
				<th>update_date</th>
				<th>remarks</th>
				<shiro:hasPermission name="business:oilBusInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilBusInfo">
			<tr>
				<td><a href="${ctx}/business/oilBusInfo/form?id=${oilBusInfo.id}">
					${oilBusInfo.cName}
				</a></td>
				<td>
					${fns:getDictLabel(oilBusInfo.perName, '', '')}
				</td>
				<td>
					${oilBusInfo.intention}
				</td>
				<td>
					${oilBusInfo.brand}
				</td>
				<td>
					${oilBusInfo.dosage}
				</td>
				<td>
					${oilBusInfo.flowNumber}
				</td>
				<td>
					${oilBusInfo.comAddress}
				</td>
				<td>
					<fmt:formatDate value="${oilBusInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilBusInfo.remarks}
				</td>
				<shiro:hasPermission name="business:oilBusInfo:edit"><td>
    				<a href="${ctx}/business/oilBusInfo/form?id=${oilBusInfo.id}">修改</a>
					<a href="${ctx}/business/oilBusInfo/delete?id=${oilBusInfo.id}" onclick="return confirmx('确认要删除该业务信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>