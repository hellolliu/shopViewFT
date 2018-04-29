/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 流程表Entity
 * @author ren
 * @version 2018-04-07
 */
public class OilProcess extends DataEntity<OilProcess> {
	
	private static final long serialVersionUID = 1L;
	private String cNumber;		// 编号
	private String status;		// 状态
	private String perName;		// 负责人
	
	public OilProcess() {
		super();
	}

	public OilProcess(String id){
		super(id);
	}

	@Length(min=1, max=64, message="c_number长度必须介于 1 和 64 之间")
	public String getCNumber() {
		return cNumber;
	}

	public void setCNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	
	@Length(min=1, max=255, message="status长度必须介于 1 和 255 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=1, max=100, message="per_name长度必须介于 1 和 100 之间")
	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

}