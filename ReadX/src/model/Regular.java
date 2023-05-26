package model;

public class Regular extends User{
    
    private Bill[] bills;

    public Regular(String id, String name, String nickname){
        super(id, name, nickname);
        bills = new Bill[7];
    }




    
}
