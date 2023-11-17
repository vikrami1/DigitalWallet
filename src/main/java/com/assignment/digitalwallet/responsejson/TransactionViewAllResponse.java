package com.assignment.digitalwallet.responsejson;

import com.assignment.digitalwallet.databaseentities.WalletTransactions;

import java.util.List;

public class TransactionViewAllResponse {
    private String viewAllStatus;
    private List<WalletTransactions> allTransactions;

    public String getViewAllStatus() {
        return viewAllStatus;
    }

    public void setViewAllStatus(String viewAllStatus) {
        this.viewAllStatus = viewAllStatus;
    }

    public List<WalletTransactions> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<WalletTransactions> allTransactions) {
        this.allTransactions = allTransactions;
    }
}
