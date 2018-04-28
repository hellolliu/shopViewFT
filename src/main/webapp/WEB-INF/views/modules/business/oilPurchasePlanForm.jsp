<%@page import="com.thinkgem.jeesite.modules.business.entity.OilPurchasePlan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.thinkgem.jeesite.modules.business.entity.OilProducts"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>进货计划管理</title>
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
		<li><a href="${ctx}/business/oilPurchasePlan/">进货计划列表</a></li>
		<li class="active"><a href="${ctx}/business/oilPurchasePlan/form?id=${oilPurchasePlan.id}">进货计划<shiro:hasPermission name="business:oilPurchasePlan:edit">${not empty oilPurchasePlan.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="business:oilPurchasePlan:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="oilPurchasePlan" action="${ctx}/business/oilPurchasePlan/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<fieldset>
			<table class="table-form">
				<tr>
					<td class="tit">计划名称</td>
					<td>
						<form:input path="planName" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
					</td>
				</tr>
				<tr>
				  <td class="tit">进货日期</td>
				  <td> <input name="expDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					    value="<fmt:formatDate value="${oilPurchasePlan.expDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					    onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				  </td>
			    </tr>
				<tr>
					<td class="tit">商品列表</td>
					<td>
					 <input id="btnCancel" class="btn" type="button" value="添加商品" onclick="addProduct()"/>
					 <script type="text/javascript">
					   <% 
					   List<OilProducts> oilp=(List<OilProducts>) request.getAttribute("oilProducts");
					   List<String> newoil=new ArrayList<String>();
					   for(int i=0;i<oilp.size();i++){
						   newoil.add("'"+oilp.get(i).getGname()+"'");
					   }
					   OilPurchasePlan plan=(OilPurchasePlan)request.getAttribute("oilPurchasePlan");
					   int s=plan.getOilPlanDetails().size();
					   %>
					   var num=<%=s%>;
					   var listoil=<%=newoil%>;
					   console.log(listoil);
					   function addProduct(){
						   var table=$("#productTable");
						   var value='<tr id="num'+num+'"><td><select id="oilPlanDetails'+num+'.productId" name="oilPlanDetails['+num+'].productId" class="input-medium select2-type">';
					       for(var i=0;i<listoil.length;i++){
					    	   value+='<option value="'+listoil[i]+'">'+listoil[i]+'</option>';
					       }  
					       value=value+'</select></td> <td><input id="" name="oilPlanDetails['+num+'].num" class="input-xlarge " type="number" value=""></td><td>桶</td><td><a href="#" onclick="removeHt(num'+num+')">删除</a></td></tr>';
					       num++;
				           table.append(value);
				           table.find(".select2-type").select2();
					   }
					   function removeHt(id){
						   id.remove();
					   }
					 </script>
					 <table class="table-form" id="productTable">
						<thead>
						 <tr>
							<td>商品名称</td>
							<td>商品数量</td>
							<td>商品单位</td>
							<td>操作</td>
						 </tr>
						</thead>
						<tbody>
						<c:if test="${not empty oilPurchasePlan.id}">
						<c:forEach var="f" items="${oilPurchasePlan.oilPlanDetails}" varStatus="fs" >
						 <tr id="num${fs.count-1 }">
						    <td>
						      <form:select path="oilPlanDetails[${fs.count-1 }].productId" class="input-medium">
					           <form:options items="${oilProducts}" itemLabel="gname" itemValue="gname" htmlEscape="false" />
				              </form:select>
				            </td>
						    <td><input id="oilPlanDetails0.id" name="oilPlanDetails[${fs.count-1 }].num" class="input-xlarge " type="number" value="${f.num }"></td>
						    <td>桶</td>
						    <td><a href="#" onclick="removeHt(num${fs.count-1 })">删除</a></td>
						  </tr>
						</c:forEach>
						</c:if>
						<c:if test="${empty oilPurchasePlan.id}">
						  <tr id="num0">
						    <td>
						      <form:select path="oilPlanDetails[0].productId" class="input-medium">
					           <form:options items="${oilProducts}" itemLabel="gname" itemValue="gname" htmlEscape="false"/>
				              </form:select>
				            </td>
						    <td><input id="oilPlanDetails0.id" name="oilPlanDetails[0].num" class="input-xlarge " type="number" value=""></td>
						    <td>桶</td>
						    <td><a href="#" onclick="removeHt(num0)">删除</a></td>
						  </tr>
						 </c:if>
						</tbody>
					 </table>
					</td>
				</tr>
				<tr>
					<td class="tit">备注</td>
					<td colspan="5">
						<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"/>
						<span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr> 
			</table>
		</fieldset>
		<div class="form-actions">
			<shiro:hasPermission name="business:oilPurchasePlan:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>