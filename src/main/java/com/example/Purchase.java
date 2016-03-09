package com.example;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by alexanderhughes on 3/9/16.
 */
@Entity
public class Purchase {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private String creditCard;
    @NotNull
    private int cvv;
    @NotNull
    private String category;
    @ManyToOne
    private Customer customer;

    public Purchase() {
    }

    public Purchase(Customer customer, LocalDateTime date, String creditCard, int cvv, String category) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
