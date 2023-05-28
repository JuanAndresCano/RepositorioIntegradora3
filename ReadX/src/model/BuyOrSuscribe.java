package model;

public interface BuyOrSuscribe {
   
    /**
     * This function checks if a book can be bought with a given name, price, and Book object.
     * 
     * @param name The name of the person who is buying the book.
     * @param price The price parameter is a double data type that represents the cost of the book.
     * @param tempBook The parameter "tempBook" is an object of the class "Book". It is likely that
     * this method is part of a larger program that involves buying and selling books, and "tempBook"
     * represents the book that the user wants to buy. The object likely contains information such as
     * the book's title
     * @return The method is returning a boolean value.
     */
    public boolean buyABook(String name, double price, Book tempBook);
    
    /**
     * This function subscribes a person to a magazine by providing their name, subscription cost, and
     * the magazine object.
     * 
     * @param name The name of the person who wants to subscribe to the magazine.
     * @param subscribeCost The subscribeCost parameter is a double data type that represents the cost
     * of subscribing to a magazine.
     * @param tempMagazine tempMagazine is a variable of type Magazine that represents the magazine
     * that the user wants to subscribe to. It could contain information such as the name of the
     * magazine, the frequency of publication, the cost of a single issue, and any other relevant
     * details about the magazine.
     * @return The method is returning a boolean value.
     */
    public boolean suscribe(String name, double subscribeCost, Magazine tempMagazine);

}
