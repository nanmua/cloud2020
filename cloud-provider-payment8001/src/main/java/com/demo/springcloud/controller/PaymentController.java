package com.demo.springcloud.controller;

import com.demo.springcloud.common.ApiReturnInfo;
import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.enu.ResultCodeEnum;
import com.demo.springcloud.service.PaymentService;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String severPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    /**
     * 获取微服务的信息
     * @return
     */
    @GetMapping(value = "/discovery")
    public Object discovery() {
        // 获取微服务列表名称信息
        List<String> services = discoveryClient.getServices();
        for (String e : services) {
            log.info("******services:       " + e);
        }
        // 一个微服务名称下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance e : instances) {
            log.info(
                "******instances:       " + e.getInstanceId() + "\t" + e.getHost() + "\t" + e.getPort() + "\t" + e.getUri());
        }
        // 以上打印信息示例
//        ******services:       cloud-payment-service
//        ******services:       cloud-order-service
//        ******instances:       payment8002	192.168.1.219	8002	http://192.168.1.219:8002
//        ******instances:       payment8001	192.168.1.219	8001	http://192.168.1.219:8001


        return this.discoveryClient;
    }
}
