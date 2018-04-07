/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilPlanDetails;
import com.thinkgem.jeesite.modules.business.dao.OilPlanDetailsDao;

/**
 * 进货计划详情表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilPlanDetailsService extends CrudService<OilPlanDetailsDao, OilPlanDetails> {

	public OilPlanDetails get(String id) {
		return super.get(id);
	}
	
	public List<OilPlanDetails> findList(OilPlanDetails oilPlanDetails) {
		return super.findList(oilPlanDetails);
	}
	
	public Page<OilPlanDetails> findPage(Page<OilPlanDetails> page, OilPlanDetails oilPlanDetails) {
		return super.findPage(page, oilPlanDetails);
	}
	
	@Transactional(readOnly = false)
	public void save(OilPlanDetails oilPlanDetails) {
		super.save(oilPlanDetails);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilPlanDetails oilPlanDetails) {
		super.delete(oilPlanDetails);
	}
	
}