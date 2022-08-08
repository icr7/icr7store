package com.icr7.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String detail;
    private String city;
    private String state;
    private String country;
    private int pinCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


}
