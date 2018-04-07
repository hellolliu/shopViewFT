/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilProcess;
import com.thinkgem.jeesite.modules.business.dao.OilProcessDao;

/**
 * 流程表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilProcessService extends CrudService<OilProcessDao, OilProcess> {

	public OilProcess get(String id) {
		return super.get(id);
	}
	
	public List<OilProcess> findList(OilProcess oilProcess) {
		return super.findList(oilProcess);
	}
	
	public Page<OilProcess> findPage(Page<OilProcess> page, OilProcess oilProcess) {
		return super.findPage(page, oilProcess);
	}
	
	@Transactional(readOnly = false)
	public void save(OilProcess oilProcess) {
		super.save(oilProcess);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilProcess oilProcess) {
		super.delete(oilProcess);
	}
	
}