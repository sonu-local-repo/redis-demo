package com.codeforfun.demo.service;

import com.codeforfun.demo.model.CustomerModel;
import com.codeforfun.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerModel fetchCustomerById(Long id) {
        return null;
    }

    @Override
    public List<CustomerModel> fetchAllCustomers() {
        return null;
    }

    @Override
    public CustomerModel saveCustomer(CustomerModel customerModel) {

        repository.saveCustomer(customerModel);
        return null;
    }
}
