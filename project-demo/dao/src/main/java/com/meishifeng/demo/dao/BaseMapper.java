package com.meishifeng.demo.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * <ul>
 * <li>基础Mapper</li>
 * <li>1.方法一说明</li>
 * <li>User:meishifeng Date:2017/1/4 Time:16:44</li>
 * </ul>
 */
public class BaseMapper extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
