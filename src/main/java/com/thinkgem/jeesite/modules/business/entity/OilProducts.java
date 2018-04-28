package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 油品商品Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilProducts extends DataEntity<OilProducts> {
	
	private static final long serialVersionUID = 1L;
	private String photo;//图片
	private String prpSn;		// 产品序号
	private String gname;		// 产品名称
	private String note;		// 注解
	private String introduction;		// 简介
	private String flashPoint;		// 闪点
	private String flowPoint;		// 流点
	private String cstfour;		// 运动粘度40摄氏度
	private String cstfive;		// 运动粘度50摄氏度
	private String csthundred;		// 运动粘度100摄氏度
	private String spec;		// 规格
	private String price;		// 价格
	private String isShow;
	public OilProducts() {
		super();
	}

	public OilProducts(String id){
		super(id);
	}

 

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Length(min=1, max=20, message="prp_sn长度必须介于 1 和 20 之间")
	public String getPrpSn() {
		return prpSn;
	}

	public void setPrpSn(String prpSn) {
		this.prpSn = prpSn;
	}
	
	@Length(min=1, max=100, message="gname长度必须介于 1 和 100 之间")
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
	@Length(min=0, max=255, message="note长度必须介于 0 和 255 之间")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Length(min=1, max=255, message="introduction长度必须介于 1 和 255 之间")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@Length(min=0, max=20, message="flash_point长度必须介于 0 和 20 之间")
	public String getFlashPoint() {
		return flashPoint;
	}

	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
	}
	
	@Length(min=0, max=64, message="flow_point长度必须介于 0 和 64 之间")
	public String getFlowPoint() {
		return flowPoint;
	}

	public void setFlowPoint(String flowPoint) {
		this.flowPoint = flowPoint;
	}
	
	public String getCstfour() {
		return cstfour;
	}

	public void setCstfour(String cstfour) {
		this.cstfour = cstfour;
	}
	
	public String getCstfive() {
		return cstfive;
	}

	public void setCstfive(String cstfive) {
		this.cstfive = cstfive;
	}
	
	public String getCsthundred() {
		return csthundred;
	}

	public void setCsthundred(String csthundred) {
		this.csthundred = csthundred;
	}
	
	@Length(min=0, max=10, message="规格长度必须介于 0 和 10 之间")
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}