<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>产品介绍</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
</head>
<body>
 <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="thumbnails">
			<c:forEach items="${product }" var="pro"> 
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
</body>
</html>