package controllers.service;

import beans.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("exchangeService")
public class ExchangeServiceImplement implements ExchangeService {
    @Autowired
    private ExchangeService exchangeService;

    public List<Transaction> getTransactionLog() {
        return exchangeService.getTransactionLog();
    }

    public int createTransaction(Transaction transaction) {
        return exchangeService.createTransaction(transaction);
    }

    public int deleteTransaction(Transaction transaction) {
        return exchangeService.deleteTransaction(transaction);
    }
}
