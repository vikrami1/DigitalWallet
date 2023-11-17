package com.assignment.digitalwallet.responsejson;

public class CustomerAddMoneyResponse {
    private String addMoneyStatus;
    private String newBalance;

    public String getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(String newBalance) {
        this.newBalance = newBalance;
    }

    public String getAddMoneyStatus() {
        return addMoneyStatus;
    }

    public void setAddMoneyStatus(String addMoneyStatus) {
        this.addMoneyStatus = addMoneyStatus;
    }
}
