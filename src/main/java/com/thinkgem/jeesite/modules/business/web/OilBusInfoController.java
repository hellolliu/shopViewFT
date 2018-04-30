/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.web;

import java.util.List;
import java.util.UUID;

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
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.business.entity.OilBusInfo;
import com.thinkgem.jeesite.modules.business.entity.OilConInfo;
import com.thinkgem.jeesite.modules.business.entity.OilProcess;
import com.thinkgem.jeesite.modules.business.enu.ProStatus;
import com.thinkgem.jeesite.modules.business.service.OilBusInfoService;
import com.thinkgem.jeesite.modules.business.service.OilConInfoService;
import com.thinkgem.jeesite.modules.business.service.OilProcessService;
import com.thinkgem.jeesite.modules.business.service.OilProductsService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

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
	@Autowired
	private OilProcessService oilProcessService;
	@Autowired
	private OilConInfoService oilConInfoService;
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
		OilProcess oilProcess =new OilProcess();
		oilProcess.setPerName(UserUtils.getUser().getLoginName());
		oilBusInfo.setOilProcess(oilProcess);
		Page<OilBusInfo> page = oilBusInfoService.findPage(new Page<OilBusInfo>(request, response), oilBusInfo); 
		model.addAttribute("page", page);
		return "modules/business/oilBusInfoList";
	}
	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = {"listAll"})
	public String listAll(OilBusInfo oilBusInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OilBusInfo> page = oilBusInfoService.findPage(new Page<OilBusInfo>(request, response), oilBusInfo); 
		model.addAttribute("page", page);
		return "modules/business/oilBusInfoListAll";
	}
	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = "form")
	public String form(OilBusInfo oilBusInfo, Model model) {
		model.addAttribute("oilBusInfo", oilBusInfo);
		return "modules/business/oilBusInfoForm";
	}
	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = "formSe")
	public String formSe(OilBusInfo oilBusInfo, Model model) {
		oilBusInfo.getOilProcess().setStatus(ProStatus.bf_sucess.getCode());
		model.addAttribute("oilBusInfo", oilBusInfo);
		return "modules/business/oilBusInfoForm";
	}
	@RequiresPermissions("business:oilBusInfo:view")
	@RequestMapping(value = "show")
	public String show(OilBusInfo oilBusInfo, Model model) {
		model.addAttribute("oilBusInfo", oilBusInfo);
		//合同信息
		OilConInfo oilConInfo=new OilConInfo();
		oilConInfo.setFolwNumber(oilBusInfo.getFlowNumber());
		List<OilConInfo> list=oilConInfoService.findList(oilConInfo);
		if (list!=null&&list.size()!=0) {
			model.addAttribute("oilConInfo", list.get(0));
		}else {
			model.addAttribute("oilConInfo", null);
		}
		return "modules/business/oilBusInfoShow";
	}
	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "save")
	public String save(OilBusInfo oilBusInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilBusInfo)){
			return form(oilBusInfo, model);
		}
		if(oilBusInfo.getFlowNumber()!=null) {
			oilBusInfoService.save(oilBusInfo);
			OilProcess oilp=oilProcessService.findList(oilBusInfo.getOilProcess()).get(0);
			oilp.setStatus(oilBusInfo.getOilProcess().getStatus());
			oilProcessService.save(oilp);
		}else {
			String uuid=IdGen.uuid();
			oilBusInfo.setFlowNumber(uuid);
			oilBusInfoService.save(oilBusInfo);
			//流程
			OilProcess oilprocess=new OilProcess();
			oilprocess.setStatus(ProStatus.mb_sucess.getCode());
			oilprocess.setCNumber(uuid);
			oilprocess.setPerName(UserUtils.getUser().getLoginName());
			oilProcessService.save(oilprocess);
		}
		addMessage(redirectAttributes, "保存业务信息成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}
	
	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(OilBusInfo oilBusInfo, RedirectAttributes redirectAttributes) {
		oilBusInfoService.delete(oilBusInfo);
		oilProcessService.delete(oilBusInfo.getOilProcess());
		addMessage(redirectAttributes, "删除业务信息成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}
	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "end")
	public String end(OilBusInfo oilBusInfo, RedirectAttributes redirectAttributes) {
		OilProcess oilp=oilProcessService.findList(oilBusInfo.getOilProcess()).get(0);
		oilp.setStatus(ProStatus.sta_falie.getCode());
		oilProcessService.save(oilp);
		addMessage(redirectAttributes, "业务已终结");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}
	@RequiresPermissions("business:oilBusInfo:edit")
	@RequestMapping(value = "statusnext")
	public String statusnext(OilBusInfo oilBusInfo, RedirectAttributes redirectAttributes) {
		OilProcess oilp=oilProcessService.findList(oilBusInfo.getOilProcess()).get(0);
		String status=oilp.getStatus();
		if(ProStatus.yw_sucess.getCode().equals(status)) {
			oilp.setStatus(ProStatus.sh_sucess.getCode());
		}else {
			int st=Integer.valueOf(status)+1;
			oilp.setStatus("0"+st+"");
		}
		oilProcessService.save(oilp);
		addMessage(redirectAttributes, "业务状态调整成功");
		return "redirect:"+Global.getAdminPath()+"/business/oilBusInfo/?repage";
	}
}