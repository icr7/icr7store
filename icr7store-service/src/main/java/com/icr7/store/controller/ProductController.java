package com.icr7.store.controller;

import com.icr7.store.dao.ProductDao;
import com.icr7.store.model.Address;
import com.icr7.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    ProductDao productDao;

    @GetMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        Address address= product.getAddress();
        productDao.addProductAddressQuery(address.getDetail(),address.getCity(),address.getState(),address.getCountry(),address.getPinCode());
        productDao.insertProduct(product.getProductName(), product.getCategory(), product.getOriginalPrice(), product.getOfferedPrice(), productDao.getCurrentAddressId());
        if(product.getSeller()!=null){
            productDao.setSellerIdToProduct(productDao.getUserIdByEmail(product.getSeller().getEmail()), productDao.getCurrentProductId());
        }
        return "product added";
    }

    @GetMapping("/get")
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
