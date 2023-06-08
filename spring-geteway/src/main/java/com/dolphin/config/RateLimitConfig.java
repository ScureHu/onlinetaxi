package com.dolphin.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RateLimitConfig {
    /**
     * 请求规则  这个启动的话会拦截一些请求 同时根据后台配置实现限流功能
     * @return
     */
    @Bean
    KeyResolver userkeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
