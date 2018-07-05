package com.meishifeng.demo.utils;

import com.meishifeng.demo.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * 
 * ClassName: ShiroUser
 * @Description: TODO
 * @author longtj
 * @date 2017年7月17日 上午10:13:08
 */
public class ShiroUser {
	
	public static final String SHIRO_USER = "shiro_user";
	
	private ShiroUser(){
		
	}
	
	public static SysUser getCurrentUserInfo(){
		Subject subject = SecurityUtils.getSubject();
		if(subject==null){
			return null;
		}else{
			Session session = subject.getSession(false);
			if(session==null){
				return null;
			}else{
				return (SysUser) session.getAttribute(SHIRO_USER);
			}
		}
	}
	
}
