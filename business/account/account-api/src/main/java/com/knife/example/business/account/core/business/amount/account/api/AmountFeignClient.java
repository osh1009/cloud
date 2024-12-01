package com.knife.example.business.account.core.business.amount.account.api;

import com.knife.example.business.account.core.business.amount.account.api.amount.bo.AmountDecreaseBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "account", contextId = "amount")
public interface AmountFeignClient {
    @PostMapping("/amount/decrease")
    void decreaseMoney(@RequestBody AmountDecreaseBO amountDecreaseBO);
}
