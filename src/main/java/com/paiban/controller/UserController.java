package com.paiban.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {

    @RequestMapping("/index.jhtml")
    public ModelAndView getIndex(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/exceptionForPageJumps.jhtml")
    public String exceptionForPageJumps(HttpServletRequest request) throws Exception {
       return " throw new BusinessException(LuoErrorCode.NULL_OBJ);";
    }

    @RequestMapping(value="/businessException.json", method=RequestMethod.POST)
    @ResponseBody  
    public String businessException(HttpServletRequest request) {
       return "LuoErrorCode.NULL_OBJ";
    }

    @RequestMapping(value="/otherException.json", method=RequestMethod.POST)
    @ResponseBody  
    public String otherException(HttpServletRequest request) throws Exception {
        throw new Exception();
    }

    //跳转到登录页面
    @RequestMapping("/login.jhtml")
    public ModelAndView login() throws Exception {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    //跳转到登录成功页面
    @RequestMapping("/loginsuccess.jhtml")
    public ModelAndView loginsuccess() throws Exception {
        ModelAndView mav = new ModelAndView("loginsuccess");
        return mav;
    }

    @RequestMapping("/newPage.jhtml")
    public ModelAndView newPage() throws Exception {
        ModelAndView mav = new ModelAndView("newPage");
        return mav;
    }

    @RequestMapping("/newPageNotAdd.jhtml")
    public ModelAndView newPageNotAdd() throws Exception {
        ModelAndView mav = new ModelAndView("newPageNotAdd");
        return mav;
    }

    /** 
     * 验证用户名和密码 
     * @param String username,String password
     * @return 
     */  
    @RequestMapping(value="/checkLogin.json",method=RequestMethod.POST)  
    @ResponseBody  
    public Object checkLogin(String username,String password) {  
        Map<String, Object> result = new HashMap<String, Object>();
        boolean success=true;
    	UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        try{
            //UsernamePasswordToken token = new UsernamePasswordToken(username, DecriptUtil.MD5(password));  
            Subject currentUser = SecurityUtils.getSubject();  
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证  
                token.setRememberMe(true);  
                currentUser.login(token);//验证角色和权限  
            } 
        }
        catch (UnknownAccountException uae) {
            System.out.println(token.getPrincipal() + "账户不存在");
        	success=false;
        } catch (IncorrectCredentialsException ice) {
            System.out.println(token.getPrincipal() + "密码不正确");
        	success=false;
        } catch (LockedAccountException lae) {
        	System.out.println(token.getPrincipal() + "用户被锁定了 ");
        	success=false;
        } catch (AuthenticationException ae) {
            //无法判断是什么错了
        	System.out.println(ae.getMessage());
        	success=false;
        }catch(Exception ex){
        	ex.printStackTrace();
        	success=false;
            //throw new BusinessException(LuoErrorCode.LOGIN_VERIFY_FAILURE);
        }
        result.put("success", success);
        return result;  
    }  

    /** 
     * 退出登录
     */  
    @RequestMapping(value="/logout",method=RequestMethod.GET)    
    public String logout() {   
        Subject currentUser = SecurityUtils.getSubject();       
        currentUser.logout();    
        return "redirect:/login";
    }  
}