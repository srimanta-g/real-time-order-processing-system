package com.srimantatech.orderservice.controller;

import com.srimantatech.orderservice.dto.APIResponse;
import com.srimantatech.orderservice.dto.ConfigDetails;
import com.srimantatech.orderservice.dto.OrderDto;
import com.srimantatech.orderservice.entity.Order;
import com.srimantatech.orderservice.mapper.OrderMapper;
import com.srimantatech.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ConfigDetails configDetails;

    @Operation(summary = "Create a new order",
            description = "This endpoint allows you to create a new order by providing the necessary order details.",
            tags = {"Order Management"},
            responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Order created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Failed to create order")})
    @PostMapping("/create-new-order")
    public ResponseEntity<APIResponse<?>> createNewOrder (@RequestBody OrderDto orderDto) {
        Order order = OrderMapper.mapToEntity(orderDto);
        boolean transactionSuccessful = this.orderService.createNewOrder(order);
        if (transactionSuccessful) {
            return ResponseEntity.status(HttpStatusCode.valueOf(201))
                    .body(new APIResponse<Order>(201, order, "Order created successfully"));
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(500))
                    .body(new APIResponse<>(500, null, "Failed to create order"));
        }
    }

    @Operation(
            summary = "Get order details by ID",
            description = "This endpoint retrieves the details of an order using its unique ID.",
            tags = {"Order Management"},
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Order details fetched successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Order not found")}
    )
    @GetMapping("/get-order-details/{orderId}")
    public ResponseEntity<APIResponse<Order>> getOrderDetailsById (@PathVariable Long orderId) {
        Order order = this.orderService.getOrderDetailsById(orderId);
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(new APIResponse<>(200, order, "Order details fetched successfully"));
    }

    @GetMapping("/get-config-details")
    public ResponseEntity<APIResponse<?>> getConfigDetails () {
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(new APIResponse<>(200, configDetails, "Config details fetched successfully"));
    }
}
