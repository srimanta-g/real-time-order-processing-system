package com.srimantatech.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class APIResponse<T> {
    private int statusCode;
    private T data;
    private String message;
}
