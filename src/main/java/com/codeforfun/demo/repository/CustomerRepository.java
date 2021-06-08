package com.codeforfun.demo.repository;

import com.codeforfun.demo.model.CustomerModel;

public interface CustomerRepository {
    CustomerModel saveCustomer(CustomerModel customerModel);
}
