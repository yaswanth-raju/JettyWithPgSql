package com.pgDemo1.demo.controller;

import com.pgDemo1.demo.entity.Customer;
import com.pgDemo1.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("getAll")
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("getByName/{firstName}")
    public ResponseEntity<List<Customer>> getByFirstName(@PathVariable("firstName") String firstName) {
        return new ResponseEntity<>(service.getByFirstName(firstName), HttpStatus.OK);
    }
    @GetMapping("findOne/{firstName}/{lastName}")
    public ResponseEntity<Customer> getByFirstName(@PathVariable("firstName") String firstName,
                                                         @PathVariable("lastName") String lastName) {
        return new ResponseEntity<>(service.findOne(firstName,lastName), HttpStatus.OK);
    }

    @PostMapping
    Customer insert(@RequestBody Customer customer){
        return service.insert(customer);
    }

}
