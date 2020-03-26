package com.temka.dao;

import com.temka.beans.Transaction;

import java.util.List;

public interface ExchangeDao {
    List<Transaction> getTransactionLog();
    int createTransaction(Transaction employee);
    int deleteTransaction(Transaction transaction);
}
