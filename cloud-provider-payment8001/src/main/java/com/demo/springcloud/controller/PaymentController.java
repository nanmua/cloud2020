package com.demo.springcloud.controller;

import com.demo.springcloud.common.ApiReturnInfo;
import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.enu.ResultCodeEnum;
import com.demo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wxn
 * @Date 2020/5/7 0007 10:03
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String severPort;

    @PostMapping(value = "/create")
    private ApiReturnInfo<Payment> create(@RequestBody Payment payment) {
        paymentService.insert(payment);
        return new ApiReturnInfo<>(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode(),
            ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage() + "---" + severPort);
    }

    @GetMapping(value = "/search/{id}")
    private ApiReturnInfo search(@PathVariable Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (null != payment) {
            return ApiReturnInfo.builder().code(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode())
                .message(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage() + "---" + severPort).data(payment).build();
        }
        return new ApiReturnInfo<>(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode(),
            ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage() + "---" + severPort);
    }
}
