package com.icr7.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String email;
    private String name;
    private String mobile;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
    private String password;
    private String photo;
    @OneToMany(mappedBy = "seller")
    private List<Product> product;


}
