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
import com.thinkgem.jeesite.modules.business.entity.OilStockIn;
import com.thinkgem.jeesite.modules.business.service.OilStockInService;

/**
 * 进库表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilStockIn")
public class OilStockInController extends BaseController {

	@Autowired
	private OilStockInService oilStockInService;
	
	@ModelAttribute
	public OilStockIn get(@RequestParam(required=false) String id) {
		OilStockIn entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilStockInService.get(id);
		}
		if (entity == null){
			entity = new OilStockIn();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilStockIn:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilStockIn oilStockIn, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilStockIn> page = oilStockInService.findPage(new Page<OilStockIn>(request, response), oilStockIn); 
		model.addAttribute("page", page);
		return "modules/business/oilStockInList";
	}

	@RequiresPermissions("business:oilStockIn:view")
	@RequestMapping(value = "form")
	public String form(OilStockIn oilStockIn, Model model) {
		model.addAttribute("oilStockIn", oilStockIn);
		return "modules/business/oilStockInForm";
	}

	@RequiresPermissions("business:oilStockIn:edit")
	@RequestMapping(value = "save")
	public String save(OilStockIn oilStockIn, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilStockIn)){
			return form(oilStockIn, model);
		}
		oilStockInService.save(oilStockIn);
		addMessage(redirectAttributes, "保存进库成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockIn/?repage";
	}
	
	@RequiresPermissions("business:oilStockIn:edit")
	@RequestMapping(value = "delete")
	public String delete(OilStockIn oilStockIn, RedirectAttributes redirectAttributes) {
		oilStockInService.delete(oilStockIn);
		addMessage(redirectAttributes, "删除进库成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockIn/?repage";
	}

}