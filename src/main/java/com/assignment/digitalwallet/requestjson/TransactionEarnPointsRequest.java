package com.assignment.digitalwallet.requestjson;

public class TransactionEarnPointsRequest {
    private Long id;
    private double pointsToAdd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPointsToAdd() {
        return pointsToAdd;
    }

    public void setPointsToAdd(double pointsToAdd) {
        this.pointsToAdd = pointsToAdd;
    }
}
