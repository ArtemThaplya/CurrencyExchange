package controllers.service;

import beans.Transaction;

import java.util.List;

public interface ExchangeService {
    public List<Transaction> getTransactionLog();
    public int createTransaction(Transaction transaction);
    public int deleteTransaction(Transaction transaction);

}
