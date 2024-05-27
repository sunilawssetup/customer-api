package com.app.customer.repo;

import com.app.customer.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Long> {
    List<Address> findByCustomerId(Long customerId);
}
