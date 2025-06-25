package com.srimantatech.orderservice.exception;

import com.srimantatech.orderservice.dto.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponse<?>> handleException(RuntimeException e) {
        log.error(e.getMessage());
        APIResponse<?> response = new APIResponse<>(500, null, "Internal Server Error");
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleOrderNotFoundException(OrderNotFoundException e) {
        log.error(e.getMessage());
        APIResponse<?> response = new APIResponse<>(404, null, e.getMessage());
        return ResponseEntity.status(404).body(response);
    }
}
