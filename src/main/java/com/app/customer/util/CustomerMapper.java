package com.app.customer.util;

import com.app.customer.dto.CustomerDto;
import com.app.customer.model.Customer;

public class CustomerMapper {

        public static CustomerDto customerToCustomerDto(Customer customer) {

            if (customer == null) throw new NullPointerException();
            return applyCustomer(customer);

        }

    public static Customer customerDtoToCustomer(CustomerDto customerDto) {
        if (customerDto == null) throw new NullPointerException();
        return applyCustomerDto(customerDto);
    }

    private static CustomerDto applyCustomer(Customer customer1) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer1.getCustomerId());
        customerDto.setMobile(customer1.getMobile());
        customerDto.setGender(customer1.getGender());
        customerDto.setFName(customer1.getFName());
        customerDto.setLName(customer1.getLName());
        return customerDto;
    }


    private static Customer applyCustomerDto(CustomerDto customerDto1) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto1.getCustomerId());
        customer.setMobile(customerDto1.getMobile());
        customer.setGender(customerDto1.getGender());
        customer.setFName(customerDto1.getFName());
        customer.setLName(customerDto1.getLName());
        return customer;
    }
}
