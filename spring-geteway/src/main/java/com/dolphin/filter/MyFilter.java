package com.dolphin.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyFilter implements Ordered, GlobalFilter {
    /**
     * 这个地方可以自定义一些操作（这个地方的业务一般都不与真正请求的业务耦合）
     * 日志输出 访问缓存
     * 业务上可以实现权限验证 spring安全框架 Auto2.0 JWT等
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

    /**
     * 这里可以判断多个过滤器的优先级
     * order越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
