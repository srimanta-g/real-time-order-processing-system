package com.srimantatech.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderProductDto {
    private long orderId;
    private long productId;
    private int productQuantity;
}
