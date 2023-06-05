package com.dolphin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * SpringCloudApplication 注解包含
 *
 * @SpringBootApplication 启动容器注解
 * @EnableDiscoveryClient 服务注册发现注解
 * @EnableCircuitBreaker 服务熔断注解
 * @EnableFeignClients 远程调用服务开启
 */
@SpringCloudApplication
@EnableFeignClients
public class ConsumerApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
