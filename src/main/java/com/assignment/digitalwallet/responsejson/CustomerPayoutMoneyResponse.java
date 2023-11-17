package com.assignment.digitalwallet.responsejson;

public class CustomerPayoutMoneyResponse {
    private String payoutMoneyStatus;
    private String newBalance;

    public String getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(String newBalance) {
        this.newBalance = newBalance;
    }

    public String getPayoutMoneyStatus() {
        return payoutMoneyStatus;
    }

    public void setPayoutMoneyStatus(String payoutMoneyStatus) {
        this.payoutMoneyStatus = payoutMoneyStatus;
    }
}
