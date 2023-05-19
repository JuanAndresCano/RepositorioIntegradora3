package model;

import java.util.Calendar;

public class Book extends Product{
    
    private String review;
    private Genre genre;
    private double price;
    private int amountOfSells;

    public Book(String id, String name, int numOfPages, Calendar publicationDate, String review, Genre genre, double price, int amountOfSells){

        super(id, name, numOfPages, publicationDate);

        this.review = review;
        this.genre = genre;
        this.price = price;
        this.amountOfSells = amountOfSells;
    }

    /**
     * Description: It is the getter of the review.
     * @return review String It is the review of the product.
     */
    public String getReview() {
        return review;
    }

    /**
     * Description: It is the getter of the genre.
     * @return genre Genre It is the genre of the product.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Description: It is the getter of the price.
     * @return price double It is the price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Description: It is the getter of the amountOfSells.
     * @return amountOfSells int It is the amountOfSells
     */
    public int getAmountOfSells() {
        return amountOfSells;
    }

    /**
     * Description: It is the setter of the amountOfSells.
     * @param amountOfSells int It is the amount of units selled.
     */
    public void setAmountOfSells(int amountOfSells) {
        this.amountOfSells = amountOfSells;
    }
    
    /**
     * Description: This method updates the amountOfSells.
     * @param newSells int It is the amount of units selled that will be added to the total amount. 
     */
    public void updateAmountOfSells(int newSells){
        this.amountOfSells = getAmountOfSells() + newSells;
    }
    

}
