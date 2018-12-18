package com.paiban.controller;

import java.util.HashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView index() {
		HashMap<String,Object> list=new HashMap<String,Object>();
		Object obj= SecurityUtils.getSubject().getPrincipal();
		list.put("username", obj);
		return new ModelAndView("home/index",list);
	}
}
