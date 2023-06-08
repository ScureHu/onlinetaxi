package com.dolphin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;

@EnableEurekaClient
@SpringBootApplication
public class SpringGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringGateWayApplication.class, args);
    }

    /**
     * webflux初体验
     * @return
     */
//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//        RouterFunction<ServerResponse> route = RouterFunctions.route(
//                RequestPredicates.path("/dc"),
//                serverRequest -> ServerResponse.ok().body(BodyInserters.fromValue("kkkk")));
//        return route;
//    }
}
