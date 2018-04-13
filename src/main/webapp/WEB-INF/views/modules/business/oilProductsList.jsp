<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>油品商品表管理</title>
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
		<li class="active"><a href="${ctx}/business/oilProducts/">油品商品表列表</a></li>
		<shiro:hasPermission name="business:oilProducts:edit"><li><a href="${ctx}/business/oilProducts/form">油品商品表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oilProducts" action="${ctx}/business/oilProducts/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品序号：</label>
				<form:input path="prpSn" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="gname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>规格：</label>
				<form:input path="spec" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>价格：</label>
				<form:input path="price" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>产品编号</th>
				<th>产品名称</th>
				<th>注解</th>
				<th>简介</th>
				<th>闪点</th>
				<th>流点</th>
				<th>运动粘度40℃</th>
				<th>运动粘度50℃</th>
				<th>运动粘度100℃</th>
				<th>规格</th>
				<th>价格</th>
				<th>更新日期</th>
				<th>备注</th>
				<shiro:hasPermission name="business:oilProducts:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oilProducts">
			<tr>
				<td><a href="${ctx}/business/oilProducts/form?id=${oilProducts.id}">
					${oilProducts.prpSn}
				</a></td>
				<td>
					${oilProducts.gname}
				</td>
				<td>
					${oilProducts.note}
				</td>
				<td>
					${oilProducts.introduction}
				</td>
				<td>
					${oilProducts.flashPoint}
				</td>
				<td>
					${oilProducts.flowPoint}
				</td>
				<td>
					${oilProducts.cstfour}
				</td>
				<td>
					${oilProducts.cstfive}
				</td>
				<td>
					${oilProducts.csthundred}
				</td>
				<td>
					${oilProducts.spec}
				</td>
				<td>
					${oilProducts.price}
				</td>
				<td>
					<fmt:formatDate value="${oilProducts.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oilProducts.remarks}
				</td>
				<shiro:hasPermission name="business:oilProducts:edit"><td>
    				<a href="${ctx}/business/oilProducts/form?id=${oilProducts.id}">修改</a>
					<a href="${ctx}/business/oilProducts/delete?id=${oilProducts.id}" onclick="return confirmx('确认要删除该油品商品表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>