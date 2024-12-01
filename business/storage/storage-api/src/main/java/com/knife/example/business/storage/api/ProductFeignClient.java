package com.knife.example.business.storage.api;

import com.knife.example.business.storage.api.product.bo.ProductDecreaseBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "storage", contextId = "product")
public interface ProductFeignClient {
    @PostMapping("/product/decrease")
    void decreaseStorage(@RequestBody ProductDecreaseBO productDecreaseBO);

    @PostMapping("/product/decreaseFault")
    void decreaseStorageFault(@RequestBody ProductDecreaseBO productDecreaseBO);
}
