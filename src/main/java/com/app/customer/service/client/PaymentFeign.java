package com.app.customer.service.client;

import com.app.customer.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("PAYMENT-API")
public interface PaymentFeign {

    @PostMapping("/payment/savePayment")
    public PaymentDto savePayment(PaymentDto paymentDto);
}
