package com.assignment.digitalwallet.requestjson;

public class CustomerAddMoneyRequest {
    private Long id;
    private double moneyToAdd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoneyToAdd() {
        return moneyToAdd;
    }

    public void setMoneyToAdd(double moneyToAdd) {
        this.moneyToAdd = moneyToAdd;
    }
}
