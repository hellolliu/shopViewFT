/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.business.web;


import java.util.List;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.business.entity.OilProducts;
import com.thinkgem.jeesite.modules.business.entity.OilStockIn;
import com.thinkgem.jeesite.modules.business.entity.OilStockSitua;
import com.thinkgem.jeesite.modules.business.service.OilProductsService;
import com.thinkgem.jeesite.modules.business.service.OilStockInService;
import com.thinkgem.jeesite.modules.business.service.OilStockSituaService;

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
	@Autowired
	private OilProductsService oilProductsService;
	@Autowired
	private OilStockSituaService oilStockSituaService;
	
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
		model.addAttribute("oilProducts", oilProductsService.findList(new OilProducts()));
		return "modules/business/oilStockInForm";
	}

	@RequiresPermissions("business:oilStockIn:edit")
	@RequestMapping(value = "save")
	public String save(OilStockIn oilStockIn, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oilStockIn)){
			return form(oilStockIn, model);
		}
		oilStockInService.save(oilStockIn);//进货保存成功
		
		OilProducts oilentity=new OilProducts();
		oilentity.setGname(oilStockIn.getPurchaseGname());
		OilProducts oil=oilProductsService.findList(oilentity).get(0);//查询出商品
		OilStockSitua situtaen=new OilStockSitua();
		situtaen.setGname(oil.getGname());
		situtaen.setPrpSn(oil.getPrpSn());
		List<OilStockSitua> list=oilStockSituaService.findList(situtaen);//商品的存储状态
		OilStockSitua oilStockSitua= new OilStockSitua();
		//计算总价
		if (list.size()!=0) {
			oilStockSitua=list.get(0);
			double value=Double.valueOf(oilStockSitua.getFactno())*Double.valueOf(oilStockSitua.getPurchasePrice());
			value+=Double.valueOf(oilStockIn.getPurchasePrice())*Double.valueOf(oilStockIn.getPurchaseQuantity());
			oilStockSitua.setFactno((Double.valueOf(oilStockSitua.getFactno())+Double.valueOf(oilStockIn.getPurchaseQuantity()))+"");
			oilStockSitua.setPurchasePrice((value/(Double.valueOf(oilStockSitua.getFactno())))+"");
		}else {
			oilStockSitua.setGname(oil.getGname());
			oilStockSitua.setPrpSn(oil.getPrpSn());
			oilStockSitua.setFactno(oilStockIn.getPurchaseQuantity());
			oilStockSitua.setPurchasePrice(oilStockIn.getPurchasePrice());
		}
		oilStockSituaService.save(oilStockSitua);
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