package com.meishifeng.demo.service;

import com.meishifeng.demo.entity.Menu;
import com.meishifeng.demo.entity.SysUser;
import com.meishifeng.demo.model.SysUserDO;
import com.meishifeng.demo.utils.Response;

import java.util.List;

/**
 * <ul>
 * <li>用户类service</li>
 * <li>1.根据账号获取用户信息</li>
 * <li>2.获取用户权限菜单</li>
 * <li>User:meishifeng Date:2017/1/4 Time:10:43</li>
 * </ul>
 */
public interface SysUserService {

    /**
     * 根据账号获取用户信息
     * @param account   账号
     * @return
     */
    Response<SysUser> getSysUserByAccount(String account);

    /**
     * 获取用户权限菜单
     * @return
     */
    Response<List<Menu>> getUserMenuList();

}
