package com.paiban.Application;


import java.util.List;

import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.LoginExample;

public interface LoginService extends ApplicationService {

	Message Login(String username, String password);

	Message UpdateInfo(String username, String password, String passwordnew);

	List<com.paiban.entity.Login> selectByExample(LoginExample search);

}
