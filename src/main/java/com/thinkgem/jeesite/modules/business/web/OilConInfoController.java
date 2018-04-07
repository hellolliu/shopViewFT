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
import com.thinkgem.jeesite.modules.business.entity.OilConInfo;
import com.thinkgem.jeesite.modules.business.service.OilConInfoService;

/**
 * 合同信息Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilConInfo")
public class OilConInfoController extends BaseController {

	@Autowired
	private OilConInfoService oilConInfoService;
	
	@ModelAttribute
	public OilConInfo get(@RequestParam(required=false) String id) {
		OilConInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilConInfoService.get(id);
		}
		if (entity == null){
			entity = new OilConInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilConInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilConInfo oilConInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilConInfo> page = oilConInfoService.findPage(new Page<OilConInfo>(request, response), oilConInfo); 
		model.addAttribute("page", page);
		return "modules/business/oilConInfoList";
	}

	@RequiresPermissions("business:oilConInfo:view")
	@RequestMapping(value = "form")
	public String form(OilConInfo oilConInfo, Model model) {
		model.addAttribute("oilConInfo", oilConInfo);
		return "modules/business/oilConInfoForm";
	}

	@RequiresPermissions("business:oilConInfo:edit")
	@RequestMapping(value = "save")
	public String save(OilConInfo oilConInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilConInfo)){
			return form(oilConInfo, model);
		}
		oilConInfoService.save(oilConInfo);
		addMessage(redirectAttributes, "保存合同信息表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilConInfo/?repage";
	}
	
	@RequiresPermissions("business:oilConInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(OilConInfo oilConInfo, RedirectAttributes redirectAttributes) {
		oilConInfoService.delete(oilConInfo);
		addMessage(redirectAttributes, "删除合同信息表成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilConInfo/?repage";
	}

}