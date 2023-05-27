package model;

public class Regular extends User{
    
    private Bill[] bills;

    public Regular(String id, String name, String nickname){
        super(id, name, nickname);
        bills = new Bill[7];
    }

    @Override
    public boolean buyABook(String name, double price){

        int amountOfBooks = 0;

        for (int i = 0; i < bills.length; i++){

            if (bills[i] != null){

                if(bills[i].getTypeOfProduct() == TypeOfProduct.BOOK){
                    amountOfBooks++;
                }

            }

        }

        if (amountOfBooks < 5){
            for (int j = 0; j < bills.length; j++){
                if (bills[j] != null){
                    bills[j] = new Bill(price, name, TypeOfProduct.BOOK);
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public boolean suscribe() {
        return false;
    }


    
}
