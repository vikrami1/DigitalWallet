package com.assignment.digitalwallet.responsejson;

import com.assignment.digitalwallet.databaseentities.Customer;
import com.assignment.digitalwallet.util.AdminViewCustomer;

import java.util.List;

public class AdminViewUsersResponse {
    private List<AdminViewCustomer> allUsers;

    public List<AdminViewCustomer> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<AdminViewCustomer> allUsers) {
        this.allUsers = allUsers;
    }
}
