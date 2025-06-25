package com.srimantatech.orderservice.dto;

import com.srimantatech.orderservice.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private long userId;
    private int productQuantity;
    private int productId;
}
