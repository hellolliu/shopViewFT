/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 进库表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilStockIn extends DataEntity<OilStockIn> {
	
	private static final long serialVersionUID = 1L;
	private Date entryDate;		// entry_date
	private String purchaseGname;		// purchase_gname
	private String purchaseQuantity;		// purchase_quantity
	private String purchaseUnit;		// purchase_unit
	private String phone;		// phone
	private String inCycle;		// in_cycle
	private String purchasePrice;		// purchase_price
	
	public OilStockIn() {
		super();
	}

	public OilStockIn(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="entry_date不能为空")
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	@Length(min=1, max=100, message="purchase_gname长度必须介于 1 和 100 之间")
	public String getPurchaseGname() {
		return purchaseGname;
	}

	public void setPurchaseGname(String purchaseGname) {
		this.purchaseGname = purchaseGname;
	}
	
	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	@Length(min=1, max=100, message="purchase_unit长度必须介于 1 和 100 之间")
	public String getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	
	@Length(min=1, max=64, message="phone长度必须介于 1 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=255, message="in_cycle长度必须介于 1 和 255 之间")
	public String getInCycle() {
		return inCycle;
	}

	public void setInCycle(String inCycle) {
		this.inCycle = inCycle;
	}
	
	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
}