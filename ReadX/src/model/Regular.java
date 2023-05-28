package model;

public class Regular extends User{
    
    private Bill[] bills;
    private Product[] userProducts;

    
    public Regular(String id, String name, String nickname){
        super(id, name, nickname);
        bills = new Bill[7];
        userProducts = new Product[7];

    }

    /**
     * The function checks if the user has bought less than 5 books, and if so, adds a new bill and
     * book to their account.
     * 
     * @param name The name of the book being bought.
     * @param price The price of the book being bought.
     * @param tempBook an object of the Book class that represents the book being bought.
     * @return The method returns a boolean value. It returns true if the book was successfully bought
     * and added to the user's products, and false if the user already has 5 books or if there is no
     * space left in the bills array.
     */
    @Override
    public boolean buyABook(String name, double price, Book tempBook){

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

                if (bills[j] == null){

                    bills[j] = new Bill(price, name, TypeOfProduct.BOOK);

                    for (int k = 0; k < userProducts.length; k++){

                        if(userProducts[k] == null){
                            userProducts[k] = tempBook;
                            return true;

                        }

                    }
                    
                }

            }

        }

        return false;
        
    }

    /**
     * This Java function allows a user to subscribe to a magazine if they have subscribed to less than
     * two magazines, and adds the subscription to their list of user products.
     * 
     * @param name The name of the user who wants to subscribe to the magazine.
     * @param subscribeCost The cost of subscribing to the magazine.
     * @param tempMagazine an object of the Magazine class that represents the magazine the user wants
     * to subscribe to.
     * @return The method returns a boolean value. It returns true if the user is able to subscribe to
     * the magazine, and false if they are not able to subscribe.
     */
    @Override
    public boolean suscribe(String name, double subscribeCost, Magazine tempMagazine) {

        int amountOfMagazines = 0;

        for (int i = 0; i < bills.length; i++){

            if (bills[i] != null){

                if(bills[i].getTypeOfProduct() == TypeOfProduct.MAGAZINE){
                    amountOfMagazines++;
                }

            }

        }

        if (amountOfMagazines < 2){

            for (int j = 0; j < bills.length; j++){


                if (bills[j] == null){
                    bills[j] = new Bill(subscribeCost, name, TypeOfProduct.MAGAZINE);
                    for (int k = 0; k < userProducts.length; k++){
                        if(userProducts[k] == null){
                            userProducts[k] = tempMagazine;
                            return true;
                        }
                    }
                    
                }

            }

        }

        return false;
    }

    
    /**
     * This function organizes an array of user products by their publication date in ascending order.
     */
    public void organizeByDateRegular() {

        for (int i = 1; i < userProducts.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((userProducts[i] != null && userProducts[j] != null) && (userProducts[i].getPublicationDate().compareTo(userProducts[j].getPublicationDate()) < 0)) {
                    if(userProducts[i] instanceof Book){

                        Book temp = (Book)userProducts[i];

                        for (int k = i; k > j; k--) {
                            userProducts[k] = userProducts[k - 1];
                        }

                        userProducts[j] = temp;

                        break;

                    }else{

                        Magazine temp = (Magazine)userProducts[i];

                        for (int k = i; k > j; k--) {
                            userProducts[k] = userProducts[k - 1];
                        }

                        userProducts[j] = temp;

                        break;

                    }
                }
            }
        }
    }

    /**
     * This function fills a 5x5 matrix with product IDs from an array of user products.
     * 
     * @return The method `fillLibraryRegular` returns a 2D array of Strings.
     */
    public String[][] fillLibraryRegular(){

        String[][] matrix = new String[5][5];
		int cont = 0;

		for (int i = 0; i < matrix.length; i++){

			for (int j = 0; j < matrix[0].length; j++){

				if(cont == userProducts.length){

					break;

				}else{

					if(userProducts[cont] != null){

                        matrix[i][j] = userProducts[cont].getId();

                    }	
				}

			cont++;	

			}

		}

		return matrix;
    }

    /**
     * The function returns a string representation of a matrix filled with library items.
     * 
     * @return The method is returning a String that represents a matrix filled with library books.
     */
    public String showMatrix() {

		String[][] matrix = fillLibraryRegular();

		String print = "";
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null) {

					print += "|---|" + " ";
				} else {
					
					print += "|"+matrix[i][j] + "| ";
				}

			}
			print += "\n";
		}

		return print;
	}

    /**
     * The function returns a message for a regular lecture simulator with information about the
     * current page, total pages, and options to navigate.
     * 
     * @param page The current page being read by the user.
     * @param totalPages The total number of pages in the book being read.
     * @param name The name of the book being read.
     * @return The method is returning a String message that includes the name of the book being read,
     * the current page number, the total number of pages, and instructions for the user to navigate
     * through the reading session.
     */
    public String lectureSimulatorRegular(int page, int totalPages, String name){

		String msg = "";

        msg +="Sesión de lectura en progreso: \nLeyendo: "+ name + " \nLeyendo página: " + page +  " de " + totalPages;
        msg +="\nDigite A para pasar a la página anterior. \nDigite S para pasar a la página siguiente. \nDigite B para volver a la biblioteca";

		return msg;
    
	}
    
    
}


    

