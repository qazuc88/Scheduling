package kye;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 配置类*/
public class Config {
	static{
		 HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		SiteRoot=request.getContextPath();
	}
	/**
	 * 网站根目录*/
 public static String SiteRoot;
	/**
	 * 版本*/
 public static String Version="1.0";
 /**
  * 时区*/
 public static String TimeZone="UTC-8";
}
