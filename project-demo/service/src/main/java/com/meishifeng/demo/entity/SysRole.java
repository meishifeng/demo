package com.meishifeng.demo.entity;

import com.meishifeng.demo.model.SysPermissionDO;
import com.meishifeng.demo.model.SysRoleDO;
import lombok.Data;

import java.util.List;

/**
 * <ul>
 * <li>角色实体类</li>
 * <li>User:meishifeng Date:2018/04/26 Time:10:13</li>
 * </ul>
 */

@Data
public class SysRole extends SysRoleDO {

    /**
     * 用户是否有该角色
     */
    private boolean check;

    /**
     * 角色权限
     */
    private List<SysPermissionDO> permissions;

}
