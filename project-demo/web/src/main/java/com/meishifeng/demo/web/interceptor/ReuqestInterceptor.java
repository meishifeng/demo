package com.meishifeng.demo.web.interceptor;

import com.meishifeng.demo.entity.SysUser;
import com.meishifeng.demo.service.SysUserService;
import com.meishifeng.demo.utils.ShiroUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <ul>
 * <li>类名</li>
 * <li>1.方法一说明</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/04 Time:15:31</li>
 * </ul>
 */
public class ReuqestInterceptor implements HandlerInterceptor{

    @Autowired
    private SysUserService sysUserService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object var3) throws Exception{

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            return true;
        }
        SysUser sysUser = null;
        String account = (String)subject.getPrincipal();
        if(StringUtils.isNotBlank(account)){
            Session session = subject.getSession();
            sysUser = (SysUser)session.getAttribute(ShiroUser.SHIRO_USER);
            if(null == sysUser || !StringUtils.equals(sysUser.getAccount(), account)){
                sysUser = sysUserService.getSysUserByAccount(account).getResult();
                session.setAttribute(ShiroUser.SHIRO_USER, sysUser);
            }
        }
        if(null == sysUser){
            subject.logout();
        }
        request.setAttribute(ShiroUser.SHIRO_USER,sysUser);
        return true;
    }

    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{

    }


    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{

    }

}
