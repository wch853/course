package com.wch.course.config;

import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Value("${dubbo.registry}")
    private String registry;

    @Bean
    public RegistryConfig registryConfig() {
        return new RegistryConfig(registry);
    }
}
