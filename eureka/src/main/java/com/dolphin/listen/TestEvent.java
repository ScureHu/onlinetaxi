package com.dolphin.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

@Component
public class TestEvent {

    public void listen(EurekaInstanceCanceledEvent event) {
        //实时监控
        System.out.println("下线中:" + event.getServerId());
    }
}
