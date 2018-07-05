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
 * <li>shiro请求拦截器</li>
 * <li>User:meishifeng Date:2018/05/04 Time:15:31</li>
 * </ul>
 */
public class ReuqestInterceptor implements HandlerInterceptor{

    @Autowired
    private SysUserService sysUserService;

    /**
     * 该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，
     * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
     * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；
     * @param request
     * @param response
     * @param var3
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object var3) throws Exception{

        Subject subject = SecurityUtils.getSubject();

        //如果没有认证，则继续执行接下来的方法，拦截器的任务到此为止
        if (!subject.isAuthenticated()){
            return true;
        }
        SysUser sysUser = null;
        String account = (String)subject.getPrincipal();
        //如果shiro中的账号存在，则取出session中的用户对象
        if(StringUtils.isNotBlank(account)){
            Session session = subject.getSession();
            sysUser = (SysUser)session.getAttribute(ShiroUser.SHIRO_USER);
            //如果session中取出的用户对象为null或者与shiro中的账号不一致，则从数据库中根据账号查找出对象，再讲其设置到session中去
            if(null == sysUser || !StringUtils.equals(sysUser.getAccount(), account)){
                sysUser = sysUserService.getSysUserByAccount(account).getResult();
                session.setAttribute(ShiroUser.SHIRO_USER, sysUser);
            }
        }
        //如果session中的账号不存在，则登出
        if(null == sysUser){
            subject.logout();
        }
//        request.setAttribute(ShiroUser.SHIRO_USER,sysUser);
        return true;
    }

    /**
     * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
     * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     * @throws Exception
     */
    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，
     * 也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{

    }

}
