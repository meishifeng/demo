package com.meishifeng.demo.dao;

import com.meishifeng.demo.model.SysUserDO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>用户信息mapper</li>
 * <li>1.方法一说明</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2017/1/4 Time:16:56</li>
 * </ul>
 */
@Repository
public class SysUserMapper extends BaseMapper {

    public SysUserDO selectSysUserByAccount(String account){
        SysUserDO sysUserDO = getSqlSession().selectOne("SysUserMapper.selectSysUserByAccount", account);
        return sysUserDO;
    }

}
