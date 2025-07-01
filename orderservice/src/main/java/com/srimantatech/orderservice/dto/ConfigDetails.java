package com.srimantatech.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "details")
@Getter
@Setter
public class ConfigDetails {
    private String env;
    private String version;
    private String author;
    private List<String> contact;
}
