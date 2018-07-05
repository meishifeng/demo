package com.meishifeng.demo.entity;

import com.meishifeng.demo.model.SysPermissionDO;
import com.meishifeng.demo.model.SysRoleDO;
import com.meishifeng.demo.model.SysUserDO;
import com.meishifeng.demo.model.SysUserRoleDO;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <ul>
 * <li>用户信息实体类</li>
 * <li>User:meishifeng Date:2018/04/26 Time:10:12</li>
 * </ul>
 */

@Data
public class SysUser extends SysUserDO {
    /**
     * 用户角色
     */
    private List<SysRole> roles;
    /**
     * 用户角色
     */
    private List<String> roleIds;

    private String version;

    private String token;

    private List<SysUserRoleDO> urList;

    public Set<String> rolesSet() {
        Set<String> sets = new HashSet<>();
        for (SysRoleDO role : getRoles()) {
            sets.add(role.getName());
        }
        return sets;
    }

    public Set<String> permissionsSet() {
        Set<String> sets = new HashSet<>();
        for (SysRole role : getRoles()) {
            for (SysPermissionDO permission : role.getPermissions()) {
                //sets.add(permission.getShiroPermission());
                sets.add(permission.getUrl());
            }
        }
        return sets;
    }
}
