package com.paiban.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paiban.Application.LoginService;
import com.paiban.Application.Implementation.LoginServiceImpl;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.Login;
import com.paiban.entity.LoginExample;

@Controller
public class LoginController {

	@Resource
	LoginService service=new LoginServiceImpl();
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "login";
	}

	@RequestMapping(value = "/loginAjax", method = RequestMethod.POST)
	@ResponseBody
	public Message loginAjax(String username, String password) {
		Message data= service.Login(username,password);
		return data;
	}

//	@RequestMapping(value = "/logintest", method = RequestMethod.POST)
//	public ModelAndView Login1(String username, String password) {
//		Map<String, Object> data = new HashMap<String, Object>();
//		LoginExample search = new LoginExample();
//		search.createCriteria().andUsernameEqualTo(username);
//		// search.createCriteria().andPasswordEqualTo(password);
//		List<Login> loginlist = mapper.selectByExample(search);
//		String msg = "";
//		Boolean success = false;
//		if (loginlist == null || loginlist.size() == 0) {
//			msg = "用户名不正确";
//		} else if (!loginlist.get(0).getPassword().equals(password)) {
//			msg = "请输入正确的密码";
//		} else {
//			success = true;
//			msg = "登陆成功";
//		}
//
//		data.put("msg", msg);
//		data.put("success", success);
//		ModelAndView view = new ModelAndView("login", data);
//		return view;
//	}

	@RequestMapping(value = "/login/updateinfo", method = RequestMethod.GET)
	public String updateinfo() {
		return "login/updateinfo";
	}

	@RequestMapping(value = "/login/updateinfoajax", method = RequestMethod.POST)
	@ResponseBody
	public Message UpdateInfo(String username, String password, String passwordnew) {
		return service.UpdateInfo(username,password,passwordnew);
	}

}
