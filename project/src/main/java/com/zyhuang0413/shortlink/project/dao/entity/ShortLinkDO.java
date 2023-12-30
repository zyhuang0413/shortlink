package com.zyhuang0413.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author zyhuang
 * Date: 2023/12/31
 * Time: 0:06
 * Description: 短链接持久层实体
 */
@Data
@TableName("t_link")
public class ShortLinkDO {

    /**
     * id
     */
    private Long id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 启用标识 0：未启用 1：已启用
     */
    private int enableStatus;

    /**
     * 创建类型 0：控制台 1：接口
     */
    private int createdType;

    /**
     * 有效期类型 0：永久有效 1：用户自定义
     */
    private int validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    private String describe;

}
