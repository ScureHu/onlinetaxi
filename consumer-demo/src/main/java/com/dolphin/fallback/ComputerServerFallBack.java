package com.dolphin.fallback;

import com.dolphin.feign.ComputeServer;
import org.springframework.stereotype.Component;

@Component
public class ComputerServerFallBack implements ComputeServer {

    @Override
    public String add(Integer a, Integer b) {
        return "服务降级中";
    }
}
