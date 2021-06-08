package com.codeforfun.demo.controller;


import com.codeforfun.demo.model.CustomerModel;
import com.codeforfun.demo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    private final CustomerService userService;

    public RedisController(CustomerService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody  CustomerModel customerModel){
        return ResponseEntity.ok(userService.saveCustomer(customerModel));
    }
}
