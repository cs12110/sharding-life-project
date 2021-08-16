package com.sharding.life.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-13 18:06
 */
@Data
@TableName("t_order")
public class OrderDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;


    private Long userId;

    private Long orderId;

    private BigDecimal fee;

    private Date createTime;
}
