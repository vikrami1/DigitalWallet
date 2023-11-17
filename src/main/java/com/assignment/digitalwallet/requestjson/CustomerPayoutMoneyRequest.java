package com.assignment.digitalwallet.requestjson;

public class CustomerPayoutMoneyRequest {
    private Long id;
    private double moneyToPayout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoneyToPayout() {
        return moneyToPayout;
    }

    public void setMoneyToPayout(double moneyToPayout) {
        this.moneyToPayout = moneyToPayout;
    }
}
