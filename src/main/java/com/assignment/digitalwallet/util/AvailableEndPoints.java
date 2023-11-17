package com.assignment.digitalwallet.util;

public class AvailableEndPoints {
    //Customer Endpoints
    public static final String CUSTOMER_SIGN_UP="customer/signup";
    public static final String CUSTOMER_LOGIN="customer/login";

    //Transaction Endpoints
    public static final String TRANSACTION_ADD_MONEY_TO_ACCOUNT ="transaction/addmoney";
    public static final String CUSTOMER_PAYOUTMONEY="transaction/payoutmoney";
    public static final String TRANSACTIONS_VIEW="transaction/viewtransactions";
    public static final String TRANSACTION_EARN_POINTS="transaction/earnpoints";
    public static final String TRANSACTION_TRANSFER_POINTS="transaction/transferpoints";
    public static final String TRANSACTION_ENCASH_POINTS="transaction/encashpoints";

    //Admin Endpoints
    public static final String ADMIN_VIEW_USERS="admin/viewusers";
    public static final String ADMIN_CHANGE_STATUS="admin/changeuserstatus";
    public static final String ADMIN_VIEW_USER_TRANSACTIONS="admin/viewusertransactions";
    public static final String ADMIN_VIEW_USER_ACCOUNT="admin/viewuseraccount";
}
