package com.dolphin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CeshiController {
    /**
     * 需要在nacos的服务器上增加 服务名.yaml的配置文件
     * 在里面增加自己需要的配置
     * 服务上增加RefreshScope可以自动刷新
     * 配置文件中一定要有bootstrap.yml
     */
    @Value("${k1}")
    private String k1;

    @GetMapping("/k1")
    public String getValue(){
        return k1;
    }
}
