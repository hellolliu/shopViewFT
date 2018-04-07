/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.business.entity.OilPurchasePlan;

/**
 * 进货计划表DAO接口
 * @author ren
 * @version 2018-04-07
 */
@MyBatisDao
public interface OilPurchasePlanDao extends CrudDao<OilPurchasePlan> {
	
}