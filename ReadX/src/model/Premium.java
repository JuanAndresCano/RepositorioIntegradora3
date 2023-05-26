package model;
import java.util.ArrayList;

public class Premium extends User{
    private Category category;
    private ArrayList<Bill> bills;

    public Premium(String id, String name, String nickname, int userCategory){
        super(id, name, nickname);
        
        this.category = Category.SILVER;

        if(userCategory == 2){
            this.category = Category.GOLD;
        }

        if(userCategory == 3){
            this.category = Category.DIAMOND;
        }
        
        bills = new ArrayList<>();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAtributes(){
		String msg = "";

		

		return msg;
	}
}
