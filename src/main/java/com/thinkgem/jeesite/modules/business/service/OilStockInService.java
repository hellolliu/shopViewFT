/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilStockIn;
import com.thinkgem.jeesite.modules.business.dao.OilStockInDao;

/**
 * 进库表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilStockInService extends CrudService<OilStockInDao, OilStockIn> {

	public OilStockIn get(String id) {
		return super.get(id);
	}
	
	public List<OilStockIn> findList(OilStockIn oilStockIn) {
		return super.findList(oilStockIn);
	}
	
	public Page<OilStockIn> findPage(Page<OilStockIn> page, OilStockIn oilStockIn) {
		return super.findPage(page, oilStockIn);
	}
	
	@Transactional(readOnly = false)
	public void save(OilStockIn oilStockIn) {
		super.save(oilStockIn);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilStockIn oilStockIn) {
		super.delete(oilStockIn);
	}
	
}