package com.meishifeng.demo.web.shiro;

import com.meishifeng.demo.entity.SysUser;
import com.meishifeng.demo.service.SysUserService;
import com.meishifeng.demo.utils.Response;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

/**
 * <ul>
 * <li>shiro Realm</li>
 * <li>User:meishifeng Date:2018/04/26 Time:09:59</li>
 * </ul>
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取授权信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("用户账号信息集合 方法参数不能为空！");
        }
        String account = (String) getAvailablePrincipal(principals);
        try {
            Response<SysUser> res = sysUserService.getSysUserByAccount(account);
            SysUser sysUser = res.getResult();
            checkUser(sysUser, account);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(sysUser.rolesSet());
            info.setStringPermissions(sysUser.permissionsSet());
            return info;
        } catch (Exception e) {
            throw translateAuthenticationException(e);
        }
    }

    /**
     * 获取身份验证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String account = passwordToken.getUsername();
        if(StringUtils.isBlank(account)) {
            throw new AccountException("Null accounts are not allowed by this realm.");
        }
        try {
            //检查根据账号获取到的用户信息
            Response<SysUser> res = sysUserService.getSysUserByAccount(account);
            SysUser sysUser = res.getResult();
            //检查根据账号获取到的用户信息
            checkUser(sysUser, account);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account, sysUser.getPassword().toCharArray(), getName());
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(account));
            return authenticationInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw translateAuthenticationException(e);
        }
    }

    /**
     * 检查根据账号获取到的用户信息
     * @param user      用户信息类
     * @param account   账号
     */
    private void checkUser(SysUser user, String account) {
        if (null == user) {
            throw new UnknownAccountException("没有为账号 [" + account + "]" + "找到对应的用户信息！");
        }
        if(0 == user.getIsUsed()) {
            throw new LockedAccountException("账号 [" + account + "]" + "无效！");
        }
    }

    /**
     * 将异常封装成指定类型的
     * @param e
     * @return
     */
    private AuthenticationException translateAuthenticationException(Exception e) {
        if (e instanceof AuthenticationException) {
            return (AuthenticationException) e;
        }
        return new AuthenticationException(e);
    }

}
