package com.app.customer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class OrderIteamDto {
    private Long orderId;
    private Long customerId;
    private Long hotelId;
    private Long menuId;
    private Long qty;
    private String paymentStatus;
    private String orderStatus;
}