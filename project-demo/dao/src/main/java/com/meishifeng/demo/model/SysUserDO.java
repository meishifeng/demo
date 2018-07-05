package com.meishifeng.demo.model;

import com.meishifeng.demo.model.BaseDO;
import lombok.Data;

/**
 * <ul>
 * <li>用户信息实体类</li>
 * <li>User:meishifeng Date:2017/1/4 Time:15:25</li>
 * </ul>
 */
@Data
public class SysUserDO extends BaseDO {

    private String account; //账号
    private String password;//密码
    private String name;    //用户姓名
    private String gender;  //性别
    private String email;   //邮箱
    private String phone;   //电话号码
    private String adress;  //地址
    private String remark;  //备注
    private int isUsed;     //用户是否有效,0: 无效  1：有效  数据来于数据字典 类型：YESNO

}
