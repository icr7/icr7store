package com.icr7.store.dao;

import com.icr7.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {
    @Modifying
    @Query(value = "Insert into user(email, name , mobile) values (:email, :name, :mobile)",nativeQuery = true)
    public void addUserQuery(String email, String name, String mobile);

    @Query(value = "select count(*) from user",nativeQuery = true)
    public int getCurrentUserId();

    @Modifying
    @Query(value = "Insert into address( detail,  city,  state, country, pin_code, user_id) values (:detail,  :city,  :state, :country,  :pinCode, :userId)",nativeQuery = true)
    public void addUserAddressQuery(String detail, String city, String state, String country, int pinCode, int userId);

   @Query(value = "select * from user",nativeQuery = true)
   public List<User> getAllUsers();

}
