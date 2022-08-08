# icr7store


----------------------------------------------
                  add User 
----------------------------------------------

>> localhost:8080/user/addUser

requestBody-->

{
    "email": "ishwar@gmail.com",
    "name": "Ishwar Singh",
    "mobile": "9458595189",
    "address": [
        {
            "detail": "Chaiser bhawan bhagwati enclave GobindPur Garwal",
            "city": "Haldwani",
            "state": "Uttarakhand",
            "country": "India",
            "pinCode": 263139
        }
        
    ]
}

----------------------------------------------
                  add product 
----------------------------------------------

>> localhost:8080/product/addProduct

requestBody-->
{
    "productName": "LG TV",
    "category": "Electronics",
    "originalPrice": "18000",
    "offeredPrice": "9999",
    "address": {
        "detail": "DLF Mall GG7",
        "city": "Gurgaon",
        "state": "Haryana",
        "country": "India",
        "pinCode": 303213
    },
    "seller": {
        "email": "ishwar@gmail.com"
    }
}
