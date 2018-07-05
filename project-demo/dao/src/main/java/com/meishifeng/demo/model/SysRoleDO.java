package com.meishifeng.demo.model;

import lombok.Data;

/**
 * <ul>
 * <li>角色数据对象实体类</li>
 * <li>User:meishifeng Date:2017/1/4 Time:15:25</li>
 * </ul>
 */
@Data
public class SysRoleDO extends BaseDO {

    private String name;        //角色名称
    private String description; //角色描述
    private int sort;           //排序
    private int isUsed;         //该角色是否有效，取值Y或N

}
