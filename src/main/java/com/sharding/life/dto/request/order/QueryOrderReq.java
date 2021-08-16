package com.sharding.life.dto.request.order;

import com.sharding.life.dto.request.PageReq;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-14 13:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryOrderReq extends PageReq {

    private Long userId;

    private Long orderId;
}
