package com.app.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
