package com.knife.example.business.account.core.business.amount.account.api.amount.bo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AmountDecreaseBO {
    private Long userId;

    private BigDecimal amount;
}
