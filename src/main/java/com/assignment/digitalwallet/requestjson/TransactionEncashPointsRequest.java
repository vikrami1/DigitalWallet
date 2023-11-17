package com.assignment.digitalwallet.requestjson;

public class TransactionEncashPointsRequest {
    private Long id;
    private double pointsToEncash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPointsToEncash() {
        return pointsToEncash;
    }

    public void setPointsToEncash(double pointsToEncash) {
        this.pointsToEncash = pointsToEncash;
    }
}
