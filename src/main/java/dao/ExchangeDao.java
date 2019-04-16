package dao;

import beans.Transaction;

import java.util.List;

public interface ExchangeDao {
    public List<Transaction> getTransactionLog();
    public int createTransaction(Transaction employee);
    public int deleteTransaction(Transaction transaction);
}
