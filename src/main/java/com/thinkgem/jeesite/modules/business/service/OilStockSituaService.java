/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilStockSitua;
import com.thinkgem.jeesite.modules.business.dao.OilStockSituaDao;

/**
 * 库存情况表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilStockSituaService extends CrudService<OilStockSituaDao, OilStockSitua> {

	public OilStockSitua get(String id) {
		return super.get(id);
	}
	
	public List<OilStockSitua> findList(OilStockSitua oilStockSitua) {
		return super.findList(oilStockSitua);
	}
	
	public Page<OilStockSitua> findPage(Page<OilStockSitua> page, OilStockSitua oilStockSitua) {
		return super.findPage(page, oilStockSitua);
	}
	
	@Transactional(readOnly = false)
	public void save(OilStockSitua oilStockSitua) {
		super.save(oilStockSitua);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilStockSitua oilStockSitua) {
		super.delete(oilStockSitua);
	}
	
}