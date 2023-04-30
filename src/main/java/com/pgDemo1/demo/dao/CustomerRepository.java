package com.pgDemo1.demo.dao;


import com.pgDemo1.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  List<Customer> findByFirstName(String firstName);



  @Override
  List<Customer> findAll();

  Customer findById(long id);

//  @Query("select u from Customer where u.firstName = ?1 and u.lastName = ?2")
  @Query("SELECT u FROM Customer u WHERE u.firstName = ?1 and u.lastName = ?2")
  Customer findOne(String firstName, String lastName);
}