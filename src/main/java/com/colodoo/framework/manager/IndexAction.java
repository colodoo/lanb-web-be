package com.colodoo.framework.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.colodoo.framework.common.Msg;

@Controller
@RequestMapping(value = {"/", ""})
public class IndexAction {
	
	@RequestMapping(value = "/notRole")
    @ResponseBody
	public Msg noRole() {
		Msg msg = new Msg(false, "", "您所登录用户,没有该权限!");
        return msg;
	}
}
