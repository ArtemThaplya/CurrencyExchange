package com.temka.controllers.service;

import com.temka.beans.Transaction;
import java.util.List;

public interface ExchangeService {
    List<Transaction> getTransactionLog();
    int createTransaction(Transaction transaction);
    int deleteTransaction(Transaction transaction);

}
