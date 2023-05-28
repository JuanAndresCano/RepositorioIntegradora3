package model;

public interface BuyOrSuscribe {
    public boolean buyABook(String name, double price, Book tempBook);
    public boolean suscribe(String name, double subscribeCost, Magazine tempMagazine);

}
