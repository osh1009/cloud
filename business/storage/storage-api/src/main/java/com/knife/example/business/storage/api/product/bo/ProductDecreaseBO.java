package com.knife.example.business.storage.api.product.bo;

import lombok.Data;

@Data
public class ProductDecreaseBO {
    private Long productId;

    private Integer count;
}
