package com.dolphin.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SentinelResource(value = "sayHello", defaultFallback = "back")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String back(Throwable t) {
        return "降级中......";
    }
}
