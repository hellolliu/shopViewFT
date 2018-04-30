package com.thinkgem.jeesite.modules.business.enu;

import java.util.Date;

public enum ProStatus {
	//流程状态：①陌拜阶段：陌拜中、陌拜成功（业务信息表，进入后续拜访阶段）、陌拜失败了（流程终止）
	//②后续拜访（多次）：拜访成功（补充或者更改业务信息表，业务的确认）、拜访失败（再次拜访或者流程终止），
	//业务确定：业务确认（向前台确认库存情况，产生合同信息，产生订货信息），
	sta_falie("0000"),mb_sucess("0101"),bf_sucess("0201"),yw_sucess("0301"),
	//供货跟踪:等待预付款、预付款到账未发货、预付到账已发货、尾款到账未发货、尾款到账已发货。
	sh_sucess("0401"),fp_sucess("0402"),dk_sucess("0403"),qz_sucess("0404"),sd_success("0405");
	private String code;
	private ProStatus(String code) {
		this.code=code;
	}
	public String getCode() {
		return code;
	}
}
