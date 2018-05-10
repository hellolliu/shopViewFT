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
				<shiro:hasPermission name="business:oilBusInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilBusInfo">
			<tr>
				<td><a href="${ctx}/business/oilBusInfo/form?id=${oilBusInfo.id}">
					${oilBusInfo.CName}
				</a></td>
				<td>
					${oilBusInfo.perName}
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
					<fmt:formatDate value="${oilBusInfo.updateDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${oilBusInfo.remarks}
				</td>
				<td>
				<c:if test="${oilBusInfo.oilProcess.status=='0101' }">
				    <a href="${ctx}/business/oilBusInfo/formSe?id=${oilBusInfo.id}">再次拜访</a>
					<a href="${ctx}/business/oilBusInfo/end?id=${oilBusInfo.id}" onclick="return confirmx('确认要结束该业务吗？', this.href)">结束业务</a>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0201' }">
				    <a href="${ctx}/business/oilConInfo/form?folwNumber=${oilBusInfo.oilProcess.CNumber}">录入合同信息</a>
					<a href="${ctx}/business/oilBusInfo/end?id=${oilBusInfo.id}" onclick="return confirmx('确认要结束该业务吗？', this.href)">结束业务</a>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0301' }">
				    <a href="${ctx}/business/oilBusInfo/statusnext?id=${oilBusInfo.id}" onclick="return confirmx('业务已完成？？', this.href)">确认完成业务</a>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0401' }">
				    <a href="#">业务已完成</a>
				    <%--  <a href="${ctx}/business/oilBusInfo/statusnext?id=${oilBusInfo.id}" onclick="return confirmx('确认已开发票？', this.href)">确认已开发票</a> --%>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0402' }">
				    <a href="#">业务已完成</a>
				    <%-- <a href="${ctx}/business/oilBusInfo/statusnext?id=${oilBusInfo.id}" onclick="return confirmx('确认客户贷款已清算？', this.href)">确认贷款已清算</a> --%>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0403' }">
				    <a href="#">业务已完成</a>
				    <%-- <a href="${ctx}/business/oilBusInfo/statusnext?id=${oilBusInfo.id}" onclick="return confirmx('确认业务完成？', this.href)">确认已清账</a> --%>
				</c:if>
				<c:if test="${oilBusInfo.oilProcess.status=='0404' || oilBusInfo.oilProcess.status=='0405' }">
				    <a href="#">业务已完成</a>
				</c:if>
				<%-- <c:if test="${oilBusInfo.oilProcess.status=='0405' }">
				    <a href="#">业务已确认</a>
				</c:if> --%>
				<c:if test="${oilBusInfo.oilProcess.status=='0000' }">
				业务已结束
				</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>