package com.knife.example.business.order.core.business.order.controller;

import com.knife.example.business.account.core.business.amount.account.api.AmountFeignClient;
import com.knife.example.business.account.core.business.amount.account.api.amount.bo.AmountDecreaseBO;
import com.knife.example.business.order.core.business.order.bo.OrderBO;
import com.knife.example.business.storage.api.ProductFeignClient;
import com.knife.example.business.storage.api.product.bo.ProductDecreaseBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单")
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private AmountFeignClient amountFeignClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    // @Value("${custom.timeout}")
    // private Integer timeout;

    // 正常流程
    @ApiOperation("创建订单")
    @PostMapping("create")
    public String create(@RequestBody OrderBO orderBO) {
        log.info("订单服务：创建订单：{}", orderBO);

        ProductDecreaseBO productDecreaseBO = new ProductDecreaseBO();
        productDecreaseBO.setProductId(orderBO.getProductId());
        productDecreaseBO.setCount(orderBO.getCount());
        productFeignClient.decreaseStorage(productDecreaseBO);

        AmountDecreaseBO amountDecreaseBO = new AmountDecreaseBO();
        amountDecreaseBO.setUserId(orderBO.getUserId());
        amountDecreaseBO.setAmount(orderBO.getAmount());
        amountFeignClient.decreaseMoney(amountDecreaseBO);

        return "创建订单成功";
    }

    // 在减库存时刻意抛出异常
    @ApiOperation("创建订单（抛异常）")
    @PostMapping("createFault")
    public String createFault(@RequestBody OrderBO orderBO) {
        log.error("订单服务：创建订单刻意抛出异常：{}", orderBO);

        ProductDecreaseBO productDecreaseBO = new ProductDecreaseBO();
        productDecreaseBO.setProductId(orderBO.getProductId());
        productDecreaseBO.setCount(orderBO.getCount());
        productFeignClient.decreaseStorageFault(productDecreaseBO);

        AmountDecreaseBO amountDecreaseBO = new AmountDecreaseBO();
        amountDecreaseBO.setUserId(orderBO.getUserId());
        amountDecreaseBO.setAmount(orderBO.getAmount());
        amountFeignClient.decreaseMoney(amountDecreaseBO);

        return "创建订单成功";
    }

    // @ApiOperation("测试配置")
    // @PostMapping("testConfig")
    // public Integer testConfig() {
    //     return timeout;
    // }
}


