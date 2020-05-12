/*
* PaymentMapper.java
* Copyright(C) 2017-2020 众调科技
* @date 2020-05-09 09:48:30
*/
package com.demo.springcloud.dao;

import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.entity.PaymentExample;
import java.util.List;

public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentExample example);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}