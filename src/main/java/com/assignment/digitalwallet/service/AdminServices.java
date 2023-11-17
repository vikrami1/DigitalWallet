package com.assignment.digitalwallet.service;

import com.assignment.digitalwallet.dao.CustomerRespository;
import com.assignment.digitalwallet.dao.TransactionsRespository;
import com.assignment.digitalwallet.databaseentities.Customer;
import com.assignment.digitalwallet.databaseentities.CustomerAccount;
import com.assignment.digitalwallet.databaseentities.WalletTransactions;
import com.assignment.digitalwallet.requestjson.AdminChangeStatusRequest;
import com.assignment.digitalwallet.requestjson.AdminViewUserAccountRequest;
import com.assignment.digitalwallet.responsejson.*;
import com.assignment.digitalwallet.util.AdminViewAccount;
import com.assignment.digitalwallet.util.AdminViewCustomer;
import com.assignment.digitalwallet.util.AdminViewTransactions;
import com.assignment.digitalwallet.util.CustomerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdminServices {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private CustomerUtility customerUtility;

    @Autowired
    private TransactionsRespository transactionsRespository;

    public AdminViewUsersResponse viewUsersService() {
        AdminViewUsersResponse adminViewUsersResponse = new AdminViewUsersResponse();
        Iterable<Customer> allCustomers = customerRespository.findAll();
        List<AdminViewCustomer> allAdminViewCustomer = new ArrayList<>();

        for(Customer currCustomer: allCustomers) {
            AdminViewCustomer adminViewCustomer = new AdminViewCustomer();
            adminViewCustomer.setCustomerName(currCustomer.getCustomerName());
            adminViewCustomer.setCustomerUsername(currCustomer.getCustomerUsername());
            adminViewCustomer.setIsLoggedIn(currCustomer.isLoggedIn());

            allAdminViewCustomer.add(adminViewCustomer);
        }

        adminViewUsersResponse.setAllUsers(allAdminViewCustomer);
        return adminViewUsersResponse;
    }

    public AdminChangeStatusResponse changeStatusService(AdminChangeStatusRequest adminChangeStatusRequest) {
        AdminChangeStatusResponse adminChangeStatusResponse = new AdminChangeStatusResponse();
        Optional<Customer> customerToChangeStatusForOptional = customerRespository.findById(adminChangeStatusRequest.getUserId());

        if(customerToChangeStatusForOptional.isPresent()) {
            Customer customerToChangeStatusFor = customerToChangeStatusForOptional.get();
            customerToChangeStatusFor.setCurrentStaus(adminChangeStatusRequest.getNewStatus());
            customerToChangeStatusFor.setReasonForcurrentStaus(adminChangeStatusRequest.getReasonForNewStatus());

            adminChangeStatusResponse.setChangeStatus("Status of user was changed to " + adminChangeStatusRequest.getNewStatus());
        }
        else {
            adminChangeStatusResponse.setChangeStatus("User with user id " + adminChangeStatusRequest.getUserId() + " was not found!");
        }

        return adminChangeStatusResponse;
    }

    public AdminViewUserTransactionsResponse viewUserTransactionsService() {
        AdminViewUserTransactionsResponse adminViewUserTransactionsResponse = new AdminViewUserTransactionsResponse();
        Iterable<WalletTransactions> walletTransactions = transactionsRespository.findAll();
        Map<Long, List<AdminViewTransactions>> transactionsGrouped = new HashMap<>();

        for(WalletTransactions currTransaction: walletTransactions) {
            Long transactionBelongsTo = currTransaction.getCustomerId();

            if(transactionsGrouped.containsKey(transactionBelongsTo)) {
                List<AdminViewTransactions> gf = transactionsGrouped.get(transactionBelongsTo);
                gf.add(getAdminViewTransaction(currTransaction));
            }
            else {
                List<AdminViewTransactions> transactions = new ArrayList<>();
                transactions.add(getAdminViewTransaction(currTransaction));
                transactionsGrouped.put(transactionBelongsTo, transactions);
            }
        }

        adminViewUserTransactionsResponse.setTransactions(transactionsGrouped);
        return adminViewUserTransactionsResponse;
    }

    private AdminViewTransactions getAdminViewTransaction(WalletTransactions currTransactionWallet) {
        AdminViewTransactions adminViewTransactions = new AdminViewTransactions();

        adminViewTransactions.setTransactionType(currTransactionWallet.getTransactionType());
        adminViewTransactions.setTransactionAmount(currTransactionWallet.getTransactionAmount());
        adminViewTransactions.setPointsBalance(currTransactionWallet.getPointsBalance());
        adminViewTransactions.setPointsEarned(currTransactionWallet.getPointsEarned());
        adminViewTransactions.setPointsCashed(currTransactionWallet.getPointsEncashed());
        adminViewTransactions.setPointsTransferred(currTransactionWallet.getPointsTransferred());

        return adminViewTransactions;
    }

    public AdminViewUserAccountResponse viewUserAccountService(AdminViewUserAccountRequest adminViewUserAccountRequest) {
        AdminViewUserAccountResponse adminViewUserAccountResponse = new AdminViewUserAccountResponse();
        Optional<Customer> customerToGetAccountOptional = customerRespository.findById(adminViewUserAccountRequest.getUserId());

        if(customerToGetAccountOptional.isPresent()) {
            CustomerAccount customerAccountGot = customerToGetAccountOptional.get().getCustomerAccount();
            AdminViewAccount adminViewAccount = new AdminViewAccount();

            adminViewAccount.setCustomerId(customerAccountGot.getCustomer().getId());
            adminViewAccount.setTotalBalance(customerAccountGot.getTotalBalance());

            adminViewUserAccountResponse.setCustomerAccount(adminViewAccount);
            adminViewUserAccountResponse.setViewUserAccountStatus("Account retreived successfully");
        }
        else {
            adminViewUserAccountResponse.setViewUserAccountStatus("Account not found");
        }

        return adminViewUserAccountResponse;
    }
}
