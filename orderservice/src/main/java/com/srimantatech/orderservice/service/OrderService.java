package com.srimantatech.orderservice.service;

import com.srimantatech.orderservice.dto.OrderDto;
import com.srimantatech.orderservice.dto.OrderProductDto;
import com.srimantatech.orderservice.entity.Order;
import com.srimantatech.orderservice.exception.OrderNotFoundException;
import com.srimantatech.orderservice.repo.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private IOrderRepository iOrderRepository;
    private StreamBridge streamBridge;

    @Transactional
    public boolean createNewOrder(Order order) {
        try {
            Order savedOrder = iOrderRepository.save(order);
            checkProductAvailability(new OrderProductDto(savedOrder.getOrderId(), order.getProductId(), order.getProductQuantity()));
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

    public void checkProductAvailability(OrderProductDto orderProductDto) {
        // This method can be implemented to check product availability
        // For now, it is a placeholder
        log.info("Checking availability for product ID: {}, Quantity: {}", orderProductDto.getProductId(), orderProductDto.getProductQuantity());
        streamBridge.send("product-availability-queue", orderProductDto);
    }
}
