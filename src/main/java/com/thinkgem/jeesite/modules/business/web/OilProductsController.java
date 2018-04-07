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
import com.thinkgem.jeesite.modules.business.entity.OilProducts;
import com.thinkgem.jeesite.modules.business.service.OilProductsService;

/**
 * 油品商品Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilProducts")
public class OilProductsController extends BaseController {

	@Autowired
	private OilProductsService oilProductsService;
	
	@ModelAttribute
	public OilProducts get(@RequestParam(required=false) String id) {
		OilProducts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilProductsService.get(id);
		}
		if (entity == null){
			entity = new OilProducts();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilProducts:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilProducts oilProducts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilProducts> page = oilProductsService.findPage(new Page<OilProducts>(request, response), oilProducts); 
		model.addAttribute("page", page);
		return "modules/business/oilProductsList";
	}

	@RequiresPermissions("business:oilProducts:view")
	@RequestMapping(value = "form")
	public String form(OilProducts oilProducts, Model model) {
		model.addAttribute("oilProducts", oilProducts);
		return "modules/business/oilProductsForm";
	}

	@RequiresPermissions("business:oilProducts:edit")
	@RequestMapping(value = "save")
	public String save(OilProducts oilProducts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilProducts)){
			return form(oilProducts, model);
		}
		oilProductsService.save(oilProducts);
		addMessage(redirectAttributes, "保存油品商品表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilProducts/?repage";
	}
	
	@RequiresPermissions("business:oilProducts:edit")
	@RequestMapping(value = "delete")
	public String delete(OilProducts oilProducts, RedirectAttributes redirectAttributes) {
		oilProductsService.delete(oilProducts);
		addMessage(redirectAttributes, "删除油品商品表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilProducts/?repage";
	}

}