package controllers;

import beans.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import controllers.service.ExchangeService;

import java.util.List;

@Controller
public class CurrencyExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    /**
     * Provides a list of operations in the object model
     */
    @RequestMapping("/viewExchange")
    public String viewExchange(Model m) {
        List<Transaction> list = exchangeService.getTransactionLog();
        m.addAttribute("list", list);
        return "redirect:/viewExchange";
    }

    @RequestMapping(value = "/exchange", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Transaction> create(@RequestBody Transaction exchange) {
        HttpHeaders headers = new HttpHeaders();
        if (exchange == null) {
            return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
        }
        exchangeService.createTransaction(exchange);
        headers.add("Transaction Created  - ", String.valueOf(exchange.getId()));
        return new ResponseEntity<Transaction>(exchange, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/transaction/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Transaction> delete(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        Transaction transaction = (Transaction) exchangeService.getTransactionLog();
        if (transaction == null) {
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
        exchangeService.deleteTransaction(transaction);
        headers.add("Transaction Deleted - ", String.valueOf(id));
        return new ResponseEntity<Transaction>(transaction, headers, HttpStatus.NO_CONTENT);
    }

}
