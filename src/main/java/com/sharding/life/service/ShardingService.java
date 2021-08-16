package com.sharding.life.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.life.dto.request.order.QueryOrderReq;
import com.sharding.life.entity.OrderDO;
import com.sharding.life.mapper.OrderMapper;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-13 17:59
 */
@Service
public class ShardingService extends ServiceImpl<OrderMapper, OrderDO> {

    public void saveInfo(OrderDO order) {
        baseMapper.insert(order);
    }

    public List<OrderDO> getList(Integer userId) {
        LambdaQueryWrapper<OrderDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(userId)) {
            lambdaQueryWrapper.eq(OrderDO::getUserId, userId);
        }
        return baseMapper.selectList(lambdaQueryWrapper);
    }

    public IPage<OrderDO> getPage(QueryOrderReq queryOrderReq) {
        LambdaQueryWrapper<OrderDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(queryOrderReq.getUserId())) {
            lambdaQueryWrapper.eq(OrderDO::getUserId, queryOrderReq.getUserId());
        }

        if (Objects.nonNull(queryOrderReq.getOrderId())) {
            lambdaQueryWrapper.eq(OrderDO::getOrderId, queryOrderReq.getOrderId());
        }

        Page<OrderDO> page = new Page<>(queryOrderReq.getPageNumber(), queryOrderReq.getPageSize());

        return baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    public boolean deleteOrder(Long userId, Long orderId) {
        LambdaUpdateWrapper<OrderDO> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        if (Objects.nonNull(orderId)) {
            lambdaUpdateWrapper.eq(OrderDO::getOrderId, orderId);
        }
        if (Objects.nonNull(userId)) {
            lambdaUpdateWrapper.eq(OrderDO::getUserId, userId);
        }

        int delete = baseMapper.delete(lambdaUpdateWrapper);

        return delete > 0;
    }

    public void updateInfo(OrderDO order) {
        LambdaUpdateWrapper<OrderDO> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        if (Objects.nonNull(order.getUserId())) {
            lambdaUpdateWrapper.eq(OrderDO::getUserId, order.getUserId());
        }
        if (Objects.nonNull(order.getOrderId())) {
            lambdaUpdateWrapper.eq(OrderDO::getOrderId, order.getOrderId());
        }

        lambdaUpdateWrapper.set(OrderDO::getFee, order.getFee());

        baseMapper.update(null, lambdaUpdateWrapper);
    }
}
