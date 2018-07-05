package com.meishifeng.demo.web.controller;

import com.google.common.base.Strings;
import com.meishifeng.demo.entity.Menu;
import com.meishifeng.demo.entity.SysUser;
import com.meishifeng.demo.service.SysUserService;
import com.meishifeng.demo.utils.*;
import com.meishifeng.demo.web.utils.AjaxInfoUtils;
import com.meishifeng.demo.web.utils.Md5Utils;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <ul>
 * <li>登录controller</li>
 * <li>1.用户登录</li>
 * <li>2.登录成功之后查询用户拥有的权限跳转到主界面</li>
 * <li>User:meishifeng Date:2018/05/10 Time:17:01</li>
 * </ul>
 */
@Controller
@Api(value = "登录", description = "登录方法集合")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户登录
     * @param request
     * @param response
     */
    @RequestMapping(value = "userLogin",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录",notes = "用户登录并返回登录结果信息",httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    public void userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "account", required = true)String account,
            @RequestParam(value = "password", required = true)String password
    ) throws IOException {
        String msg = "";
        String code = Constants.HTTP_STATUS_CODE_404;
        if (!Strings.isNullOrEmpty(account) && !Strings.isNullOrEmpty(password)) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, Md5Utils.getMD5ofStr(password));
            try {
                if (subject.isAuthenticated()) {
                    subject.logout();
                }
                subject.login(token);
                subject.getSession().setTimeout(PropertiesUtil.getLong("userSession.timeout"));//毫秒
                token.setRememberMe(true);
                code = Constants.HTTP_STATUS_CODE_200;
                msg = Constants.LOGIN_RESPONSE_STATUS_SUCCESS;
            } catch (IncorrectCredentialsException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_ERROR;
                System.out.println(msg);
            } catch (ExcessiveAttemptsException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_FILATOMUCH;
                System.out.println(msg);
            } catch (LockedAccountException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_LOCKING + "The account for username " + token.getPrincipal() + " was locked.";
                System.out.println(msg);
            } catch (DisabledAccountException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_DISABLE + "The account for username " + token.getPrincipal() + " was disabled.";
                System.out.println(msg);
            } catch (ExpiredCredentialsException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_EXPIRED + "The account for username " + token.getPrincipal() + "  was expired.";
                System.out.println(msg);
            } catch (UnknownAccountException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_NONEXISTENT + "There is no user with username of " + token.getPrincipal();
                System.out.println(msg);
            } catch (UnauthorizedException e) {
                msg = Constants.LOGIN_RESPONSE_STATUS_NOAUTHORIZATION + e.getMessage();
                System.out.println(msg);
            }

        }
        AjaxInfoUtils.setJsonObjResponseToWeb(new Result(code,msg,null),response);
    }

    /**
     * 登录成功之后查询用户拥有的权限跳转到主界面
     * @return
     */
    @RequestMapping(value = "index.html")
    public ModelAndView index(){
        SysUser user = ShiroUser.getCurrentUserInfo();
        //获取用户权限菜单
        Response<List<Menu>> res = sysUserService.getUserMenuList();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("menus", res.getResult());
        return modelAndView;
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "login.html")
    public String login(){
        return "login";
    }

    /**
     * 跳转到欢迎页面
     * @return
     */
    @RequestMapping(value = "welcome")
    public String indexHtml(){
        return "welcome/welcome";
    }

}
