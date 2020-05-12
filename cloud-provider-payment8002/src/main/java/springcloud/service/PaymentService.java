package springcloud.service;

import com.demo.springcloud.entity.Payment;
import com.demo.springcloud.entity.PaymentExample;
import java.util.List;

public interface PaymentService {

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);
}
