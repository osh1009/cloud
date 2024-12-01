package com.knife.example.business.order.core.business.order.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderBO {
    // 用户id
    private Long userId;

    // 产品id
    private Long productId;

    // 数量
    private Integer count;

    // 金额
    private BigDecimal amount;
}