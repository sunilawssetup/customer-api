package com.app.customer.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_address")
public class Address extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String add;
    private String street;
    private String city;
    private String pin;
    private String state;
    private Boolean active;
    private Long customerId;

}
