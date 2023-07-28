package br.tech.ada.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    String ticker;
    Date timestamp;
    Double close;

    public Stock(String ticker, Date d, Double closeValue) {
        this.ticker = ticker;
        this.timestamp = d;
        this.close = closeValue;
    }

    public Stock() {

    }
}
