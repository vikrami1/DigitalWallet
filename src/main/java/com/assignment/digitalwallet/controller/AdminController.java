package com.assignment.digitalwallet.controller;

import com.assignment.digitalwallet.requestjson.AdminChangeStatusRequest;
import com.assignment.digitalwallet.requestjson.AdminViewUserAccountRequest;
import com.assignment.digitalwallet.responsejson.*;
import com.assignment.digitalwallet.service.AdminServices;
import com.assignment.digitalwallet.util.AvailableEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    
    @Autowired
    private AdminServices adminServices;

    @PostMapping(path = AvailableEndPoints.ADMIN_VIEW_USERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminViewUsersResponse> viewAllUsers() {
        return ResponseEntity.accepted().body(adminServices.viewUsersService());
    }

    @PostMapping(path = AvailableEndPoints.ADMIN_CHANGE_STATUS, consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminChangeStatusResponse> changeStatus(@RequestBody AdminChangeStatusRequest adminChangeStatusRequest) {
        return ResponseEntity.accepted().body(adminServices.changeStatusService(adminChangeStatusRequest));
    }

    @PostMapping(path = AvailableEndPoints.ADMIN_VIEW_USER_TRANSACTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminViewUserTransactionsResponse> viewUserTransaction() {
        return ResponseEntity.accepted().body(adminServices.viewUserTransactionsService());
    }

    @PostMapping(path = AvailableEndPoints.ADMIN_VIEW_USER_ACCOUNT, consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminViewUserAccountResponse> viewUserAccount(@RequestBody AdminViewUserAccountRequest adminViewUserAccountRequest) {
        return ResponseEntity.accepted().body(adminServices.viewUserAccountService(adminViewUserAccountRequest));
    }
}
