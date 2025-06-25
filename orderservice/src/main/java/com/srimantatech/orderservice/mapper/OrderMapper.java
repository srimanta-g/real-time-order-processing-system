package com.srimantatech.orderservice.mapper;

import com.srimantatech.orderservice.dto.OrderDto;
import com.srimantatech.orderservice.entity.Order;
import com.srimantatech.orderservice.utils.OrderStatus;

import java.util.Date;

public class OrderMapper {
    public static Order mapToEntity(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setProductQuantity(orderDto.getProductQuantity());
        order.setProductId(orderDto.getProductId());

        return order;
    }
}
