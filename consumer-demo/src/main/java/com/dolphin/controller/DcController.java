package com.dolphin.controller;

import com.dolphin.feign.ComputeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class DcController {
    private final Logger logger = Logger.getLogger("DcController");
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ComputeServer computeServer;

    @GetMapping("/dc")
    public String dc() {
        ServiceInstance choose = loadBalancerClient.choose("provide-demo");
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/add?a=1&b=10";
        System.out.println(url);
        String entity = restTemplate.getForObject(url, String.class);
        return entity;
    }

    @GetMapping("/dc2")
    public String dc2() {
        return computeServer.add(1, 8);
    }
}
