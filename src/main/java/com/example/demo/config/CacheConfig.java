package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: sunzhinan
 * @create: 2020-12-01 22:02
 * @description: 缓存配置类c
 */
@Data
@Component
@ConfigurationProperties(prefix = "cache")
public class CacheConfig {
    private int overTime;

    private int maxSize;
}
