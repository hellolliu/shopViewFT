/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.business.entity.OilPurchasePlan;
import com.thinkgem.jeesite.modules.business.service.OilPurchasePlanService;

/**
 * 进货计划表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilPurchasePlan")
public class OilPurchasePlanController extends BaseController {

	@Autowired
	private OilPurchasePlanService oilPurchasePlanService;
	
	@ModelAttribute
	public OilPurchasePlan get(@RequestParam(required=false) String id) {
		OilPurchasePlan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilPurchasePlanService.get(id);
		}
		if (entity == null){
			entity = new OilPurchasePlan();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilPurchasePlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilPurchasePlan oilPurchasePlan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilPurchasePlan> page = oilPurchasePlanService.findPage(new Page<OilPurchasePlan>(request, response), oilPurchasePlan); 
		model.addAttribute("page", page);
		return "modules/business/oilPurchasePlanList";
	}

	@RequiresPermissions("business:oilPurchasePlan:view")
	@RequestMapping(value = "form")
	public String form(OilPurchasePlan oilPurchasePlan, Model model) {
		model.addAttribute("oilPurchasePlan", oilPurchasePlan);
		return "modules/business/oilPurchasePlanForm";
	}

	@RequiresPermissions("business:oilPurchasePlan:edit")
	@RequestMapping(value = "save")
	public String save(OilPurchasePlan oilPurchasePlan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilPurchasePlan)){
			return form(oilPurchasePlan, model);
		}
		oilPurchasePlanService.save(oilPurchasePlan);
		addMessage(redirectAttributes, "保存进货计划成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilPurchasePlan/?repage";
	}
	
	@RequiresPermissions("business:oilPurchasePlan:edit")
	@RequestMapping(value = "delete")
	public String delete(OilPurchasePlan oilPurchasePlan, RedirectAttributes redirectAttributes) {
		oilPurchasePlanService.delete(oilPurchasePlan);
		addMessage(redirectAttributes, "删除进货计划成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilPurchasePlan/?repage";
	}

}