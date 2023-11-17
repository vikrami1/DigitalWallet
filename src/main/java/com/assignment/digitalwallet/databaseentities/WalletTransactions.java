package com.assignment.digitalwallet.databaseentities;

import javax.persistence.*;

@Entity
@Table(name = "Wallet_Transactions")
public class WalletTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "transaction_amount", nullable = false)
    private double transactionAmount;

    @Column(name = "points_earned", nullable = false)
    private double pointsEarned;

    @Column(name = "points_encashed", nullable = false)
    private double pointsEncashed;

    @Column(name = "points_transferred", nullable = false)
    private double pointsTransferred;

    @Column(name = "points_balance", nullable = false)
    private double pointsBalance;

    public double getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(double pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public double getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public double getPointsEncashed() {
        return pointsEncashed;
    }

    public void setPointsEncashed(double pointsEncashed) {
        this.pointsEncashed = pointsEncashed;
    }

    public double getPointsTransferred() {
        return pointsTransferred;
    }

    public void setPointsTransferred(double pointsTransferred) {
        this.pointsTransferred = pointsTransferred;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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
}
