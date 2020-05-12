/*
* Payment.java
* Copyright(C) 2017-2020 众调科技
* @date 2020-05-09 09:48:30
*/
package com.demo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * @Title payment表的实体类
 * @Description 
 * @version 1.0
 * @Date 2020-05-09 09:48:30
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    /** */
    private Long id;

    /** 支付流水号*/
    private String serial;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 支付流水号
     * @return serial 支付流水号
     */
    public String getSerial() {
        return serial;
    }

    /**
     * 支付流水号
     * @param serial 支付流水号
     */
    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }
}