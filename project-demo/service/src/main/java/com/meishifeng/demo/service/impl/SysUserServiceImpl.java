package com.meishifeng.demo.service.impl;

import com.meishifeng.demo.dao.SysPermissionMapper;
import com.meishifeng.demo.dao.SysRoleMapper;
import com.meishifeng.demo.dao.SysUserMapper;
import com.meishifeng.demo.entity.Menu;
import com.meishifeng.demo.entity.SysRole;
import com.meishifeng.demo.entity.SysUser;
import com.meishifeng.demo.model.SysPermissionDO;
import com.meishifeng.demo.model.SysRoleDO;
import com.meishifeng.demo.model.SysUserDO;
import com.meishifeng.demo.service.SysUserService;
import com.meishifeng.demo.utils.BeanMapperUtil;
import com.meishifeng.demo.utils.ShiroUser;
import com.meishifeng.demo.utils.Response;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <ul>
 * <li>用户类service实现类</li>
 * <li>1.根据账号获取用户信息</li>
 * <li>2.根据用户id获取该用户所有的角色</li>
 * <li>3.获取用户权限菜单</li>
 *
 * <li>User:meishifeng Date:2017/1/4 Time:10:45</li>
 * </ul>
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 根据账号获取用户信息
     * @param account   账号
     * @return
     */
    @Override
    public Response<SysUser> getSysUserByAccount(String account){
        Response<SysUser> res = new Response<SysUser>();
        SysUserDO sysUserDO = sysUserMapper.selectSysUserByAccount(account);
        SysUser sysUser = new SysUser();
        BeanMapperUtil.copy(sysUserDO, sysUser);
        SysUser sysUserShiro = ShiroUser.getCurrentUserInfo();
        if (sysUserShiro != null && sysUser.getId().equalsIgnoreCase(sysUserShiro.getId()) && sysUserShiro.getRoles() != null) {
            sysUser = sysUserShiro;
        } else {
            List<SysRole> sysRoles = new ArrayList<SysRole>();
            if (sysUser.getAccount().equalsIgnoreCase("admin")){
                sysRoles = getSysRoles(null);
            } else {
                sysRoles = getSysRoles(sysUser.getId());
            }
            sysUser.setRoles(sysRoles);
        }
        res.setResult(sysUser);
        return res;
    }

    /**
     * 根据用户id获取该用户所有的角色
     * @param userId    用户id
     * @return
     */
    public List<SysRole> getSysRoles(String userId){
        List<SysRoleDO> sysRoleDOs = sysRoleMapper.selectSysRoleByUserId(userId);
        List<SysRole> sysRoles = BeanMapperUtil.mapList(sysRoleDOs, SysRole.class);
        for (SysRole sysRole : sysRoles) {
            //根据角色id查询该角色拥有的所有资源
            List<SysPermissionDO> sysPermissionDOS = sysPermissionMapper.selectSysPermissionByRoleId(sysRole.getId());
            //将查询到的资源集合设置到角色对象中
            sysRole.setPermissions(sysPermissionDOS);
        }
        return sysRoles;
    }

    /**
     * 获取用户权限菜单
     * @return
     */
    @Override
    public Response<List<Menu>> getUserMenuList(){
        SysUser sysUser = ShiroUser.getCurrentUserInfo();
        List<SysRole> sysRoles = sysUser.getRoles();//获取用户所有角色
        Set<SysPermissionDO> sysPermissionDOS = new HashSet<SysPermissionDO>();//存放用户所拥有的所有的权限，因为不同角色可能会拥有同样的权限，所以用set集合去重
        for (SysRole sysRole : sysRoles) {
            List<SysPermissionDO> list = sysRole.getPermissions();//获取该角色的所有权限（资源）
            sysPermissionDOS.addAll(list);
        }

        List<Menu> menus = new ArrayList<Menu>();//用户菜单列表，存放所有菜单（资源/权限），菜单信息同步该用户的权限（资源）
        for (SysPermissionDO sysPermissionDO : sysPermissionDOS) {
            Menu menu = new Menu();
            BeanMapperUtil.copy(sysPermissionDO, menu);
            menus.add(menu);
        }

        List<Menu> menuList = new ArrayList<Menu>();//一级菜单（资源/权限）
        //遍历所有菜单，取出一级菜单，并将其子菜单设置其中
        for (Menu menu : menus) {
            if (StringUtils.isNullOrEmpty(menu.getPId())){
                List<Menu> subMenuList = new ArrayList<Menu>();//子菜单
                //遍历所有菜单，如果某个菜单的父id是上一级遍历对象的id，那么该菜单即是该上一级菜单对象的子菜单
                for (Menu m : menus) {
                    if (m.getPId().equalsIgnoreCase(menu.getId())){
                        subMenuList.add(m);
                    }
                }
                menu.setSubList(subMenuList);
                menuList.add(menu);
            }
        }

        Response<List<Menu>> res = new Response<List<Menu>>();
        res.setResult(menuList);
        return res;
    }


}
