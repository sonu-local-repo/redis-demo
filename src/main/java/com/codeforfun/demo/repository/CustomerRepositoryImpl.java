package com.codeforfun.demo.repository;

import com.codeforfun.demo.model.CustomerModel;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final RedisTemplate<String, Object> template;

    private static final String KEY = "CUSTOMER";

    public CustomerRepositoryImpl(RedisTemplate<String, Object> template) {
        this.template = template;
    }


    @Override
    public CustomerModel saveCustomer(CustomerModel customerModel) {

        template.opsForHash().put(KEY, customerModel.getId().toString(), customerModel);
        System.out.println("working");
        return null;
    }
}
