package com.sharding.life.ctrl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sharding.life.dto.request.order.QueryOrderReq;
import com.sharding.life.dto.response.Resp;
import com.sharding.life.entity.OrderDO;
import com.sharding.life.service.ShardingService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-10 11:03
 */
@RestController
@RequestMapping("/v1/sharding")
public class ShardingController {

    @Resource
    private ShardingService shardingService;

    @GetMapping("/page")
    public Resp page(QueryOrderReq queryOrderReq) {
        IPage<OrderDO> page = shardingService.getPage(queryOrderReq);
        return Resp.success(page);
    }

    @GetMapping("/list")
    public Resp list(Integer userId) {
        List<OrderDO> list = shardingService.getList(userId);
        return Resp.success(list);
    }

    @PostMapping("/save-order")
    public Resp saveOrder(@RequestBody OrderDO order) {
        shardingService.saveInfo(order);
        return Resp.success(order);
    }

    @DeleteMapping("/delete-order")
    public Resp deleteOrder(Long userId, Long orderId) {
        boolean result = shardingService.deleteOrder(userId, orderId);
        return Resp.success(result);
    }

    @PostMapping("/update-order")
    public Resp updateOrder(@RequestBody OrderDO order) {
        shardingService.updateInfo(order);
        return Resp.success(order);
    }
}
