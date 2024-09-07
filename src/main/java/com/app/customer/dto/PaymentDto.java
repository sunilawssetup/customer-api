package com.app.customer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class PaymentDto {
    public Long paymentId;
    public Long orderId;
    public String status;
}
