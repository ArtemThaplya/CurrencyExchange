package dao;


import beans.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import readExchangeRates.JsonReader;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@Repository("exchangeDao")
public class ExchangeDaoImplement implements ExchangeDao {
    private static final String JSON_CURRENCY_RATE = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private JsonReader jsonReader;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public int deleteTransaction(Transaction transaction) {
        return template.update(
                "UPDATE Transaction SET status = ? WHERE " + transaction.getId() + " = ?", new Object[]{
                        transaction.getStatus()});
    }

    public List<Transaction> getTransactionLog() {
        return template.query("SELECT * FROM Transaction", (rs, row) -> {
            Transaction e = new Transaction();
            e.setId(rs.getInt(1));
            e.setFullName(rs.getString(2));
            e.setCcy(rs.getString(3));
            e.setBase_ccy(rs.getString(4));
            e.setBuy(rs.getDouble(5));
            e.setSale(rs.getDouble(6));
            e.setAmount(rs.getBigDecimal(7));
            e.setDate(rs.getDate(8));
            e.setStatus(rs.getBoolean(9));
            return e;
        });
    }

    public int createTransaction(Transaction transaction) {
        LocalDate localDate = LocalDate.now();
        JSONObject jsObject = null;
        try {
            jsObject = JsonReader.readJsonFromUrl(JSON_CURRENCY_RATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template.update(
                "INSERT INTO Transaction(" +
                        "id, fullName,  ccy, base_ccy, buy, sale, amount, date, status)" +
                        "VALUES(?,?,?,?,?,?,?,?,?)",
                new Object[]{
                        transaction.getId(), transaction.getFullName(),
                        transaction.getCcy(), transaction.getBase_ccy(),
                        jsObject.get(transaction.getCcy()), jsObject.get(transaction.getBase_ccy()),
                        transaction.getAmount(), localDate,
                        true});
    }
}  