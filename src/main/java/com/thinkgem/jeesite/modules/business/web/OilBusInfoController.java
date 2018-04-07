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
import com.thinkgem.jeesite.modules.business.entity.OilBusInfo;
import com.thinkgem.jeesite.modules.business.service.OilBusInfoService;

/**
 * 业务信息表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilBusInfo")
public class OilBusInfoController extends BaseController {

	@Autowired
	private OilBusInfoService oilBusInfoService;
	
	@ModelAttribute
	public OilBusInfo get(@RequestParam(required=false) String id) {
		OilBusInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilBusInfoService.get(id);
		}
		if (entity == null){
			entity = new OilBusInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilBusInfo oilBusInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilBusInfo> page = oilBusInfoService.findPage(new Page<OilBusInfo>(request, response), oilBusInfo); 
		model.addAttribute("page", page);
		return "modules/business/oilBusInfoList";
	}

	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = "form")
	public String form(OilBusInfo oilBusInfo, Model model) {
		model.addAttribute("oilBusInfo", oilBusInfo);
		return "modules/business/oilBusInfoForm";
	}

	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "save")
	public String save(OilBusInfo oilBusInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilBusInfo)){
			return form(oilBusInfo, model);
		}
		oilBusInfoService.save(oilBusInfo);
		addMessage(redirectAttributes, "保存业务信息成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}
	
	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(OilBusInfo oilBusInfo, RedirectAttributes redirectAttributes) {
		oilBusInfoService.delete(oilBusInfo);
		addMessage(redirectAttributes, "删除业务信息成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}

}