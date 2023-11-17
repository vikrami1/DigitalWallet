package com.assignment.digitalwallet.dao;

import com.assignment.digitalwallet.databaseentities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRespository extends CrudRepository<Customer, Long> {
    Customer findByCustomerUsername(String customerUsername);
}
