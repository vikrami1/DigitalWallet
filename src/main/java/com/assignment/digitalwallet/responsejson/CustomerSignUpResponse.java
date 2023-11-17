package com.assignment.digitalwallet.responsejson;

public class CustomerSignUpResponse {
    private String signupStatus;
    private Long customerId;

    public String getSignupStatus() {
        return signupStatus;
    }

    public void setSignupStatus(String signupStatus) {
        this.signupStatus = signupStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
