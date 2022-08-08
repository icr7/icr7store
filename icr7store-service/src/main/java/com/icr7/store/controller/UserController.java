package com.icr7.store.controller;


import com.icr7.store.dao.UserRepo;
import com.icr7.store.model.Address;
import com.icr7.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println("inserting user " + user.toString());
        userRepo.addUserQuery(user.getEmail(), user.getName(), user.getMobile());

        for (Address adr : user.getAddress()) {
            userRepo.addUserAddressQuery(adr.getDetail(), adr.getCity(), adr.getState(), adr.getCountry(), adr.getPinCode(), userRepo.getCurrentUserId());
        }
        return "Saved Successfully";
    }

    @GetMapping("/get")
    public List<User> getUser(){
        return userRepo.getAllUsers();
    }

}
