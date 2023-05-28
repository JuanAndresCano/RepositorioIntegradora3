package model;
import java.util.ArrayList;

public class Premium extends User{
    private Category category;
    private ArrayList<Bill> bills;
    private ArrayList<Product> library;
    private ArrayList<Product> userProducts;

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
        library = new ArrayList<>();
        userProducts = new ArrayList<>();
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

    @Override
    public boolean buyABook(String name, double price, Book tempBook){
        
        return (bills.add(new Bill(price, name, TypeOfProduct.BOOK)) && (userProducts.add(tempBook)));

    }

    @Override
    public boolean suscribe(String name, double subscribeCost, Magazine tempMagazine) {
         
        return (bills.add(new Bill(subscribeCost, name, TypeOfProduct.MAGAZINE)) &&(userProducts.add(tempMagazine)));

    }

    
    
    public void organizeByDatePremium() {
        
        
    }

    public ArrayList<String[][]> fillLibraryPremium(){
        
        int cont = 0;
        double repeat = userProducts.size()/25;
        int repeat2 = (int)repeat;
        ArrayList<String[][]> list = new ArrayList<>(); 
        
        if(repeat2 == repeat){

            for (int k = repeat2; k < userProducts.size(); k++){
                String[][] matrix = new String[5][5];
                
                for (int i = 0; i < matrix.length; i++){
                    for (int j = 0; j < matrix[0].length; j++){
                        if(cont == userProducts.size()){
                            break;
                                
                        }else{
                            
                            matrix[i][j] = userProducts.get(cont).getId();
                                                            
                        }
                                
                        
                        cont++;
                            
                    }
                }
                list.add(matrix);
            }
                
        }
        if(repeat2 < repeat){
            for (int k = repeat2+1; k < userProducts.size(); k++){
                String[][] matrix = new String[5][5];
                
                for (int i = 0; i < matrix.length; i++){
                    for (int j = 0; j < matrix[0].length; j++){
                        if(cont == userProducts.size()){
                            break;
                                
                        }else{
                            
                            matrix[i][j] = userProducts.get(cont).getId();
                                                            
                        }
                                
                        
                        cont++;
                            
                    }
                }
                list.add(matrix);
            }
        }
    
        return list;
    
        
    }
    public String showMatrix() {

		ArrayList<String[][]> list = fillLibraryPremium();

		String print = "";
		for(int k = 0; k < list.size(); k++){

            print += "\n" + "Página " + (k+1);
            print += "\n-------------------\n";
            for (int i = 0; i < list.get(k).length; i++) {

                for (int j = 0; j < list.get(k)[0].length; j++) {

                    if (list.get(k)[i][j] == null) {

                        print += "---" + " ";
                    } else {
                        
                        print += list.get(k)[i][j] + " ";
                    }

                }
                print += "\n";
            }
        }
		return print;
	}

    
    public String lectureSimulatorPremium( int page, int totalPages, String name){

		String msg = "";

        msg +="Sesión de lectura en progreso: \nLeyendo: "+ name + " \nLeyendo página: " + page +  " de " + totalPages;
        msg +="\nDigite A para pasar a la página anterior. \nDigite S para pasar a la página siguiente. \nDigite B para volver a la biblioteca";

		return msg;
	}

    
}
