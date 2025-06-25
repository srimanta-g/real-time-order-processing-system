package com.srimantatech.orderservice.entity;

import com.srimantatech.orderservice.utils.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private long userId;
    private long productId;
    private int productQuantity;
    private OrderStatus orderStatus;
    private Date orderDate;
}
