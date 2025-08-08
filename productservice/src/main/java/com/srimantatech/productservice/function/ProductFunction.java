package com.srimantatech.productservice.function;

import com.srimantatech.productservice.dto.OrderProductDto;
import com.srimantatech.productservice.dto.ProductConfirmationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class ProductFunction {

    @Bean
    public Function<OrderProductDto, ProductConfirmationDto> productAvailability() {
        return orderProductDto -> {
            return new ProductConfirmationDto(orderProductDto.getOrderId(), true);
        };
    }
}
