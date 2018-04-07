/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 业务信息表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilBusInfo extends DataEntity<OilBusInfo> {
	
	private static final long serialVersionUID = 1L;
	private String cName;		// c_name
	private String perName;		// per_name
	private String intention;		// intention
	private String brand;		// brand
	private String dosage;		// dosage
	private String usaCycle;		// usa_cycle
	private String payMethod;		// pay_method
	private String phone;		// phone
	private String flowNumber;		// flow_number
	private String comAddress;		// com_address
	
	public OilBusInfo() {
		super();
	}

	public OilBusInfo(String id){
		super(id);
	}

	@Length(min=1, max=255, message="c_name长度必须介于 1 和 255 之间")
	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}
	
	@Length(min=1, max=255, message="per_name长度必须介于 1 和 255 之间")
	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}
	
	@Length(min=1, max=255, message="intention长度必须介于 1 和 255 之间")
	public String getIntention() {
		return intention;
	}

	public void setIntention(String intention) {
		this.intention = intention;
	}
	
	@Length(min=1, max=255, message="brand长度必须介于 1 和 255 之间")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	@Length(min=1, max=255, message="usa_cycle长度必须介于 1 和 255 之间")
	public String getUsaCycle() {
		return usaCycle;
	}

	public void setUsaCycle(String usaCycle) {
		this.usaCycle = usaCycle;
	}
	
	@Length(min=1, max=100, message="pay_method长度必须介于 1 和 100 之间")
	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	@Length(min=1, max=64, message="phone长度必须介于 1 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=64, message="flow_number长度必须介于 1 和 64 之间")
	public String getFlowNumber() {
		return flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}
	
	@Length(min=1, max=255, message="com_address长度必须介于 1 和 255 之间")
	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	
}