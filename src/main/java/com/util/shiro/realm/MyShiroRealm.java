package com.util.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.paiban.Application.LoginService;
import com.paiban.Application.Implementation.LoginServiceImpl;
import com.paiban.Domain.Repository.LoginMapper;
import com.paiban.entity.Login;
import com.paiban.entity.LoginExample;

public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	LoginMapper mapper;

	/*
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		String userName = (String) getAvailablePrincipal(principals);
		if (userName.equals("admin")) {

			roleNames.add("admin");// 添加角色
			permissions.add("newPage.jhtml"); // 添加权限

		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		System.out.println("doGetAuthorizationInfo");
		return info;
	}

	/*
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		System.out.println("doGetAuthenticationInfo.token.getUsername().equals(USER_NAME)"
//				+ token.getUsername().equals(USER_NAME));
//		if (token.getUsername().equals(USER_NAME)) {
//			// return new SimpleAuthenticationInfo(USER_NAME, DecriptUtil.MD5(PASSWORD),
//			// getName());
//			return new SimpleAuthenticationInfo(USER_NAME, PASSWORD, getName());
//		} else {
//			throw new AuthenticationException();
//		}
		String username = token.getUsername();
		String password = new String(token.getPassword());
		LoginExample search = new LoginExample();
		search.createCriteria().andUsernameEqualTo(username);
		List<Login> loginlist = mapper.selectByExample(search);
		String msg = "";
		Boolean success = false;
		if (loginlist == null || loginlist.size() == 0) {
			msg = "用户名不正确";
		} else if (!loginlist.get(0).getPassword().equals(password)) {
			msg = "请输入正确的密码";
		} else {
			success = true;
			msg = "登陆成功";
		}
		if (success) {
			return new SimpleAuthenticationInfo(username, password, getName());
		} else {
			throw new AuthenticationException(msg);
		}
	}

}