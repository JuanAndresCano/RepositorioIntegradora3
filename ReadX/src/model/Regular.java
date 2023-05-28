package model;

public class Regular extends User{
    
    private Bill[] bills;
    private Product[] userProducts;
    private Product[][] library;
    
    public Regular(String id, String name, String nickname){
        super(id, name, nickname);
        bills = new Bill[7];
        userProducts = new Product[7];
        library = new Product[5][5];
    }

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

                if (bills[j] != null){

                    bills[j] = new Bill(price, name, TypeOfProduct.BOOK);

                    for (int k = 0; k < userProducts.length; k++){

                        if(userProducts[k] != null){
                            userProducts[k] = tempBook;
                            return true;

                        }

                    }
                    
                }

            }

        }

        return false;
        
    }

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


                if (bills[j] != null){
                    bills[j] = new Bill(subscribeCost, name, TypeOfProduct.MAGAZINE);
                    for (int k = 0; k < userProducts.length; k++){
                        if(userProducts[k] != null){
                            userProducts[k] = tempMagazine;
                            return true;
                        }
                    }
                    
                }

            }

        }

        return false;
    }

    
    public void organizeByDateRegular() {}
    /*  
        Book tempBook1;
        Book tempBook2;
        Magazine tempMagazine1;
        Magazine tempMagazine2;

        for (int i = 0; i < userProducts.length; i++ ){
            for(int j = 0; j < userProducts.length; j++){
                if ((userProducts[j].getPublicationDate()).compareTo(userProducts[i].getPublicationDate()) == -1){

                    if(userProducts[j] instanceof Book){

                        tempBook1 = (Book)userProducts[j];

                    }else{

                        tempMagazine1 = (Magazine)userProducts[j];

                    }

                    if(userProducts[i] instanceof Book){

                        tempBook2 = (Book)userProducts[i];

                    }else{

                        tempMagazine2 = (Magazine)userProducts[i];
                    }

                

                    
                }
            }
        }
        
    }
    */

    public String[][] fillLibraryRegular(){

        String[][] matrix = new String[5][5];
		int cont = 0;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if(cont == userProducts.length){
					break;	
				}else{
					
					matrix[i][j] = userProducts[cont].getId();
						
						
						
				}
					
			}

			cont++;
				
		}
		

		return matrix;
    }

    public String showMatrix() {

		String[][] matrix = fillLibraryRegular();

		String print = "";
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null) {

					print += "_______" + " ";
				} else {
					
					print += matrix[i][j] + " ";
				}

			}
			print += "\n";
		}

		return print;
	}

    public String lectureSimulatorRegular(int page, int totalPages, String name){

		String msg = "";

        msg +="Sesión de lectura en progreso: \nLeyendo: "+ name + " \nLeyendo página: " + page +  " de " + totalPages;
        msg +="\nDigite A para pasar a la página anterior. \nDigite S para pasar a la página siguiente. \nDigite B para volver a la biblioteca";

		return msg;
    
	}
    
    
}


    

