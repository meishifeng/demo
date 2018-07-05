package com.meishifeng.demo.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <ul>
 * <li>实体类基础</li>
 * <li>User:meishifeng Date:2017/1/4 Time:15:17</li>
 * </ul>
 */
@Data
@ToString(callSuper = false)
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -2561926069000779830L;

    /** 数据库主键 */
    private String id;

    /** 创建时间 */
    private Date createdAt;

    /** 创建人 */
    private String createdBy = "SYSTEM";

    /** 更新时间 */
    private Date updatedAt;

    /** 最后更新人 */
    private String updatedBy = "SYSTEM";

}
