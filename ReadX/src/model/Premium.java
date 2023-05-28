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

    /**
     * This function returns the category of an object.
     * 
     * @return The method is returning an object of the Category class.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * This function sets the category of an object.
     * 
     * @param category The parameter "category" is an object of the class "Category". The method
     * "setCategory" sets the value of the instance variable "category" to the value passed as the
     * parameter.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

   /**
    * The function adds a book to the user's products and creates a bill for the purchase.
    * 
    * @param name The name of the book being bought.
    * @param price The price of the book being bought.
    * @param tempBook The "tempBook" parameter is an object of the class "Book". It is being passed as
    * an argument to the method "buyABook".
    * @return A boolean value is being returned.
    */
    @Override
    public boolean buyABook(String name, double price, Book tempBook){
        
        return (bills.add(new Bill(price, name, TypeOfProduct.BOOK)) && (userProducts.add(tempBook)));

    }

    /**
     * This Java function adds a new bill and a magazine to a user's products when they subscribe to
     * the magazine.
     * 
     * @param name The name of the user who wants to subscribe to the magazine.
     * @param subscribeCost The cost of subscribing to the magazine.
     * @param tempMagazine The "tempMagazine" parameter is an object of the class "Magazine". It is
     * being passed as an argument to the method "subscribe" along with the "name" and "subscribeCost"
     * parameters. The method is using this object to add the magazine to the user's list of subscribed
     * @return A boolean value is being returned.
     */
    @Override
    public boolean suscribe(String name, double subscribeCost, Magazine tempMagazine) {
         
        return (bills.add(new Bill(subscribeCost, name, TypeOfProduct.MAGAZINE)) && (userProducts.add(tempMagazine)));

    }

    /**
     * This function organizes a list of user products by their publication date in ascending order.
     */
    public void organizeByDatePremium() { 
        
        for (int i = 1; i < userProducts.size(); i++){
            for (int j = 0; j < i; j++) {
                if (userProducts.get(i).getPublicationDate().compareTo(userProducts.get(j).getPublicationDate()) < 0) {
                    userProducts.add(j, userProducts.remove(i));
                    break;
                }
            }
        }
    }

    /**
     * This function fills an ArrayList with 5x5 matrices of user product IDs, with each matrix
     * containing up to 25 product IDs.
     * 
     * @return An ArrayList of 2D String arrays, where each 2D array represents a premium library
     * filled with the user's products.
     */
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

    /**
     * The function returns a string representation of a matrix filled with data from a list of string
     * arrays.
     * 
     * @return The method `showMatrix()` returns a `String` that represents a matrix of strings. The
     * matrix is created by iterating over an `ArrayList` of `String` arrays and concatenating the
     * elements of each array into a string, separated by spaces and newlines. The resulting string is
     * then returned.
     */
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

    
    /**
     * The function returns a message for a premium lecture simulator with information about the
     * current page being read and options to navigate.
     * 
     * @param page The current page being read by the user.
     * @param totalPages The total number of pages in the book being read.
     * @param name a String representing the name of the book being read
     * @return The method is returning a String message that includes the name of the book being read,
     * the current page number, the total number of pages, and instructions for the user to navigate
     * through the reading session.
     */
    public String lectureSimulatorPremium( int page, int totalPages, String name){

		String msg = "";

        msg +="Sesión de lectura en progreso: \nLeyendo: "+ name + " \nLeyendo página: " + page +  " de " + totalPages;
        msg +="\nDigite A para pasar a la página anterior. \nDigite S para pasar a la página siguiente. \nDigite B para volver a la biblioteca";

		return msg;
	}

    
}
