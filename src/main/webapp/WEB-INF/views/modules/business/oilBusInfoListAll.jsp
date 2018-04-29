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
			<li><label>公司名称：</label>
				<form:input path="cName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>公司负责人：</label>
				<form:input path="perName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>公司地址：</label>
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
				<th>用户公司名称</th>
				<th>公司负责人</th>
				<th>购买意向</th>
				<th>关注产品品牌</th>
				<th>用量</th>
				<!-- <th>流程表编号</th> -->
				<th>公司地址</th>
				<th>更新日期</th>
				<th>备注</th>
				<th>状态</th>
				<th>详情</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilBusInfo">
			<tr>
				<td><a href="${ctx}/business/oilBusInfo/form?id=${oilBusInfo.id}">
					${oilBusInfo.CName}
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
				<%-- <td>
					${oilBusInfo.flowNumber}
				</td> --%>
				<td>
					${oilBusInfo.comAddress}
				</td>
				<td>
					<fmt:formatDate value="${oilBusInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilBusInfo.remarks}
				</td>
				<td>
					${fns:getDictLabel(oilBusInfo.oilProcess.status, 'proStatus', '')}
				</td>
				<td>
					<a href="${ctx}/business/oilBusInfo/show?id=${oilBusInfo.id}">查看</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>