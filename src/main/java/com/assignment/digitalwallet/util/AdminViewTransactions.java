package com.assignment.digitalwallet.util;

public class AdminViewTransactions {
    private String transactionType;
    private double transactionAmount;
    private double pointsEarned;
    private double pointsCashed;
    private double pointsTransferred;
    private double pointsBalance;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public double getPointsCashed() {
        return pointsCashed;
    }

    public void setPointsCashed(double pointsCashed) {
        this.pointsCashed = pointsCashed;
    }

    public double getPointsTransferred() {
        return pointsTransferred;
    }

    public void setPointsTransferred(double pointsTransferred) {
        this.pointsTransferred = pointsTransferred;
    }

    public double getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(double pointsBalance) {
        this.pointsBalance = pointsBalance;
    }
}
