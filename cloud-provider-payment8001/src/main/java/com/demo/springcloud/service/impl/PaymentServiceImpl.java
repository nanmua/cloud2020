package com.demo.springcloud.service.impl;

import com.demo.springcloud.dao.PaymentMapper;
import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wxn
 * @Date 2020/5/6 0006 17:08
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentMapper.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
