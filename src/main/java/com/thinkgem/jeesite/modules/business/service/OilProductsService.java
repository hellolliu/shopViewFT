/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilProducts;
import com.thinkgem.jeesite.modules.business.dao.OilProductsDao;

/**
 * 油品商品Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilProductsService extends CrudService<OilProductsDao, OilProducts> {

	public OilProducts get(String id) {
		return super.get(id);
	}
	
	public List<OilProducts> findList(OilProducts oilProducts) {
		return super.findList(oilProducts);
	}
	
	public Page<OilProducts> findPage(Page<OilProducts> page, OilProducts oilProducts) {
		return super.findPage(page, oilProducts);
	}
	
	@Transactional(readOnly = false)
	public void save(OilProducts oilProducts) {
		super.save(oilProducts);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilProducts oilProducts) {
		super.delete(oilProducts);
	}
	
}