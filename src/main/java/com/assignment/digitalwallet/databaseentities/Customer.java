package com.assignment.digitalwallet.databaseentities;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_username", nullable = false)
    private String customerUsername;

    @Column(name = "customer_password", nullable = false)
    private String customerPassword;

    @Column(name = "is_logged_in", columnDefinition = "boolean default false")
    private boolean isLoggedIn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_account", referencedColumnName = "id")
    private CustomerAccount customerAccount;

    @Column(name = "current_status", nullable = true)
    private String currentStaus;

    @Column(name = "reason_for_current_staus", nullable = true)
    private String reasonForcurrentStaus;

    public String getReasonForcurrentStaus() {
        return reasonForcurrentStaus;
    }

    public void setReasonForcurrentStaus(String reasonForcurrentStaus) {
        this.reasonForcurrentStaus = reasonForcurrentStaus;
    }

    public String getCurrentStaus() {
        return currentStaus;
    }

    public void setCurrentStaus(String currentStaus) {
        this.currentStaus = currentStaus;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
