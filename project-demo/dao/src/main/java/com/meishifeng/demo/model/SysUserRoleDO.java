package com.meishifeng.demo.model;

import com.meishifeng.demo.model.BaseDO;
import lombok.Data;

/**
 * <ul>
 * <li>用户角色实体类</li>
 * <li>User:meishifeng Date:2018/04/25 Time:15:27</li>
 * </ul>
 */
@Data
public class SysUserRoleDO extends BaseDO {

    private String userId;  //用户ID
    private String roleId;  //角色ID
    private int isUsed;      //该角色是否有效，0: 无效   1：有效   数据来源于数据字典 编码为 YESNO

}
