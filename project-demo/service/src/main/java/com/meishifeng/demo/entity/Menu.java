package com.meishifeng.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <ul>
 * <li>类名</li>
 * <li>1.方法一说明</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/05 Time:10:46</li>
 * </ul>
 */

@Data
public class Menu implements Serializable {

    /**权限ID*/
    private String id;
    /**父权限ID*/
    private String pId;

    /**菜单名称**/
    private String name;

    /**菜单url**/
    private String url;
    /**
     * 是否显示（0不显示菜单，1显示菜单）
     */
    private Integer isShow;

    /**
     * 子菜单集合
     */
    private List<Menu> subList;

}
