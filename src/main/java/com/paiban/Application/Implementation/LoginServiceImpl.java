package com.paiban.Application.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.paiban.Application.LoginService;
import com.paiban.Domain.Repository.LoginMapper;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.Login;
import com.paiban.entity.LoginExample;
@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	LoginMapper mapper;
	public Message Login(String username, String password) {
		Map<String, Object> data = new HashMap<String, Object>();
		String msg = "";
		Boolean success = false;
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (!currentUser.isAuthenticated()) {
				// 使用shiro来验证
				token.setRememberMe(true);
				currentUser.login(token);// 验证角色和权限
			}
			msg = "登录成功";
			success = true;
		} catch (UnknownAccountException uae) {
			System.out.println(token.getPrincipal() + "账户不存在");
			msg = "账户不存在";
			success = false;
		} catch (IncorrectCredentialsException ice) {
			System.out.println(token.getPrincipal() + "密码不正确");
			msg = "密码不正确";
			success = false;
		} catch (LockedAccountException lae) {
			System.out.println(token.getPrincipal() + "用户被锁定了 ");
			msg = "用户被锁定了";
			success = false;
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			msg = ae.getMessage();
			success = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = "系统错误";
			success = false;
			// throw new BusinessException(LuoErrorCode.LOGIN_VERIFY_FAILURE);
		}
		data.put("msg", msg);
		data.put("success", success);
		Message message=new Message();
		message.msg=msg;
		message.code=success?0:-1;
		return message;
	}
	public Message UpdateInfo(String username, String password, String passwordnew) {
		String msg = "修改密码成功";
		int code = 0;
		if (username == null || username.length() == 0) {
			msg = "用户名不能为空";
			code = 404;
		} else if (password == null || password.length() == 0) {
			msg = "旧密码不能为空";
			code = 404;
		} else if (passwordnew == null || passwordnew.length() == 0) {
			msg = "新密码不能为空";
			code = 404;
		} else {
			LoginExample search = new LoginExample();
			search.createCriteria().andUsernameEqualTo(username);
			List<Login> list = mapper.selectByExample(search);
			Login login = list.size() < 1 ? null : list.get(0);
			if (login == null) {
				msg = "用户名不存在";
				code = 404;
			} else if (!password.equals(login.getPassword())) {
				msg = "旧密码不正确";
				code = 404;
			} else {
				LoginExample where = new LoginExample();
				where.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
				login.setPassword(passwordnew);
				int rowcount = mapper.updateByExampleSelective(login, where);
				if (rowcount > 0) {
					msg = "修改密码成功";
					code = 0;
				} else {
					msg = "修改密码时候发生错误，请重试";
					code = 500;
				}
			}
		}
		Message message=new Message();
		message.msg=msg;
		message.code=code;
		return message;
	}
	@Override
	public List<com.paiban.entity.Login> selectByExample(LoginExample search) {
		return mapper.selectByExample(search);
	}
}
