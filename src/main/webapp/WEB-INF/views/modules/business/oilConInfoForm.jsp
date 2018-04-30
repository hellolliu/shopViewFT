<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同信息表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/business/oilConInfo/">合同信息表列表</a></li>
		<li class="active"><a href="${ctx}/business/oilConInfo/form?id=${oilConInfo.id}">合同信息表<shiro:hasPermission name="business:oilConInfo:edit">${not empty oilConInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="business:oilConInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="oilConInfo" action="${ctx}/business/oilConInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="folwNumber"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">产品名称：</label>
			<div class="controls">
				<form:input path="gname" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">订单号：</label>
			<div class="controls">
				<form:input path="orderNumber" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">收货地址：</label>
			<div class="controls">
				<form:input path="shippingAdd" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">供货周期：</label>
			<div class="controls">
				<form:input path="deliveryCycle" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总量：</label>
			<div class="controls">
				<form:input path="totalAmount" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">流程表编号：</label>
			<div class="controls">
				<form:input path="folwNumber" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">支付方式：</label>
			<div class="controls">
				<form:input path="paymentMethod" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应付总金额：</label>
			<div class="controls">
				<form:input path="totalDue" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="business:oilConInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>