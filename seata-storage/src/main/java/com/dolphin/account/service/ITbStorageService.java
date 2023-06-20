package com.dolphin.account.service;

import com.dolphin.account.entity.TbStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther xxxx
 * @create 2023-06-20 15:07:32
 * @describe 服务类
 */
public interface ITbStorageService extends IService<TbStorage> {

    void deduct(String code, Integer count);
}
