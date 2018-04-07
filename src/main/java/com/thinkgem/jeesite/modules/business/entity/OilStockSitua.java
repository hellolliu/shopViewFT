/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 库存情况表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilStockSitua extends DataEntity<OilStockSitua> {
	
	private static final long serialVersionUID = 1L;
	private String prpSn;		// prp_sn
	private String gname;		// gname
	private String saleno;		// saleno
	private String factno;		// factno
	private String purchasePrice;		// purchase_price
	private String threshold;		// threshold
	private String purchaseCycle;		// purchase_cycle
	
	public OilStockSitua() {
		super();
	}

	public OilStockSitua(String id){
		super(id);
	}

	@Length(min=1, max=20, message="prp_sn长度必须介于 1 和 20 之间")
	public String getPrpSn() {
		return prpSn;
	}

	public void setPrpSn(String prpSn) {
		this.prpSn = prpSn;
	}
	
	@Length(min=1, max=255, message="gname长度必须介于 1 和 255 之间")
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
	public String getSaleno() {
		return saleno;
	}

	public void setSaleno(String saleno) {
		this.saleno = saleno;
	}
	
	public String getFactno() {
		return factno;
	}

	public void setFactno(String factno) {
		this.factno = factno;
	}
	
	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	
	@Length(min=1, max=255, message="purchase_cycle长度必须介于 1 和 255 之间")
	public String getPurchaseCycle() {
		return purchaseCycle;
	}

	public void setPurchaseCycle(String purchaseCycle) {
		this.purchaseCycle = purchaseCycle;
	}
	
}