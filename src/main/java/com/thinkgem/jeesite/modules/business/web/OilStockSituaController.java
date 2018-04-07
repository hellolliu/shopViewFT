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
import com.thinkgem.jeesite.modules.business.entity.OilStockSitua;
import com.thinkgem.jeesite.modules.business.service.OilStockSituaService;

/**
 * 库存情况表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilStockSitua")
public class OilStockSituaController extends BaseController {

	@Autowired
	private OilStockSituaService oilStockSituaService;
	
	@ModelAttribute
	public OilStockSitua get(@RequestParam(required=false) String id) {
		OilStockSitua entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilStockSituaService.get(id);
		}
		if (entity == null){
			entity = new OilStockSitua();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilStockSitua:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilStockSitua oilStockSitua, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilStockSitua> page = oilStockSituaService.findPage(new Page<OilStockSitua>(request, response), oilStockSitua); 
		model.addAttribute("page", page);
		return "modules/business/oilStockSituaList";
	}

	@RequiresPermissions("business:oilStockSitua:view")
	@RequestMapping(value = "form")
	public String form(OilStockSitua oilStockSitua, Model model) {
		model.addAttribute("oilStockSitua", oilStockSitua);
		return "modules/business/oilStockSituaForm";
	}

	@RequiresPermissions("business:oilStockSitua:edit")
	@RequestMapping(value = "save")
	public String save(OilStockSitua oilStockSitua, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilStockSitua)){
			return form(oilStockSitua, model);
		}
		oilStockSituaService.save(oilStockSitua);
		addMessage(redirectAttributes, "保存库存情况成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockSitua/?repage";
	}
	
	@RequiresPermissions("business:oilStockSitua:edit")
	@RequestMapping(value = "delete")
	public String delete(OilStockSitua oilStockSitua, RedirectAttributes redirectAttributes) {
		oilStockSituaService.delete(oilStockSitua);
		addMessage(redirectAttributes, "删除库存情况成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockSitua/?repage";
	}

}