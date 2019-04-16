package beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    private int id;


    private String fullName;
    private String ccy;
    private String base_ccy;
    private double buy;
    private double sale;
    private BigDecimal amount;
    private Date date;
    private Boolean status;

    public Transaction() {
    }

    @JsonCreator
    public Transaction(@JsonProperty("id") int id,@JsonProperty("fullName") String fullName,
                       @JsonProperty("ccy") String ccy, @JsonProperty("base_ccy") String base_ccy,
                       @JsonProperty("by") double buy, @JsonProperty("sale") double sale,
                       @JsonProperty("amount") BigDecimal amount, @JsonProperty("date") Date date,
                       @JsonProperty("status") Boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                ", amount=" + amount +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
