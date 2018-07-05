package com.meishifeng.demo.model;

import lombok.Data;

/**
 * <ul>
 * <li>权限数据对象实体类</li>
 * <li>User:meishifeng Date:2017/1/4 Time:15:25</li>
 * </ul>
 */

@Data
public class SysPermissionDO extends BaseDO {

    private String pId;     //父权限ID
    private String name;    //权限名称
    private int sort;       //排序，数据越大排序越靠后
    private int isShow;     //菜单是否显示（1显示，0不显示）
    private int isUsed;      //是否在用，Y为生效的权限管理，否则为N
    private String url;     //拥有该权限操作后跳转的目的url
    private String iconcls; //easyUI的样式图标

}
