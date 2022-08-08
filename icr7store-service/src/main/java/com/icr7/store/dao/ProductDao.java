package com.icr7.store.dao;

import com.icr7.store.model.Product;
import com.icr7.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "insert into product (product_name, category, original_price, offered_price, address_id) values (:productName, :category, :originalPrice, :offeredPrice, :addressId) ",nativeQuery = true)
    public void insertProduct(String productName, String category, double originalPrice, double offeredPrice, int addressId);

    @Modifying
    @Query(value = "Insert into address( detail,  city,  state, country, pin_code) values (:detail,  :city,  :state, :country,  :pinCode )",nativeQuery = true)
    public void addProductAddressQuery(String detail, String city, String state, String country, int pinCode);

    @Query(value = "select count(*) from address",nativeQuery = true)
    public int getCurrentAddressId();

    @Query(value = "select count(*) from product",nativeQuery = true)
    public int getCurrentProductId();

    @Query(value = "select * from product",nativeQuery = true)
    public List<Product> getAllProducts();

    @Query(value = "select user_id from user where email= :email lIMIT 1",nativeQuery = true)
    public int getUserIdByEmail(String email);
    
    @Modifying
    @Query(value = "update  product set seller_id= :sellerId where product_id= :productId ",nativeQuery = true)
    public void setSellerIdToProduct(int sellerId, int productId);

}
