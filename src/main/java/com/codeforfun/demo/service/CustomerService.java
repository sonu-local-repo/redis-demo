package com.codeforfun.demo.service;

import com.codeforfun.demo.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    CustomerModel fetchCustomerById(Long id);
    List<CustomerModel> fetchAllCustomers();
    CustomerModel saveCustomer(CustomerModel customerModel);
}
