package com.zyhuang0413.shortlink.admin.common.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 20:58
 * Description: 数据库持久层对象基础属性
 */
@Data
public class BaseDO {

     /**
      * 创建时间
      */
     @TableField(fill = FieldFill.INSERT)
     private Date createTime;

     /**
      * 修改时间
      */
     @TableField(fill = FieldFill.INSERT_UPDATE)
     private Date updateTime;

     /**
      * 删除标识 0：未删除 1：已删除
      */
     @TableField(fill = FieldFill.INSERT)
     private Integer delFlag;

}
