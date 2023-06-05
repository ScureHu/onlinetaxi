package com.dolphin.feign;

import com.dolphin.fallback.ComputerServerFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provide-demo", fallback = ComputerServerFallBack.class)
public interface ComputeServer {

    @GetMapping("/add")
    String add(@RequestParam Integer a, @RequestParam Integer b);
}
