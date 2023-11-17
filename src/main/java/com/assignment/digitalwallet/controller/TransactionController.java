package com.assignment.digitalwallet.controller;

import com.assignment.digitalwallet.requestjson.*;
import com.assignment.digitalwallet.responsejson.*;
import com.assignment.digitalwallet.service.CustomerServices;
import com.assignment.digitalwallet.service.TransactionServices;
import com.assignment.digitalwallet.util.AvailableEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private TransactionServices transactionServices;

    @PostMapping(path = AvailableEndPoints.TRANSACTION_ADD_MONEY_TO_ACCOUNT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerAddMoneyResponse> addMoneyToAccount(@RequestBody CustomerAddMoneyRequest customerAddMoneyRequest) {
        return ResponseEntity.accepted().body(transactionServices.addMoneyService(customerAddMoneyRequest));
    }

    @PostMapping(path = AvailableEndPoints.CUSTOMER_PAYOUTMONEY, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerPayoutMoneyResponse> payoutMoney(@RequestBody CustomerPayoutMoneyRequest customerPayoutMoneyRequest) {
        return ResponseEntity.accepted().body(transactionServices.payoutMoneyService(customerPayoutMoneyRequest));
    }

    @PostMapping(path = AvailableEndPoints.TRANSACTIONS_VIEW, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionViewAllResponse> viewTransactions(@RequestBody TransactionViewAllRequest transactionViewAllRequest) {
        return ResponseEntity.accepted().body(transactionServices.viewTransactionsService(transactionViewAllRequest));
    }

    @PostMapping(path = AvailableEndPoints.TRANSACTION_EARN_POINTS, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionEarnPointsResponse> earnPoints(@RequestBody TransactionEarnPointsRequest transactionEarnPointsRequest) {
        return ResponseEntity.accepted().body(transactionServices.earnPointsService(transactionEarnPointsRequest));
    }

    @PostMapping(path = AvailableEndPoints.TRANSACTION_TRANSFER_POINTS, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionTransferPointsResponse> transferPoints(@RequestBody TransactionTransferPointsRequest transactionTransferPointsRequest) {
        return ResponseEntity.accepted().body(transactionServices.transferPointsService(transactionTransferPointsRequest));
    }

    @PostMapping(path = AvailableEndPoints.TRANSACTION_ENCASH_POINTS, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionEncashPointsResponse> encashPoints(@RequestBody TransactionEncashPointsRequest transactionEncashPointsRequest) {
        return ResponseEntity.accepted().body(transactionServices.encashPointsService(transactionEncashPointsRequest));
    }
}
