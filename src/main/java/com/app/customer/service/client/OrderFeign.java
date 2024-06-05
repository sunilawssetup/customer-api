package com.app.customer.service.client;

import com.app.customer.dto.OrderIteamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ORDER-API")
public interface OrderFeign {

    @PostMapping("/order/bookOrder")
    public OrderIteamDto bookOrder(@RequestBody OrderIteamDto orderIteamDto);
}
