package com.meishifeng.demo.dao;

import com.meishifeng.demo.model.SysPermissionDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <ul>
 * <li>资源表mapper</li>
 * <li>1.根据角色id查询该角色拥有的所有资源</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/04 Time:11:17</li>
 * </ul>
 */
@Repository
public class SysPermissionMapper extends BaseMapper {

    /**
     * 根据角色id查询该角色拥有的所有资源
     * @param roleId    角色id
     * @return
     */
    public List<SysPermissionDO> selectSysPermissionByRoleId(String roleId){
        List<SysPermissionDO> sysPermissionDOS = getSqlSession().selectList("SysPermissionMapper.selectSysPermissionByRoleId", roleId);
        return sysPermissionDOS;
    }


}
