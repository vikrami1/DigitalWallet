package com.assignment.digitalwallet.controller;

import com.assignment.digitalwallet.requestjson.*;
import com.assignment.digitalwallet.responsejson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.digitalwallet.util.AvailableEndPoints;
import com.assignment.digitalwallet.service.CustomerServices;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping(path = AvailableEndPoints.CUSTOMER_SIGN_UP, consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerSignUpResponse> signUp(@RequestBody CustomerSignUpRequest customerSignUpRequest) {
        return ResponseEntity.accepted().body(customerServices.signUpService(customerSignUpRequest));
    }

    @PostMapping(path = AvailableEndPoints.CUSTOMER_LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerLoginResponse> login(@RequestBody CustomerLoginRequest customerLoginRequest) {
        return ResponseEntity.accepted().body(customerServices.loginService(customerLoginRequest));
    }
}
