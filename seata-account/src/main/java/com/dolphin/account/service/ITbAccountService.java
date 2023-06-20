package com.dolphin.account.service;

import com.dolphin.account.entity.TbAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther xxxx
 * @create 2023-06-20 15:03:21
 * @describe 服务类
 */
public interface ITbAccountService extends IService<TbAccount> {
    void deduct(String userId, Integer money);
}
