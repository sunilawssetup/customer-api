package com.app.customer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class MenuDto {
    private Long menueId;
    private String name;
    private String description;
    private Double price;
    private boolean type;
    private Long hotelId;
}
