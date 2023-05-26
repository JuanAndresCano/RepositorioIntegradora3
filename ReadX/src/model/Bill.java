package model;

import java.util.Calendar;

public class Bill {

    private Calendar dateOfSell;
    private double payment;
    private String productName;
    private TypeOfProduct typeOfProduct;

    public Bill (Calendar dateOfSell, double payment, String productName, TypeOfProduct typeOfProduct){

        this.dateOfSell = dateOfSell;
        this.payment = payment;
        this.productName = productName;
        this.typeOfProduct = typeOfProduct;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    
}
