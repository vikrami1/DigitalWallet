package com.assignment.digitalwallet.service;

import com.assignment.digitalwallet.dao.CustomerRespository;
import com.assignment.digitalwallet.dao.TransactionsRespository;
import com.assignment.digitalwallet.databaseentities.Customer;
import com.assignment.digitalwallet.requestjson.CustomerLoginRequest;
import com.assignment.digitalwallet.requestjson.CustomerSignUpRequest;
import com.assignment.digitalwallet.responsejson.CustomerLoginResponse;
import com.assignment.digitalwallet.responsejson.CustomerSignUpResponse;
import com.assignment.digitalwallet.util.CustomerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServices {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private CustomerUtility customerUtility;

    @Autowired
    private TransactionsRespository transactionsRespository;

    public CustomerSignUpResponse signUpService(CustomerSignUpRequest customerSignUpRequest) {
        CustomerSignUpResponse customerSignUpResponse = new CustomerSignUpResponse();
        Customer newCustomer = customerUtility.getCustomer(customerSignUpRequest);
        Customer savedEntity = customerRespository.save(newCustomer);

        customerSignUpResponse.setCustomerId(savedEntity.getId());
        customerSignUpResponse.setSignupStatus("Sign Up Successful");

        return customerSignUpResponse;
    }

    public CustomerLoginResponse loginService(CustomerLoginRequest customerLoginRequest) {
        CustomerLoginResponse customerLoginResponse = new CustomerLoginResponse();
        Customer customerWithUsername = customerRespository.findByCustomerUsername(customerLoginRequest.getUsername());

        if(customerWithUsername == null) {
            customerLoginResponse.setLoginStatus("User with username " + customerLoginRequest.getUsername() + " was not found!");
        }
        else {
            customerWithUsername.setLoggedIn(true);
            customerRespository.save(customerWithUsername);
            customerLoginResponse.setLoginStatus("User with username " + customerLoginRequest.getUsername() + " was logged in!");
        }

        return customerLoginResponse;
    }
}
