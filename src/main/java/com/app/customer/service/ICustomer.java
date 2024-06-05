package com.app.customer.service;

import com.app.customer.dto.*;
import com.app.customer.model.Customer;

import java.util.List;

public interface ICustomer {
    public  CustomerDto saveCustomer(CustomerDto customer);
    public CustomerDto getCustomer(Long customerId);
    public CustomerDto updateCustomer(CustomerDto customer);

    List<HotelDto> loginUser(LoginDto loginDto);

    OrderIteamDto bookOrder(OrderIteamDto orderIteamDto);

    PaymentDto payment(PaymentDto paymentDto);
}
