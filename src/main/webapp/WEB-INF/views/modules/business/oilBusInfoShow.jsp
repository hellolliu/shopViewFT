<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同信息表管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
<c:if test="${oilBusInfo!=null }">
	<form:form id="inputForm" modelAttribute="oilBusInfo" action="${ctx}/oa/testAudit/save" method="post" class="form-horizontal">
		<fieldset>
			<legend>业务信息</legend>
			<table class="table-form">
				<tr>
					<td class="tit">公司名称</td>
					<td>${oilBusInfo.CName }</td>
					<td class="tit">公司负责人</td>
					<td>${oilBusInfo.perName }</td>
					<td class="tit">电话</td>
					<td>${oilBusInfo.phone }</td>
				</tr>
				<tr>
					<td class="tit">公司地址</td>
					<td colspan="5">
						 ${oilBusInfo.phone }
					</td>
				</tr>
				<tr>
					<td class="tit">关注产品品牌</td>
					<td class="tit" colspan="2">${oilBusInfo.brand }</td>
					<td class="tit">购买意向</td>
					<td class="tit" colspan="2">${oilBusInfo.intention }</td>
				</tr>
				<tr>
					<td class="tit">用量</td>
					<td class="tit" colspan="2">${oilBusInfo.dosage }</td>
					<td class="tit">使用周期</td>
					<td class="tit" colspan="2">${oilBusInfo.usaCycle }</td>
				</tr>
				<tr>
					<td class="tit">付款方式</td>
					<td class="tit" colspan="2">${oilBusInfo.payMethod }</td>
					<td class="tit">状态</td>
					<td class="tit" colspan="2">${fns:getDictLabel(oilBusInfo.oilProcess.status, 'proStatus', '')}</td>
				</tr>
			</table>
		</fieldset>
	</form:form> 
</c:if>
<c:if test="${oilConInfo!=null }">
	<form:form id="inputForm" modelAttribute="oilBusInfo" action="${ctx}/oa/testAudit/save" method="post" class="form-horizontal">
		<fieldset>
			<legend>合同信息</legend>
			<table class="table-form">
				<tr>
					<td class="tit" >产品名称</td>
					<td class="tit" colspan="2">${oilConInfo.gname }</td>
					<td class="tit">收货地址</td>
					<td class="tit" colspan="2">${oilConInfo.shippingAdd }</td>
				</tr>
				<tr>
					<td class="tit">供货周期</td>
					<td class="tit" colspan="2">${oilConInfo.deliveryCycle }</td>
					<td class="tit">总量</td>
					<td class="tit" colspan="2">${oilConInfo.totalAmount }</td>
				</tr>
				<tr>
					<td class="tit"> 支付方式</td>
					<td class="tit" colspan="2">${oilConInfo.paymentMethod }</td>
				</tr>
			</table>
		</fieldset>
	</form:form> 
</c:if>
        <div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
</body>
</html>