package com.app.customer.service;

import com.app.customer.dto.CustomerDto;
import com.app.customer.dto.HotelDto;
import com.app.customer.dto.LoginDto;
import com.app.customer.model.Customer;

import java.util.List;

public interface ICustomer {
    public  CustomerDto saveCustomer(CustomerDto customer);
    public CustomerDto getCustomer(Long customerId);
    public CustomerDto updateCustomer(CustomerDto customer);

    List<HotelDto> loginUser(LoginDto loginDto);
}
