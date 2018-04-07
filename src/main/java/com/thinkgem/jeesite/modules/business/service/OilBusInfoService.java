/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.business.entity.OilBusInfo;
import com.thinkgem.jeesite.modules.business.dao.OilBusInfoDao;

/**
 * 业务信息表Service
 * @author ren
 * @version 2018-04-07
 */
@Service
@Transactional(readOnly = true)
public class OilBusInfoService extends CrudService<OilBusInfoDao, OilBusInfo> {

	public OilBusInfo get(String id) {
		return super.get(id);
	}
	
	public List<OilBusInfo> findList(OilBusInfo oilBusInfo) {
		return super.findList(oilBusInfo);
	}
	
	public Page<OilBusInfo> findPage(Page<OilBusInfo> page, OilBusInfo oilBusInfo) {
		return super.findPage(page, oilBusInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(OilBusInfo oilBusInfo) {
		super.save(oilBusInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(OilBusInfo oilBusInfo) {
		super.delete(oilBusInfo);
	}
	
}