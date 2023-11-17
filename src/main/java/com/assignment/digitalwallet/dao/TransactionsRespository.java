package com.assignment.digitalwallet.dao;

import com.assignment.digitalwallet.databaseentities.WalletTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionsRespository extends CrudRepository<WalletTransactions, Long> {
    List<WalletTransactions> findAllByCustomerId(Long customerId);
}
