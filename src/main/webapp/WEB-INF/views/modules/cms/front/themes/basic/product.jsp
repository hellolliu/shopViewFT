<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>产品介绍</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
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
 <form:form id="searchForm" modelAttribute="oilProducts" action="${ctx}/product" method="get" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品名称：</label>
				<form:input path="gname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>规格：</label>
				<form:input path="spec" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
 </form:form>
 <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="thumbnails">
			<c:forEach items="${page.list }" var="pro"> 
			   <li class="span4">
					<div class="thumbnail">
						<img alt="300x200" src="${pro.photo }" />
						<div class="caption">
							<h3>
								${pro.gname }
							</h3>
							<p>
								${pro.introduction }
							</p>
							<p>
								<a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a>
							</p>
						</div>
					</div>
			   </li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="pagination">${page}</div>
</body>
</html>