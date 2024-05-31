package com.app.customer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private String description;
    List<MenuDto> items;
}
