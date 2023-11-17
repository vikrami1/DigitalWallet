package com.assignment.digitalwallet.responsejson;

import com.assignment.digitalwallet.util.AdminViewTransactions;

import java.util.List;
import java.util.Map;

public class AdminViewUserTransactionsResponse {
    private Map<Long, List<AdminViewTransactions>> transactions;

    public Map<Long, List<AdminViewTransactions>> getTransactions() {
        return transactions;
    }

    public void setTransactions(Map<Long, List<AdminViewTransactions>> transactions) {
        this.transactions = transactions;
    }
}
