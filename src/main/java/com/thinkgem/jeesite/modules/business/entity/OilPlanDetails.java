/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 进货计划详情表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilPlanDetails extends DataEntity<OilPlanDetails> {
	
	private static final long serialVersionUID = 1L;
	private String productId;		// 货品编号
	private String num;		// 数量
	private String planId;		// 计划编号
	
	public OilPlanDetails() {
		super();
	}

	public OilPlanDetails(String id){
		super(id);
	}

	@Length(min=0, max=20, message="product_id长度必须介于 0 和 20 之间")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	@Length(min=0, max=20, message="plan_id长度必须介于 0 和 20 之间")
	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
	
}