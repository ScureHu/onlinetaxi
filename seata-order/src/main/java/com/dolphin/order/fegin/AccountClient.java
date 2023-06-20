package com.dolphin.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "seata-account")
@RequestMapping("/account")
public interface AccountClient {
    /**
     * 扣钱
     *
     * @param userId
     * @param money
     * @return
     */
    @GetMapping("/{userId}/{money}")
    ResponseEntity deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money);
}
