/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilStockOut;
import com.thinkgem.jeesite.modules.business.dao.OilStockOutDao;

/**
 * 出库表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilStockOutService extends CrudService<OilStockOutDao, OilStockOut> {

	public OilStockOut get(String id) {
		return super.get(id);
	}
	
	public List<OilStockOut> findList(OilStockOut oilStockOut) {
		return super.findList(oilStockOut);
	}
	
	public Page<OilStockOut> findPage(Page<OilStockOut> page, OilStockOut oilStockOut) {
		return super.findPage(page, oilStockOut);
	}
	
	@Transactional(readOnly = false)
	public void save(OilStockOut oilStockOut) {
		super.save(oilStockOut);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilStockOut oilStockOut) {
		super.delete(oilStockOut);
	}
	
}