package com.meishifeng.demo.model;

import com.meishifeng.demo.model.BaseDO;
import lombok.Data;

/**
 * <ul>
 * <li>角色权限实体类</li>
 * <li>User:meishifeng Date:2018/04/25 Time:15:24</li>
 * </ul>
 */
@Data
public class SysRolePermDO extends BaseDO {

    private String roleID;          //角色ID
    private String permissionID;    //权限ID
    private int isUsed;             //该角色是否有效，取值Y或N

}
