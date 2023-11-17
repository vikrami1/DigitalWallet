package com.assignment.digitalwallet.responsejson;

import com.assignment.digitalwallet.util.AdminViewAccount;
import com.assignment.digitalwallet.util.AdminViewTransactions;

import java.util.List;
import java.util.Map;

public class AdminViewUserAccountResponse {
    private String viewUserAccountStatus;
    private AdminViewAccount customerAccount;

    public String getViewUserAccountStatus() {
        return viewUserAccountStatus;
    }

    public void setViewUserAccountStatus(String viewUserAccountStatus) {
        this.viewUserAccountStatus = viewUserAccountStatus;
    }

    public AdminViewAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(AdminViewAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
}
