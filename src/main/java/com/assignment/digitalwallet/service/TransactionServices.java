package com.assignment.digitalwallet.service;

import com.assignment.digitalwallet.dao.CustomerRespository;
import com.assignment.digitalwallet.dao.TransactionsRespository;
import com.assignment.digitalwallet.databaseentities.Customer;
import com.assignment.digitalwallet.databaseentities.CustomerAccount;
import com.assignment.digitalwallet.requestjson.*;
import com.assignment.digitalwallet.responsejson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.assignment.digitalwallet.databaseentities.WalletTransactions;

import java.util.List;
import java.util.Optional;

@Component
public class TransactionServices {
    @Autowired
    private TransactionsRespository transactionsRespository;

    @Autowired
    private CustomerRespository customerRespository;

    public CustomerAddMoneyResponse addMoneyService(CustomerAddMoneyRequest customerAddMoneyRequest) {
        CustomerAddMoneyResponse customerAddMoneyResponse = new CustomerAddMoneyResponse();
        Optional<Customer> customer = customerRespository.findById(customerAddMoneyRequest.getId());

        if(customer.isPresent()) {
            CustomerAccount customerAccount = customer.get().getCustomerAccount();
            customerAccount.setTotalBalance(customerAccount.getTotalBalance() + customerAddMoneyRequest.getMoneyToAdd());
            customerRespository.save(customer.get());

            saveTransactionRecord(customerAddMoneyRequest.getId(), "add", customerAddMoneyRequest.getMoneyToAdd());
            customerAddMoneyResponse.setAddMoneyStatus("Money " + customerAddMoneyRequest.getMoneyToAdd() + " was successfully added!");
            customerAddMoneyResponse.setNewBalance(String.valueOf(customerAccount.getTotalBalance()));
        }
        else {
            customerAddMoneyResponse.setAddMoneyStatus("User with id " + customerAddMoneyRequest.getId() + " was not found");
            customerAddMoneyResponse.setNewBalance("NA");
        }

        return customerAddMoneyResponse;
    }

    public CustomerPayoutMoneyResponse payoutMoneyService(CustomerPayoutMoneyRequest customerPayoutMoneyRequest) {
        CustomerPayoutMoneyResponse customerPayoutMoneyResponse = new CustomerPayoutMoneyResponse();
        Optional<Customer> customer = customerRespository.findById(customerPayoutMoneyRequest.getId());

        if(customer.isPresent()) {
            CustomerAccount customerAccount = customer.get().getCustomerAccount();
            if(customerAccount.getTotalBalance() < customerPayoutMoneyRequest.getMoneyToPayout()) {
                customerPayoutMoneyResponse.setPayoutMoneyStatus("Not enough balance to payout " + customerPayoutMoneyRequest.getMoneyToPayout());
                customerPayoutMoneyResponse.setNewBalance("NA");
            }
            else {
                customerAccount.setTotalBalance(customerAccount.getTotalBalance() - customerPayoutMoneyRequest.getMoneyToPayout());
                customerRespository.save(customer.get());

                saveTransactionRecord(customerPayoutMoneyRequest.getId(), "payout", customerPayoutMoneyRequest.getMoneyToPayout());
                customerPayoutMoneyResponse.setPayoutMoneyStatus("Money " + customerPayoutMoneyRequest.getMoneyToPayout() + " was successfully payed!");
                customerPayoutMoneyResponse.setNewBalance(String.valueOf(customerAccount.getTotalBalance()));
            }
        }
        else {
            customerPayoutMoneyResponse.setPayoutMoneyStatus("User with id " + customerPayoutMoneyRequest.getId() + " was not found");
            customerPayoutMoneyResponse.setNewBalance("NA");
        }

        return customerPayoutMoneyResponse;
    }

    private void saveTransactionRecord(Long customerId, String transactionType, double amount) {
        WalletTransactions transactions = new WalletTransactions();

        transactions.setCustomerId(customerId);
        transactions.setTransactionType(transactionType);
        transactions.setTransactionAmount(amount);

        transactionsRespository.save(transactions);
    }

