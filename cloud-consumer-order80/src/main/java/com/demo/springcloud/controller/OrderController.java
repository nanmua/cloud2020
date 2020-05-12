package com.demo.springcloud.controller;

import com.demo.springcloud.common.ApiReturnInfo;
import com.demo.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wxn
 * @Date 2020/5/7 0007 14:05
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public ApiReturnInfo create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ApiReturnInfo.class);
    }

    @GetMapping("/payment/search/{id}")
    public ApiReturnInfo<Payment> search(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/search/"+ id, ApiReturnInfo.class);
    }
}
