package com.icr7.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String category;
    private double originalPrice;
    private double offeredPrice;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "product")
    private List<ProductImage>productImages;
    @ManyToMany(mappedBy = "products")
    private List<MyOrder>orders;



}
