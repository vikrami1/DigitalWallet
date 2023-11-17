package com.assignment.digitalwallet.requestjson;

public class AdminChangeStatusRequest {
    private Long userId;
    private String newStatus;
    private String reasonForNewStatus;

    public String getReasonForNewStatus() {
        return reasonForNewStatus;
    }

    public void setReasonForNewStatus(String reasonForNewStatus) {
        this.reasonForNewStatus = reasonForNewStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
