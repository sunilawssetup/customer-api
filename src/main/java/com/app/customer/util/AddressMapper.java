package com.app.customer.util;

import com.app.customer.dto.AddressDto;
import com.app.customer.model.Address;

public class AddressMapper {


    public static AddressDto addressToAddressDto(Address address) {

        if (address == null) throw new NullPointerException();
        return applyAddress(address);
    }

    public static Address addressDtoToAddress(AddressDto addressDto) {
        if (addressDto == null) throw new NullPointerException();
        return applyAddressDto(addressDto);
    }

    private static AddressDto applyAddress(Address address1) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address1.getAddressId());
        addressDto.setAdd(address1.getAdd());
        addressDto.setPin(address1.getPin());
        addressDto.setStreet(address1.getStreet());
        addressDto.setCity(address1.getCity());
        addressDto.setState(address1.getState());
        addressDto.setActive(address1.getActive());
        return addressDto;
    }

    private static Address applyAddressDto(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setAdd(addressDto.getAdd());
        address.setPin(addressDto.getPin());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setActive(addressDto.getActive());
        return address;
    }
}
