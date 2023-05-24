package model;

import java.util.Calendar;

public class Bill {

    private Calendar dateOfSell;
    private double payment;
    private String bookName;

    public Bill (Calendar dateOfSell, double payment){

        this.dateOfSell = dateOfSell;
        this.payment = payment;

    }

    public Calendar getDateOfSell() {
        return dateOfSell;
    }

    public void setDateOfSell(Calendar dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    
}
