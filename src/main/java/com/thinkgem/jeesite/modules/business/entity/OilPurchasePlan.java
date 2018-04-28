/**
 */
package com.thinkgem.jeesite.modules.business.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;


/**
 * 进货计划表Entity
 * 
 * @author ren
 * @version 2018-04-07
 */
public class OilPurchasePlan extends DataEntity<OilPurchasePlan> {

	private static final long serialVersionUID = 1L;
	private String planName; // 进货计划
	private String totalAmountNum; // 总数量
	private String totalAmountDue; // 总金额
	private String totalAmount; // 总容量
	private Date expDate; // 进货日期
	private List<OilPlanDetails> oilPlanDetails;//进货计划详情
	public OilPurchasePlan() {
		super();
	}

	public OilPurchasePlan(String id) {
		super(id);
	}

	@Length(min = 1, max = 100, message = "plan_name长度必须介于 1 和 100 之间")
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getTotalAmountNum() {
		return totalAmountNum;
	}

	public void setTotalAmountNum(String totalAmountNum) {
		this.totalAmountNum = totalAmountNum;
	}

	public String getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(String totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public List<OilPlanDetails> getOilPlanDetails() {
		return oilPlanDetails;
	}

	public void setOilPlanDetails(List<OilPlanDetails> oilPlanDetails) {
		this.oilPlanDetails = oilPlanDetails;
	}

}