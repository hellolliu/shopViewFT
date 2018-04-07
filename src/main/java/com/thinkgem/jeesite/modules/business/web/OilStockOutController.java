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
import com.thinkgem.jeesite.modules.business.entity.OilStockOut;
import com.thinkgem.jeesite.modules.business.service.OilStockOutService;

/**
 * 出库表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilStockOut")
public class OilStockOutController extends BaseController {

	@Autowired
	private OilStockOutService oilStockOutService;
	
	@ModelAttribute
	public OilStockOut get(@RequestParam(required=false) String id) {
		OilStockOut entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilStockOutService.get(id);
		}
		if (entity == null){
			entity = new OilStockOut();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilStockOut:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilStockOut oilStockOut, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilStockOut> page = oilStockOutService.findPage(new Page<OilStockOut>(request, response), oilStockOut); 
		model.addAttribute("page", page);
		return "modules/business/oilStockOutList";
	}

	@RequiresPermissions("business:oilStockOut:view")
	@RequestMapping(value = "form")
	public String form(OilStockOut oilStockOut, Model model) {
		model.addAttribute("oilStockOut", oilStockOut);
		return "modules/business/oilStockOutForm";
	}

	@RequiresPermissions("business:oilStockOut:edit")
	@RequestMapping(value = "save")
	public String save(OilStockOut oilStockOut, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilStockOut)){
			return form(oilStockOut, model);
		}
		oilStockOutService.save(oilStockOut);
		addMessage(redirectAttributes, "保存出库表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockOut/?repage";
	}
	
	@RequiresPermissions("business:oilStockOut:edit")
	@RequestMapping(value = "delete")
	public String delete(OilStockOut oilStockOut, RedirectAttributes redirectAttributes) {
		oilStockOutService.delete(oilStockOut);
		addMessage(redirectAttributes, "删除出库表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilStockOut/?repage";
	}

}