package com.app.customer.service.impl;

import com.app.customer.controller.CustomerController;
import com.app.customer.dto.*;
import com.app.customer.exception.CustomerAlreadyExistException;
import com.app.customer.exception.CustomerNotFound;
import com.app.customer.model.Address;
import com.app.customer.model.Customer;
import com.app.customer.repo.AddressRepo;
import com.app.customer.repo.CustomerRepo;
import com.app.customer.service.ICustomer;
import com.app.customer.service.client.HotelFeing;
import com.app.customer.service.client.OrderFeign;
import com.app.customer.service.client.PaymentFeign;
import com.app.customer.util.AddressMapper;
import com.app.customer.util.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements ICustomer {

    Logger logger = LoggerFactory.getLogger(CustomerImpl.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private HotelFeing hotelFeing;

    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private PaymentFeign paymentFeign;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        logger.info("customer Dto{}", customerDto);
        Customer customer = CustomerMapper.customerDtoToCustomer(customerDto);
        logger.info("customer {}", customer);

        Customer existCustomer = customerRepo.findByMobile(customer.getMobile());
        if (Objects.nonNull(existCustomer)) {
            throw new CustomerAlreadyExistException("this customer is already exist try to login please");
        }
        CustomerDto resCustomerDto = CustomerMapper.customerToCustomerDto(customerRepo.save(customer));

        if (Objects.nonNull(customerDto.getAddressDtos())) {
            List<Address> addresses = customerDto.getAddressDtos().stream()
                    .map(addressDto -> AddressMapper.addressDtoToAddress(addressDto))
                    .collect(Collectors.toList());


            resCustomerDto.setAddressDtos(addresses.stream()
                    .map(address -> {

                        address.setCustomerId(resCustomerDto.getCustomerId());
                        return AddressMapper.addressToAddressDto(addressRepo.save(address));
                    })
                    .collect(Collectors.toList()));
        }
        return resCustomerDto;
    }

    @Override
    public CustomerDto getCustomer(Long customerId) {

        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFound("customer", "customeriD", customerId));

        CustomerDto resCustomerDto = CustomerMapper.customerToCustomerDto(customer);

        List<Address> addresses = addressRepo.findByCustomerId(customerId);
        resCustomerDto.setAddressDtos(addresses.stream().map(add -> AddressMapper.addressToAddressDto(add)).collect(Collectors.toList()));

        return resCustomerDto;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {

        if (Objects.nonNull(customerDto.getCustomerId())) {
            Customer customer = CustomerMapper.customerDtoToCustomer(customerDto);
            CustomerDto resCustomerDto = CustomerMapper.customerToCustomerDto(customerRepo.save(customer));

            List<Address> addresses = customerDto.getAddressDtos().stream().filter(addressDto -> Objects.nonNull(addressDto.getAddressId()))
                    .map(addressDto -> AddressMapper.addressDtoToAddress(addressDto))
                    .collect(Collectors.toList());

            resCustomerDto.setAddressDtos(addresses.stream()
                    .map(address -> AddressMapper.addressToAddressDto(addressRepo.save(address)))
                    .collect(Collectors.toList()));
            return resCustomerDto;
        }


        return null;
    }

    @Override
    public List<HotelDto> loginUser(LoginDto loginDto) {
        List<HotelDto> listHotel = null;
        Customer existCustomer = customerRepo.findByMobile(loginDto.getUsername());
        if (Objects.nonNull(existCustomer)) {
            listHotel = hotelFeing.viewHotel();
        }
        return listHotel;
    }

    @Override
    public OrderIteamDto bookOrder(OrderIteamDto orderIteamDto) {
        return orderFeign.bookOrder(orderIteamDto);
    }

    @Override
    public PaymentDto payment(PaymentDto paymentDto) {
        return paymentFeign.savePayment(paymentDto);
    }


}
