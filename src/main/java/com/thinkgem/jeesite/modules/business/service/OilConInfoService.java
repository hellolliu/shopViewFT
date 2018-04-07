/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilConInfo;
import com.thinkgem.jeesite.modules.business.dao.OilConInfoDao;

/**
 * 合同信息Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilConInfoService extends CrudService<OilConInfoDao, OilConInfo> {

	public OilConInfo get(String id) {
		return super.get(id);
	}
	
	public List<OilConInfo> findList(OilConInfo oilConInfo) {
		return super.findList(oilConInfo);
	}
	
	public Page<OilConInfo> findPage(Page<OilConInfo> page, OilConInfo oilConInfo) {
		return super.findPage(page, oilConInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(OilConInfo oilConInfo) {
		super.save(oilConInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilConInfo oilConInfo) {
		super.delete(oilConInfo);
	}
	
}