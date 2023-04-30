package com.pgDemo1.demo.service;

import com.pgDemo1.demo.DemoApplication;
import com.pgDemo1.demo.dao.CustomerRepository;
import com.pgDemo1.demo.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository dao;

    public Customer insert(Customer customer){
        return  dao.save(customer);
    }

    public List<Customer> getAll(){
        return dao.findAll();
    }

    public List<Customer> getByFirstName(String firstName) {
        return  dao.findByFirstName(firstName);
    }
    public Customer findOne(String firstName,String lastName) {
        try {
            return  dao.findOne(firstName,lastName);
        }catch (Exception ex){
            log.error("Error in service ",ex);
            throw ex;

        }
    }
}
