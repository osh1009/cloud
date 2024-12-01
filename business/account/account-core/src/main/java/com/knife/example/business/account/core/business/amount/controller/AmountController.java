package com.knife.example.business.account.core.business.amount.controller;

import com.knife.example.business.account.core.business.amount.account.api.amount.bo.AmountDecreaseBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "金额")
@Slf4j
@RestController
@RequestMapping("amount")
public class AmountController {

    @ApiOperation("扣减")
    @PostMapping("decrease")
    public void decrease(@RequestBody AmountDecreaseBO amountDecreaseBO) {
        // 扣减金额
        log.info("账户服务：扣减用户{}金额{}元",
                amountDecreaseBO.getUserId(),
                amountDecreaseBO.getAmount());
    }
}
