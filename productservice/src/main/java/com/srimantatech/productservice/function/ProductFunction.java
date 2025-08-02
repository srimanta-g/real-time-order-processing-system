package com.srimantatech.productservice.function;

import com.srimantatech.productservice.dto.OrderProductDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ProductFunction {

    @Bean
    public Function<OrderProductDto, Boolean> productAvailability() {
        return productDto -> {
            return true;
        };
    }
}
