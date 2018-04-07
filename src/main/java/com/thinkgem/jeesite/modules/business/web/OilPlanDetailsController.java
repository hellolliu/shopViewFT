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
import com.thinkgem.jeesite.modules.business.entity.OilPlanDetails;
import com.thinkgem.jeesite.modules.business.service.OilPlanDetailsService;

/**
 * 进货计划详情表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilPlanDetails")
public class OilPlanDetailsController extends BaseController {

	@Autowired
	private OilPlanDetailsService oilPlanDetailsService;
	
	@ModelAttribute
	public OilPlanDetails get(@RequestParam(required=false) String id) {
		OilPlanDetails entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilPlanDetailsService.get(id);
		}
		if (entity == null){
			entity = new OilPlanDetails();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilPlanDetails:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilPlanDetails oilPlanDetails, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilPlanDetails> page = oilPlanDetailsService.findPage(new Page<OilPlanDetails>(request, response), oilPlanDetails); 
		model.addAttribute("page", page);
		return "modules/business/oilPlanDetailsList";
	}

	@RequiresPermissions("business:oilPlanDetails:view")
	@RequestMapping(value = "form")
	public String form(OilPlanDetails oilPlanDetails, Model model) {
		model.addAttribute("oilPlanDetails", oilPlanDetails);
		return "modules/business/oilPlanDetailsForm";
	}

	@RequiresPermissions("business:oilPlanDetails:edit")
	@RequestMapping(value = "save")
	public String save(OilPlanDetails oilPlanDetails, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilPlanDetails)){
			return form(oilPlanDetails, model);
		}
		oilPlanDetailsService.save(oilPlanDetails);
		addMessage(redirectAttributes, "保存进货计划成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilPlanDetails/?repage";
	}
	
	@RequiresPermissions("business:oilPlanDetails:edit")
	@RequestMapping(value = "delete")
	public String delete(OilPlanDetails oilPlanDetails, RedirectAttributes redirectAttributes) {
		oilPlanDetailsService.delete(oilPlanDetails);
		addMessage(redirectAttributes, "删除进货计划成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilPlanDetails/?repage";
	}

}