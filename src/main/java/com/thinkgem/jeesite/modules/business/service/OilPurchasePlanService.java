/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilPurchasePlan;
import com.thinkgem.jeesite.modules.business.dao.OilPurchasePlanDao;

/**
 * 进货计划表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilPurchasePlanService extends CrudService<OilPurchasePlanDao, OilPurchasePlan> {

	public OilPurchasePlan get(String id) {
		return super.get(id);
	}
	
	public List<OilPurchasePlan> findList(OilPurchasePlan oilPurchasePlan) {
		return super.findList(oilPurchasePlan);
	}
	
	public Page<OilPurchasePlan> findPage(Page<OilPurchasePlan> page, OilPurchasePlan oilPurchasePlan) {
		return super.findPage(page, oilPurchasePlan);
	}
	
	@Transactional(readOnly = false)
	public void save(OilPurchasePlan oilPurchasePlan) {
		super.save(oilPurchasePlan);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilPurchasePlan oilPurchasePlan) {
		super.delete(oilPurchasePlan);
	}
	
}