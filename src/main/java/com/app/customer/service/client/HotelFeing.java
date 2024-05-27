package com.app.customer.service.client;

import com.app.customer.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("HOTEL-API")
public interface HotelFeing {
    @GetMapping("/view-hotel")
    public List<HotelDto> viewHotel();
}
