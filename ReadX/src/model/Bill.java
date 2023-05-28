package model;

import java.util.Calendar;

public class Bill {

    private Calendar dateOfSell;
    private double payment;
    private String productName;
    private TypeOfProduct typeOfProduct;

    public Bill (double payment, String productName, TypeOfProduct typeOfProduct){

        
        this.payment = payment;
        this.productName = productName;
        this.typeOfProduct = typeOfProduct;
        this.dateOfSell = Calendar.getInstance();
    }
    
    /**
     * The function returns the date of a sell as a Calendar object.
     * 
     * @return The method `getDateOfSell()` is returning a `Calendar` object, which represents the date
     * of a sell.
     */
    public Calendar getDateOfSell() {
        return dateOfSell;
    }

    /**
     * This function sets the date of sell for an object.
     * 
     * @param dateOfSell It is a variable of type Calendar that represents the date on which a sell
     * transaction occurred. The method sets the value of this variable to the value passed as a
     * parameter.
     */
    public void setDateOfSell(Calendar dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    /**
     * The function returns the payment value as a double.
     * 
     * @return The method `getPayment()` is returning a `double` value, which is the value of the
     * variable `payment`.
     */
    public double getPayment() {
        return payment;
    }

    /**
     * This Java function sets the payment value for an object.
     * 
     * @param payment a variable of type double that represents the payment amount. The method
     * setPayment() sets the value of this variable.
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * The function returns the name of a product as a string.
     * 
     * @return The method `getProductName()` is returning a `String` value, which is the value of the
     * variable `productName`.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This function sets the name of a product.
     * 
     * @param productName productName is a variable of type String that represents the name of a
     * product. The method setProductName() sets the value of this variable to the value passed as a
     * parameter.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This function returns the type of product.
     * 
     * @return The method `getTypeOfProduct()` is returning an object of the `TypeOfProduct` class.
     */
    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    /**
     * This Java function sets the type of product for an object.
     * 
     * @param typeOfProduct typeOfProduct is a variable of the TypeOfProduct data type. It is being set
     * to a value passed as a parameter to the method.
     */
    public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    
}
