package com.app.customer.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
@ToString
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private Long customerId;
    private String mobile;
    private String fName;
    private String lName;
    private String gender;

}
