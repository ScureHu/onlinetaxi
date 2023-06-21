package com.dolphin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.dolphin.account.entity.TbAccount;
import com.dolphin.account.mapper.TbAccountMapper;
import com.dolphin.account.service.ITbAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther xxxx
 * @create 2023-06-20 15:03:21
 * @describe 服务实现类
 */
@Service
@Slf4j
public class TbAccountServiceImpl extends ServiceImpl<TbAccountMapper, TbAccount> implements ITbAccountService {


    @Override
    @Transactional
    public void deduct(String userId, Integer money) {
        log.info("开始扣款");
        try {
//            accountAction.deduct(userId,money);
            QueryWrapper<TbAccount> query = new QueryWrapper<>();
            query.eq("user_id", userId);
            this.list(query);


            LambdaQueryWrapper<TbAccount> query1 = new LambdaQueryWrapper<>();
            query1.eq(TbAccount::getUserId, userId);
            this.list(query1);

            LambdaUpdateWrapper<TbAccount> update = new LambdaUpdateWrapper<>();
            // update tb_account set money = money - money where user_id = ?
            update.eq(TbAccount::getUserId, userId);
            update.setSql("money = money - " + money);
            this.update(update);
        } catch (Exception e) {
            throw new RuntimeException("扣款失败，可能是余额不足！", e);
        }
        log.info("扣款成功");
    }
}
