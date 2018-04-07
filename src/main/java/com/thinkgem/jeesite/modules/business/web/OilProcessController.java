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
import com.thinkgem.jeesite.modules.business.entity.OilProcess;
import com.thinkgem.jeesite.modules.business.service.OilProcessService;

/**
 * 流程表Controller
 * @author ren
 * @version 2018-04-07
 */
@Controller
@RequestMapping(value = "${adminPath}/business/oilProcess")
public class OilProcessController extends BaseController {

	@Autowired
	private OilProcessService oilProcessService;
	
	@ModelAttribute
	public OilProcess get(@RequestParam(required=false) String id) {
		OilProcess entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oilProcessService.get(id);
		}
		if (entity == null){
			entity = new OilProcess();
		}
		return entity;
	}
	
	@RequiresPermissions("business:oilProcess:view")
	@RequestMapping(value = {"list", ""})
	public String list(OilProcess oilProcess, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilProcess> page = oilProcessService.findPage(new Page<OilProcess>(request, response), oilProcess); 
		model.addAttribute("page", page);
		return "modules/business/oilProcessList";
	}

	@RequiresPermissions("business:oilProcess:view")
	@RequestMapping(value = "form")
	public String form(OilProcess oilProcess, Model model) {
		model.addAttribute("oilProcess", oilProcess);
		return "modules/business/oilProcessForm";
	}

	@RequiresPermissions("business:oilProcess:edit")
	@RequestMapping(value = "save")
	public String save(OilProcess oilProcess, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilProcess)){
			return form(oilProcess, model);
		}
		oilProcessService.save(oilProcess);
		addMessage(redirectAttributes, "保存流程成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilProcess/?repage";
	}
	
	@RequiresPermissions("business:oilProcess:edit")
	@RequestMapping(value = "delete")
	public String delete(OilProcess oilProcess, RedirectAttributes redirectAttributes) {
		oilProcessService.delete(oilProcess);
		addMessage(redirectAttributes, "删除流程成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilProcess/?repage";
	}

}