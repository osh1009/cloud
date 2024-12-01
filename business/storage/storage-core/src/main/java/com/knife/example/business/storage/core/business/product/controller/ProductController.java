package com.knife.example.business.storage.core.business.product.controller;

import com.knife.example.business.storage.api.product.bo.ProductDecreaseBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "产品")
@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @ApiOperation("扣减数量")
    @PostMapping("decrease")
    public void decrease(@RequestBody ProductDecreaseBO bo) {
        log.info("库存服务：减少产品库存。productId: {}, count: {}",
                bo.getProductId(), bo.getCount());
    }

    @ApiOperation("扣减数量报错")
    @PostMapping("decreaseFault")
    public Boolean decreaseFault(@RequestBody ProductDecreaseBO bo) {
        log.info("库存服务：减少产品库存刻意抛出错误。productId: {}, count: {}",
                bo.getProductId(), bo.getCount());

        int i = 1 / 0;

        return true;
    }
}
