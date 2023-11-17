package com.assignment.digitalwallet.util;

import com.assignment.digitalwallet.databaseentities.Customer;
import com.assignment.digitalwallet.databaseentities.CustomerAccount;
import com.assignment.digitalwallet.requestjson.CustomerSignUpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtility {
    public Customer getCustomer(CustomerSignUpRequest customerSignUpRequest) {
        Customer customer = new Customer();
        customer.setCustomerName(customerSignUpRequest.getName());
        customer.setCustomerUsername(customerSignUpRequest.getUsername());
        customer.setCustomerPassword(customerSignUpRequest.getPassword());

        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setTotalBalance(0L);

        customer.setCustomerAccount(customerAccount);
        return customer;
    }
}
