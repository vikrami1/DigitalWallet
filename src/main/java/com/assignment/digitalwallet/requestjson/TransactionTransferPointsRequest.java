package com.assignment.digitalwallet.requestjson;

public class TransactionTransferPointsRequest {
    private Long id;
    private double pointsToTrasnfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPointsToTrasnfer() {
        return pointsToTrasnfer;
    }

    public void setPointsToTrasnfer(double pointsToTrasnfer) {
        this.pointsToTrasnfer = pointsToTrasnfer;
    }
}
