package com.meishifeng.demo.dao;

import com.meishifeng.demo.model.SysRoleDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <ul>
 * <li>角色表mapper</li>
 * <li>1.根据用户id查询该用户拥有的所有角色信息</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/04 Time:11:19</li>
 * </ul>
 */
@Repository
public class SysRoleMapper extends BaseMapper {

    /**
     * 根据用户id查询该用户拥有的所有角色信息
     * @param userId    用户id
     * @return
     */
    public List<SysRoleDO> selectSysRoleByUserId(@Param(value="userId")String userId){
        List<SysRoleDO> sysRoleDOS = getSqlSession().selectList("SysRoleMapper.selectSysRoleByUserId", userId);
        return sysRoleDOS;
    }

}
