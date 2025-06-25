package com.srimantatech.orderservice.service;

import com.srimantatech.orderservice.entity.Order;
import com.srimantatech.orderservice.exception.OrderNotFoundException;
import com.srimantatech.orderservice.repo.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private IOrderRepository iOrderRepository;

    @Transactional
    public boolean createNewOrder(Order order) {
        try {
            iOrderRepository.save(order);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public Order getOrderDetailsById(Long orderId) {
        return iOrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }
}