    public TransactionEarnPointsResponse earnPointsService(TransactionEarnPointsRequest transactionEarnPointsRequest) {
        TransactionEarnPointsResponse transactionEarnPointsResponse = new TransactionEarnPointsResponse();
        Optional<WalletTransactions> walletTransactionOptional = transactionsRespository.findById(transactionEarnPointsRequest.getId());

        if(walletTransactionOptional.isPresent()) {
            WalletTransactions walletTransaction = walletTransactionOptional.get();
            walletTransaction.setPointsEarned(transactionEarnPointsRequest.getPointsToAdd());
            walletTransaction.setPointsBalance(transactionEarnPointsRequest.getPointsToAdd());
            transactionsRespository.save(walletTransaction);

            transactionEarnPointsResponse.setEarnPointsStatus("Points worth " + transactionEarnPointsRequest.getPointsToAdd() + " were added!");
        }
        else {
            transactionEarnPointsResponse.setEarnPointsStatus("Transaction with id " + transactionEarnPointsRequest.getId() + " was not found");
        }

        return transactionEarnPointsResponse;
    }

    public TransactionTransferPointsResponse transferPointsService(TransactionTransferPointsRequest transactionTransferPointsRequest) {
        TransactionTransferPointsResponse transactionTransferPointsResponse = new TransactionTransferPointsResponse();
        Optional<WalletTransactions> walletTransactionOptional = transactionsRespository.findById(transactionTransferPointsRequest.getId());

        if(walletTransactionOptional.isPresent()) {
            WalletTransactions walletTransaction = walletTransactionOptional.get();

            if(walletTransaction.getPointsBalance() >= transactionTransferPointsRequest.getPointsToTrasnfer()) {
                walletTransaction.setPointsTransferred(transactionTransferPointsRequest.getPointsToTrasnfer());
                walletTransaction.setPointsBalance(walletTransaction.getPointsBalance() - transactionTransferPointsRequest.getPointsToTrasnfer());
                transactionsRespository.save(walletTransaction);
                transactionTransferPointsResponse.setTransferPointsStatus("Points worth " + transactionTransferPointsRequest.getPointsToTrasnfer() + " were transferred!");
            }
            else {
                transactionTransferPointsResponse.setTransferPointsStatus("Not enough points to transfer " + transactionTransferPointsRequest.getPointsToTrasnfer() + " points");
            }
        }
        else {
            transactionTransferPointsResponse.setTransferPointsStatus("Transaction with id " + transactionTransferPointsRequest.getId() + " was not found");
        }

        return transactionTransferPointsResponse;
    }

    public TransactionEncashPointsResponse encashPointsService(TransactionEncashPointsRequest transactionEncashPointsRequest) {
        TransactionEncashPointsResponse transactionEncashPointsResponse = new TransactionEncashPointsResponse();
        Optional<WalletTransactions> walletTransactionOptional = transactionsRespository.findById(transactionEncashPointsRequest.getId());

        if(walletTransactionOptional.isPresent()) {
            WalletTransactions walletTransaction = walletTransactionOptional.get();

            if(walletTransaction.getPointsBalance() >= transactionEncashPointsRequest.getPointsToEncash()) {
                walletTransaction.setPointsEncashed(transactionEncashPointsRequest.getPointsToEncash());
                walletTransaction.setPointsBalance(walletTransaction.getPointsBalance() - transactionEncashPointsRequest.getPointsToEncash());
                transactionsRespository.save(walletTransaction);
                transactionEncashPointsResponse.setEncashPointsStatus("Points worth " + transactionEncashPointsRequest.getPointsToEncash() + " were encashed!");
            }
            else {
                transactionEncashPointsResponse.setEncashPointsStatus("Not enough points to encash " + transactionEncashPointsRequest.getPointsToEncash() + " points");
            }
        }
        else {
            transactionEncashPointsResponse.setEncashPointsStatus("Transaction with id " + transactionEncashPointsRequest.getId() + " was not found");
        }

        return transactionEncashPointsResponse;
    }

    public TransactionViewAllResponse viewTransactionsService(TransactionViewAllRequest transactionViewAllRequest) {
        TransactionViewAllResponse transactionViewAllResponse = new TransactionViewAllResponse();
        List<WalletTransactions> allTransactions =  transactionsRespository.findAllByCustomerId(transactionViewAllRequest.getUserId());

        transactionViewAllResponse.setViewAllStatus("Transactions found: " + allTransactions.size());
        transactionViewAllResponse.setAllTransactions(allTransactions);
        return transactionViewAllResponse;
    }
}
