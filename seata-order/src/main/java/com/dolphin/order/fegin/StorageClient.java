package com.dolphin.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "seata-storage")
@RequestMapping("/storage")
public interface StorageClient {
    /**
     * 减库存
     * @param code
     * @param count
     * @return
     */
    @GetMapping("/{code}/{count}")
    public ResponseEntity deduct(@PathVariable("code") String code, @PathVariable("count") Integer count);
}
