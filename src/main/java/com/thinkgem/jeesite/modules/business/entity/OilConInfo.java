/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 合同信息Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilConInfo extends DataEntity<OilConInfo> {
	
	private static final long serialVersionUID = 1L;
	private String gname;		// 产品名称
	private String orderNumber;		// 订单号
	private String shippingAdd;		// 收货地址
	private String deliveryCycle;		// 供货周期
	private String totalAmount;		// 总量
	private String folwNumber;		// 流程编号
	private String paymentMethod;		// 支付方式
	private String totalDue;		// 应付总金额
	private OilProcess oilProcess;
	public OilConInfo() {
		super();
	}

	public OilConInfo(String id){
		super(id);
	}

	@Length(min=1, max=100, message="gname长度必须介于 1 和 100 之间")
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
	@Length(min=1, max=32, message="order_number长度必须介于 1 和 32 之间")
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Length(min=1, max=255, message="shipping_add长度必须介于 1 和 255 之间")
	public String getShippingAdd() {
		return shippingAdd;
	}

	public void setShippingAdd(String shippingAdd) {
		this.shippingAdd = shippingAdd;
	}
	
	@Length(min=1, max=255, message="delivery_cycle长度必须介于 1 和 255 之间")
	public String getDeliveryCycle() {
		return deliveryCycle;
	}

	public void setDeliveryCycle(String deliveryCycle) {
		this.deliveryCycle = deliveryCycle;
	}
	
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Length(min=1, max=64, message="folw_number长度必须介于 1 和 64 之间")
	public String getFolwNumber() {
		return folwNumber;
	}

	public void setFolwNumber(String folwNumber) {
		this.folwNumber = folwNumber;
	}
	
	@Length(min=1, max=255, message="payment_method长度必须介于 1 和 255 之间")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(String totalDue) {
		this.totalDue = totalDue;
	}

	public OilProcess getOilProcess() {
		return oilProcess;
	}

	public void setOilProcess(OilProcess oilProcess) {
		this.oilProcess = oilProcess;
	}
	
}