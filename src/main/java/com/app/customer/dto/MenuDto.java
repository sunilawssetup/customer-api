package com.app.customer.dto;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@Builder
public class MenuDto {
    private Long menueId;
    private String name;
    private String description;
    private Double price;
    private boolean type;
    private Long hotelId;
}
