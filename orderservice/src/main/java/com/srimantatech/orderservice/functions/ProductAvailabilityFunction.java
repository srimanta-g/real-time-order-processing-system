package com.srimantatech.orderservice.functions;

import com.srimantatech.orderservice.dto.ProductConfirmationDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ProductAvailabilityFunction {

    @Bean
    public Consumer<ProductConfirmationDto> productAvailability() {
        return productConfirmationDto -> {
            // Here you can implement the logic to handle the product availability confirmation
            // For example, you might want to log the confirmation or update a database record
            System.out.println("Product availability confirmed for Order ID: " + productConfirmationDto.getOrderId() +
                    ", Available: " + productConfirmationDto.isAvailable());
        };
    }
}
