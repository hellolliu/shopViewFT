/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 出库表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilStockOut extends DataEntity<OilStockOut> {
	
	private static final long serialVersionUID = 1L;
	private String deName;		// 出货员
	private Date deliveryDate;		// 出库日期
	private String outboundGname;		// 出库产品
	private String outboundQuantity;		// 出库数量
	private String outboundUnits;		// 出库单位
	private String cAddress;		// 公司地址
	private String phone;		// 电话
	private String orderNumber;		// 关联订单
	private String flowNumber;		// 流程编号
	
	public OilStockOut() {
		super();
	}

	public OilStockOut(String id){
		super(id);
	}

	@Length(min=1, max=255, message="de_name长度必须介于 1 和 255 之间")
	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="delivery_date不能为空")
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	@Length(min=1, max=100, message="outbound_gname长度必须介于 1 和 100 之间")
	public String getOutboundGname() {
		return outboundGname;
	}

	public void setOutboundGname(String outboundGname) {
		this.outboundGname = outboundGname;
	}
	
	public String getOutboundQuantity() {
		return outboundQuantity;
	}

	public void setOutboundQuantity(String outboundQuantity) {
		this.outboundQuantity = outboundQuantity;
	}
	
	@Length(min=1, max=255, message="outbound_units长度必须介于 1 和 255 之间")
	public String getOutboundUnits() {
		return outboundUnits;
	}

	public void setOutboundUnits(String outboundUnits) {
		this.outboundUnits = outboundUnits;
	}
	
	@Length(min=1, max=255, message="c_address长度必须介于 1 和 255 之间")
	public String getCAddress() {
		return cAddress;
	}

	public void setCAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	
	@Length(min=1, max=64, message="phone长度必须介于 1 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=11, message="order_number长度必须介于 1 和 11 之间")
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Length(min=1, max=64, message="flow_number长度必须介于 1 和 64 之间")
	public String getFlowNumber() {
		return flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}
	
}