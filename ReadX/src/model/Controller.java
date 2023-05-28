package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Product> products;

	public Controller() {

		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		testCases();
		
	}

	/**
	 * The function initializes and adds test cases for users and products.
	 */
	public void testCases() {

		users.add(new Regular( "A00", "Carlos" , "Car"));
		users.add(new Premium("A01", "David", "Dave", 1));
		users.add(new Premium("A02", "Miguel", "Valle", 2));
		users.add(new Premium("A03", "Daniela", "Dani", 3));

		products.add(new Book("007", "James Bond", 777, "Well, this history has...", Genre.SCIENCE_FICTION, 70 ));
		products.add(new Magazine("809", "Kfir", 40, MCategory.VARIETIES, 20, "Monthly"));
		products.add(new Book("008", "8cho", 777, "Well, this history has...", Genre.SCIENCE_FICTION, 70 ));
		products.add(new Magazine("546", "Cancerbero", 40, MCategory.SCIENCE, 20, "Monthly"));
		products.add(new Book("009", "La divida comedia", 777, "Well, this history has...", Genre.SCIENCE_FICTION, 70 ));
		products.add(new Magazine("947", "Econo", 40, MCategory.SCIENCE, 20, "Monthly"));
		products.add(new Book("010", "James Rodriguez", 777, "Well, this history has...", Genre.SCIENCE_FICTION, 70 ));
		products.add(new Magazine("947", "Sisas", 40, MCategory.DESIGN, 20, "Monthly"));
		products.add(new Book("011", "La insoportable levedad del ser", 777, "Well, this history has...", Genre.SCIENCE_FICTION, 70 ));
		products.add(new Magazine("875", "Lambo", 40, MCategory.VARIETIES, 20, "Monthly"));
	}

	/**
	 * The function returns a formatted string containing a list of users' IDs and names.
	 * 
	 * @return The method is returning a String that contains a list of users, where each user is
	 * represented by their ID and name. The list is created by iterating over the `users` list and
	 * concatenating the user information to the `msg` variable. The method then returns the `msg`
	 * variable.
	 */
	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {
			
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " --- " + users.get(i).getName();
			
		}

		return msg;

	}

	/**
	 * This function registers a new user with a generated ID, name, nickname, user type, and user
	 * category.
	 * 
	 * @param name The name of the user being registered.
	 * @param nickname The nickname parameter is a String that represents the chosen username or alias of
	 * the user being registered.
	 * @param userType An integer value representing the type of user being registered. A value of 1
	 * indicates a regular user, while any other value indicates a premium user.
	 * @param userCategory The userCategory parameter is an integer that represents the category of a
	 * Premium user. The specific categories and their corresponding integer values would need to be
	 * defined elsewhere in the code.
	 * @return The method is returning a boolean value indicating whether the user was successfully added
	 * to the list of users or not.
	 */
	public boolean registerUser(String name, String nickname, int userType, int userCategory) {

		String id = generateHexId();
		
		
		if (userType == 1){

			Regular newProduct = new Regular(id, name, nickname);
			return users.add(newProduct);
			

		}else{

			Premium newProduct = new Premium(id, name, nickname, userCategory);
			return users.add(newProduct);
		}

	}

	/**
	 * This Java function generates a unique hexadecimal ID by randomly selecting three hexadecimal digits
	 * and checking if it already exists in a list of users.
	 * 
	 * @return The method is returning a String value which is a randomly generated hexadecimal ID that is
	 * not already present in the list of existing user IDs.
	 */
	public String generateHexId(){
		boolean flag = false;
		String idDef = "";
		while(!flag){

			int count = 0;
			Random random = new Random();
			StringBuilder id = new StringBuilder();

			for(int i = 0; i<3; i++){
				int rNum = random.nextInt(16);
				id.append(Integer.toHexString(rNum));
			}

			idDef = id.toString().toUpperCase();

			for (int j = 0; j < users.size(); j++){

				if ((idDef).equals(users.get(j).getId())){
					count++;
				}
				
			}
			
			if (count == 0){
				flag = true;
			}

		}
		return idDef;

	}

	/**
	 * The function edits a user's name and category, with the category being set to SILVER, GOLD, or
	 * DIAMOND based on the input integer value.
	 * 
	 * @param userPosition The position of the user in the list of users that needs to be edited.
	 * @param name A string representing the new name for the user being edited.
	 * @param category An integer representing the category of the user. It can be 0, 1, 2, or 3. 0
	 * represents a regular user, while 1, 2, and 3 represent premium users with different levels of
	 * membership.
	 * @return A boolean value indicating whether the user was successfully edited or not.
	 */
	public boolean editUser(int userPosition, String name, int category) {
		Category categoryEnum = Category.SILVER;

		if(category == 2){
			categoryEnum = Category.GOLD;
		}
		if(category == 3){
			categoryEnum = Category.DIAMOND;
		}

		if (category == 0){
			users.get(userPosition).setName(name);
			return true;
		}else{

			((Premium)users.get(userPosition)).setCategory(categoryEnum);
			return true;
		}
	}

	/**
	 * This Java function deletes a user from a list of users at a specified position and returns a
	 * boolean value indicating whether the deletion was successful.
	 * 
	 * @param userPosition userPosition is an integer parameter that represents the position of the user
	 * to be deleted from a list or array. The method removes the user at the specified position from the
	 * list and returns true if the deletion is successful.
	 * @return A boolean value of true is being returned.
	 */
	public boolean deleteUser(int userPosition) {
		users.remove(userPosition);
		return true;
	}

	/**
	 * The function returns user information and their category if they are a premium user.
	 * 
	 * @param option an integer representing the index of the user in the "users" list whose information
	 * is to be retrieved.
	 * @return A string containing information about a user, including their basic information and, if
	 * they are a Premium user, their category. The specific user whose information is returned is
	 * determined by the "option" parameter passed to the method.
	 */
	public String getUserInfo(int option) {

		String msg = "";


			msg = users.get(option).toString();

			if (users.get(option) instanceof Premium){
				msg += "\nCategory = " + ((Premium)users.get(option)).getCategory();
			}
		

		return msg;
	}

	/**
	 * The function counts the number of users in different categories and returns a message with the
	 * count for each category.
	 * 
	 * @return A String message containing the count of different types of users (regular and premium) and
	 * the count of premium users in each category (silver, gold, and diamond). If there are no users, an
	 * empty string is returned.
	 */
	public String countAllUserInfo() {

		String msg = "";
		int regular = 0;
		int premium = 0;
		int silver = 0;
		int gold = 0;
		int diamond = 0;

		for(int i = 0; i<users.size(); i++){

				if(users.get(i) instanceof Regular){
					regular++;
				}else{
					premium++;
					if((((Premium)users.get(i)).getCategory()) == Category.SILVER){
						silver++;
					}
					if((((Premium)users.get(i)).getCategory()) == Category.GOLD){
						gold++;
					}
					if((((Premium)users.get(i)).getCategory()) == Category.DIAMOND){
						diamond++;
					}
				}
			
		}

		msg = "La cantidad de usuarios regulares: " + regular + "\nLa cantidad de usuarios premium es de " + premium + " en las siguientes categorías: \nPlata: " + silver +"\nOro: " + gold + "\nDiamante: " + diamond;
		if((regular + premium + silver + gold + diamond) == 0){
			msg = "";
		}
		return msg;

	}

	/**
	 * This function checks if a user is of type "Regular" based on the option selected.
	 * 
	 * @param option an integer representing the index of a user in a list of users.
	 * @return The method is returning a boolean value. If the user at the specified index in the "users"
	 * list is an instance of the "Regular" class, the method returns true. Otherwise, it returns false.
	 */
	public boolean getTypeOfUser(int option){

		if (users.get(option) instanceof Regular){
			return true;
		}

		return false;

	}

	/**
	 * This function registers a new product (either a book or a magazine) with various attributes and
	 * adds it to a list of products.
	 * 
	 * @param name The name of the product being registered (either a book or a magazine).
	 * @param numOfPages The number of pages of the product being registered.
	 * @param typeOfProduct an integer representing the type of product being registered (1 for book, 2
	 * for magazine)
	 * @param review A string representing the review of the product.
	 * @param genre an integer representing the genre of the book (1 for science fiction, 2 for fantasy, 3
	 * for historical novel)
	 * @param price The price parameter is a double data type and represents the cost of the product being
	 * registered.
	 * @param categoryChoose an integer representing the category chosen for a magazine (1 for VARIETIES,
	 * 2 for DESIGN, 3 for SCIENCE)
	 * @param subscribeCost The cost of subscribing to the magazine.
	 * @param broadCastPeriodicity The frequency at which the magazine is published or broadcasted, such
	 * as weekly, monthly, or quarterly.
	 * @return The method is returning a boolean value indicating whether the product (either a Book or a
	 * Magazine) was successfully added to the list of products.
	 */
	public boolean registerProduct(String name, int numOfPages, int typeOfProduct, String review, int genre, double price, int categoryChoose, double subscribeCost, String broadCastPeriodicity){

		boolean flag = false;
		String idSup = "";

		while(!flag){
			int count = 0;
			idSup = UUID.randomUUID().toString().toUpperCase();

			idSup = idSup.substring(0, 3);

			for(int i = 0; i < products.size(); i++){
				if (idSup.equals(products.get(i).getId())){
					count++;
				}
			}
			if(count == 0){
				flag = true;
			}
		}
		 

		if (typeOfProduct == 1){
			Genre genreDef = Genre.SCIENCE_FICTION;
			if (genre == 2){
				genreDef = Genre.FANTASY;
			}
			if (genre == 3){
				genreDef = Genre.HISTORICAL_NOVEL;
			}

			Book newBook = new Book(idSup, name, numOfPages, review, genreDef, price);
			return products.add(newBook);

		}else{

			MCategory category = MCategory.VARIETIES;
			if (categoryChoose == 2){
				category = MCategory.DESIGN;
			}
			if (categoryChoose == 3){
				category = MCategory.SCIENCE;
			}

			Magazine newMagazine = new Magazine(idSup, name, numOfPages, category, subscribeCost, broadCastPeriodicity);
			return products.add(newMagazine);
		}
	}

	/**
	 * This function returns a formatted string containing the list of products, including their ID, name,
	 * and type (book or magazine).
	 * 
	 * @return The method `getProductList` returns a `String` containing a list of products, their IDs,
	 * names, and types (either "Book" or "Magazine").
	 */
	public String getProductList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {
			
			msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " --- " + products.get(i).getName();
			
			if (products.get(i) instanceof Book){

				msg += " --- " + "Book";

			}
			if (products.get(i) instanceof Magazine){
				msg += " --- " + "Magazine";
			}
		}

		return msg;

	}

	/**
	 * This function checks if a product at a given option is an instance of a Book and returns a boolean
	 * value accordingly.
	 * 
	 * @param option The index of the product in the "products" list that we want to check the type of.
	 * @return The method is returning a boolean value. It returns true if the product at the specified
	 * option in the products list is an instance of the Book class, and false otherwise.
	 */
	public boolean getTypeOfProduct(int option){

		if (products.get(option) instanceof Book){
			return true;
		}

		return false;

	}

	/**
	 * This function edits a product's name, URL, price, or other attributes based on the type of product
	 * and user-selected options.
	 * 
	 * @param userPosition The index position of the product in the ArrayList that needs to be edited.
	 * @param name The new name of the product that the user wants to edit.
	 * @param url A string representing the URL of a product.
	 * @param price The price of the product that needs to be edited.
	 * @param broadCastPeriodicity The frequency at which a magazine is published or broadcasted, such as
	 * weekly, monthly, or quarterly.
	 * @param typeOfProduct An integer representing the type of product being edited. 1 represents a book
	 * and 2 represents a magazine.
	 * @param option2 This parameter is used to determine which attribute of a Book object needs to be
	 * edited.
	 * @param option3 An integer representing the option selected for editing a product of type Magazine.
	 * @return The method returns a boolean value indicating whether the product was successfully edited
	 * or not.
	 */
	public boolean editProduct(int userPosition, String name, String url, double price, String broadCastPeriodicity, int typeOfProduct, int option2, int option3) {
		if (typeOfProduct == 1){
			if (option2 == 1 ){
				products.get(userPosition).setName(name);
				return true;
			}
			if (option2 == 2 ){
				products.get(userPosition).setUrl(url);
				return true;
			}
			if (option2 == 3 ){
				((Book)products.get(userPosition)).setPrice(price);
				return true;
			}
		}else{
			if (option3 == 1 ){
				products.get(userPosition).setName(name);
				return true;
			}
			if (option3 == 2 ){
				products.get(userPosition).setUrl(url);
				return true;
			}
			if (option3 == 3 ){
				((Magazine)products.get(userPosition)).setSubscribeCost(price);
				return true;
			}
			if (option3 == 4){
				((Magazine)products.get(userPosition)).setBroadCastPeriodicity(broadCastPeriodicity);
				return true;
			}
		}

		return false;

	}

	/**
	 * This Java function deletes a product from a list of products at a specified position and returns a
	 * boolean value indicating whether the deletion was successful.
	 * 
	 * @param productPosition The parameter productPosition is an integer that represents the position of
	 * the product to be deleted from the list of products.
	 * @return A boolean value of true is being returned.
	 */
	public boolean deleteProduct(int productPosition) {
		products.remove(productPosition);
		return true;
	}

	/**
	 * The function returns a string containing a list of books with their IDs and names.
	 * 
	 * @return The method `showBooks()` returns a `String` that contains a numbered list of all the books
	 * in the `products` list.
	 */
	public String showBooks(){

		String msg = "";
		int j = 1;

		for (int i = 0; i<products.size(); i++){
			if (products.get(i) instanceof Book){
				msg += "\n" + j + ". " + products.get(i).getId() + " --- " + products.get(i).getName();
				j++;
			}
		}

		return msg;

	}

	/**
	 * This function buys a book from a specific position in a list of products and updates the user's
	 * information accordingly.
	 * 
	 * @param position The position of the book in the list of products (starting from 1).
	 * @param id The ID of the user who wants to buy a book.
	 * @return The method is returning a message (String) indicating whether the book was bought
	 * successfully or not.
	 */
	public String buyBooks(int position, String id){
		String msg = "";
		int j = 1;
		int userPosition;
		String name = "";
		double price = 0;

		for (int i = 0; i<products.size(); i++){
			if (products.get(i) instanceof Book){
				if(j == position){
					Book tempBook = (Book)products.get(i);
					((Book)products.get(i)).newSell();
					name = ((Book)products.get(i)).getName();
					price = ((Book)products.get(i)).getPrice();
					userPosition = lookUpUserPosition(id);
					
					if (users.get(userPosition).buyABook(name, price, tempBook)){

						msg = "Congrats, the book have been buyed propertly";

					}else{

						msg = "Error, can't buy the book";

					}

				}
				j++;
			}
		}

		return msg;
	}

	/**
	 * This function returns a string containing a list of all magazines in the system.
	 * 
	 * @return The method is returning a String that contains a list of all the magazines in the system,
	 * with their corresponding ID and name. If there are no magazines in the system, the method returns a
	 * message indicating that there are no magazines registered.
	 */
	public String showMagazines(){
		String msg = "";
		int j = 1;

		for (int i = 0; i<products.size(); i++){
			if (products.get(i) instanceof Magazine){
				msg += "\n" + j + ". " + products.get(i).getId() + " --- " + products.get(i).getName();
				j++;
			}
		}

		if (msg.equals("")){
			msg = "No hay revistas registradas en el sistema";
		}

		return msg;
	}

	/**
	 * This Java function subscribes a user to a magazine at a specified position and returns a message
	 * indicating success or failure.
	 * 
	 * @param position The position of the magazine in the products list that the user wants to subscribe
	 * to.
	 * @param id The ID of the user who wants to subscribe to a magazine.
	 * @return The method is returning a message (String) indicating whether the magazine subscription was
	 * completed properly or not.
	 */
	public String subscribeMagazine(int position, String id){

		String msg = "";
		int j = 1;
		String name;
		double subscribeCost;
		int userPosition;

		for (int i = 0; i<products.size(); i++){

			if (products.get(i) instanceof Magazine){

				if(j == position){

					Magazine tempMagazine = (Magazine)products.get(i);
					((Magazine)products.get(i)).newSub();
					name = ((Magazine)products.get(i)).getName();
					subscribeCost = ((Magazine)products.get(i)).getSubscribeCost();
					userPosition = lookUpUserPosition(id);

					if (users.get(userPosition).suscribe(name, subscribeCost, tempMagazine)){

						msg = "Congrats, the magazine subscription have been complete propertly";

					}else{

						msg = "Error, can't complete the sub";

					}

				}

				j++;

			}

		}

		return msg;

	}

	/**
	 * This Java function searches for a user in a list of users by their ID and returns true if found,
	 * false otherwise.
	 * 
	 * @param id The parameter "id" is a String representing the user ID that we want to search for in the
	 * "users" list.
	 * @return The method is returning a boolean value. It returns true if the input id matches the id of
	 * any user in the users list, and false otherwise.
	 */
	public boolean searchUser(String id){
		
		for (int i = 0; i < users.size(); i++){

			if ((users.get(i).getId()).equals(id)){
				return true;
			}

		}

		return false;

	}

	/**
	 * This Java function looks up the position of a user in a list of users based on their ID.
	 * 
	 * @param id The parameter "id" is a String variable that represents the unique identifier of a user.
	 * The method "lookUpUserPosition" takes this parameter as input and returns the position of the user
	 * in the "users" list.
	 * @return The method is returning an integer value which represents the position of a user in the
	 * list of users. If the user with the given ID is found in the list, the method returns the index of
	 * that user in the list. If the user is not found, the method returns -1.
	 */
	public int lookUpUserPosition(String id){
		int position = -1;
		for (int i = 0; i < users.size(); i++){

			if ((users.get(i).getId()).equals(id)){
				return position = i;
			}

		}

		return position;

	}

	/**
	 * The function returns a message containing the library of a user, organized by date and filled with
	 * products, depending on whether the user is a premium or regular user.
	 * 
	 * @param id The ID of the user whose library is being requested.
	 * @return The method is returning a String message that shows the library of a user with the given
	 * id. If the user is a Premium user, the library is organized by date and filled with the Premium
	 * method, and if the user is a Regular user, the library is organized by date and filled with the
	 * Regular method. If the user has not purchased any products, the method returns a message saying so.
	 */
	public String showLibrary(String id){

		String msg = "";
		int userPosition = lookUpUserPosition(id);

		if(users.get(userPosition) instanceof Premium){

			((Premium)users.get(userPosition)).organizeByDatePremium();
			((Premium)users.get(userPosition)).fillLibraryPremium();
			msg = ((Premium)users.get(userPosition)).showMatrix();

		}else{

			((Regular)users.get(userPosition)).organizeByDateRegular();
			((Regular)users.get(userPosition)).fillLibraryRegular();
			msg = ((Regular)users.get(userPosition)).showMatrix();
		}
		if (msg.equals("")){

			msg = "No se ha comprado ningun producto para mostrar";
			
		}
		return msg;
	}

	/**
	 * This function simulates a reading experience for a user, including navigating pages and displaying
	 * messages, and may display advertisements for non-premium users.
	 * 
	 * @param id A String representing the user's ID.
	 * @param bookChoosed The ID of the book chosen by the user.
	 * @param page The current page the user is on in the book.
	 * @param userChoice A string representing the user's choice of action in the lecture simulator. It
	 * can be either "A" to go back one page or "S" to go forward one page.
	 * @param count The count parameter is an integer that represents the number of times the lecture
	 * simulator method has been called.
	 * @return The method is returning a String message.
	 */
	public String lectureSimulator(String id, String bookChoosed, int page, String userChoice, int count){
		String msg = "";
		int totalPages = 1;
		String name = "";
		Random random = new Random();
		int count2;
		for(int j = 0; j < products.size(); j++){

			if((products.get(j).getId()).equals(bookChoosed)){

				products.get(j).newReadedPage();
				totalPages = products.get(j).getNumOfPages();
				name = products.get(j).getName();
			}

		}

		if(userChoice.equals("A")){
			if(page>1){
			}else{
				msg += "No es posible ir una página atrás\n";
			}
		}
		if(userChoice.equals("S")){
			if(page<=totalPages){
				
			}else{
				page--;
				msg += "No es posible ir una página adelante\n";
			}
		}

		for (int i = 0; i < users.size(); i++){

			if((users.get(i).getId()).equals(id)){

				if (users.get(i) instanceof Premium){

					msg += ((Premium)users.get(i)).lectureSimulatorPremium(page, totalPages, name);

				}else{

					msg += ((Regular)users.get(i)).lectureSimulatorRegular(page, totalPages, name);
					

					if ((count%5) == 0){
						count2 = random.nextInt(3);
						if(count2 == 0){
							msg += "\n\n¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!\n\n";
						}
						if(count2 == 1){
							msg += "\n\nAhora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.\n\n";
						}
						if(count2 == 2){
							msg += "\n\n¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.\n\n";
						}
					}

				}
				
			}
		}

		return msg;

	}

	/**
	 * The function calculates the total number of pages read for books and magazines in a list of
	 * products.
	 * 
	 * @return The method is returning a String message that indicates the total number of pages read for
	 * books and magazines in the products list.
	 */
	public String acumReadedPagesPerProduct(){
		String msg = "";
		int bookReadedPages = 0;
		int magazineReadedPages = 0;
		for(int i = 0; i<products.size(); i++){
			if(products.get(i) instanceof Book){
				bookReadedPages += ((Book)products.get(i)).getAcumReadedPages();
			}else{
				magazineReadedPages += ((Magazine)products.get(i)).getAcumReadedPages();
			}
		}
		msg += "En total se han leido " + bookReadedPages + " páginas de libros. Y " + magazineReadedPages + " páginas de revistas";
		return msg;
	}

	/**
	 * This function calculates and returns the most read genre and category of books and magazines
	 * respectively.
	 * 
	 * @return The method is returning a String message that indicates the most read genre and category
	 * among the products (books and magazines) in the store.
	 */
	public String genreAndCategoryMoreReaded(){
		String msg = "";
		int fantasy = 0;
		int historicalNovel = 0;
		int scienceFiction = 0;
		int design = 0;
		int science = 0;
		int varieties = 0;
			for(int i = 0; i < products.size(); i++){
				if (products.get(i) instanceof Book){
					if(((Book)products.get(i)).getGenre() == Genre.FANTASY){
						fantasy += ((Book)products.get(i)).getAcumReadedPages();
					}
					if(((Book)products.get(i)).getGenre() == Genre.HISTORICAL_NOVEL){
						historicalNovel += ((Book)products.get(i)).getAcumReadedPages();
					}else{
						scienceFiction += ((Book)products.get(i)).getAcumReadedPages();
					}
				}else{
					if(((Magazine)products.get(i)).getMCategory() == MCategory.DESIGN){
						design += ((Magazine)products.get(i)).getAcumReadedPages();
					}
					if(((Magazine)products.get(i)).getMCategory() == MCategory.SCIENCE){
						science += ((Magazine)products.get(i)).getAcumReadedPages();
					}else{
						varieties += ((Magazine)products.get(i)).getAcumReadedPages();
					}
				}
			}
			
			if((fantasy > historicalNovel) && (fantasy > scienceFiction)){
				msg += "En los libros, el género más leído fue fantasía, con " + fantasy + " páginas leídas";
			}
			if((historicalNovel > fantasy) && (historicalNovel > scienceFiction)){
				msg += "En los libros, el género más leído fue novela historica, con " + historicalNovel + " páginas leídas";
			}
			if((scienceFiction > historicalNovel) && (fantasy < scienceFiction)){
				msg += "En los libros, el género más leído fue sciencia ficción, con " + scienceFiction + " páginas leídas";
			}
			if((design > science) && (design > varieties)){
				msg += "En las revistas, la categoría más leída fue diseño, con " + design + " páginas leídas";
			}
			if((design < science) && (science > varieties)){
				msg += "En las revistas, la categoría más leída fue ciencia, con " + science + " páginas leídas";
			}
			if((varieties > science) && (design < varieties)){
				msg += "En las revistas, la categoría más leída fue variedades, con " + varieties + " páginas leídas";
			}

		return msg;
	}

	/**
	 * The function returns the top 5 books and magazines based on the number of pages read.
	 * 
	 * @return A String message containing the top 5 books and top 5 magazines based on the accumulated
	 * number of pages read.
	 */
	public String top5(){
		String msg = "";
		
		Book top1 = (Book)products.get(0);
		Book top2 = (Book)products.get(2);
		Book top3 = (Book)products.get(4);
		Book top4 = (Book)products.get(6);
		Book top5 = (Book)products.get(8);

		Magazine top1M = (Magazine)products.get(1);
		Magazine top2M = (Magazine)products.get(3);
		Magazine top3M = (Magazine)products.get(5);
		Magazine top4M = (Magazine)products.get(7);
		Magazine top5M = (Magazine)products.get(9);
		
		for(int i = 0; i < products.size(); i++){
			if (products.get(i) instanceof Book){
				if (top1.getAcumReadedPages()<((Book)products.get(i)).getAcumReadedPages()){
					top5 = top4;
					top4 = top3;
					top3 = top2;
					top2 = top1;
					top1 = ((Book)products.get(i));
				}

				if((top1.getAcumReadedPages()>((Book)products.get(i)).getAcumReadedPages())&&(top2.getAcumReadedPages()<((Book)products.get(i)).getAcumReadedPages())){
					top5 = top4;
					top4 = top3;
					top3 = top2;
					top2 = ((Book)products.get(i));
				}

				if((top2.getAcumReadedPages()>((Book)products.get(i)).getAcumReadedPages())&&((top3.getAcumReadedPages()<((Book)products.get(i)).getAcumReadedPages()))){
					top5 = top4;
					top4 = top3;
					top3 = ((Book)products.get(i));
				}
				if((top3.getAcumReadedPages()>((Book)products.get(i)).getAcumReadedPages())&&(top4.getAcumReadedPages()<((Book)products.get(i)).getAcumReadedPages())){
					top5 = top4;
					top4 = ((Book)products.get(i));
				}
				if((top4.getAcumReadedPages()>((Book)products.get(i)).getAcumReadedPages())&&(top5.getAcumReadedPages()<((Book)products.get(i)).getAcumReadedPages())){
					top5 = ((Book)products.get(i));
				}
			}else{

			
				if (top1M.getAcumReadedPages()<((Magazine)products.get(i)).getAcumReadedPages()){
					top5M = top4M;
					top4M = top3M;
					top3M = top2M;
					top2M = top1M;
					top1M = ((Magazine)products.get(i));
				}

				if((top1M.getAcumReadedPages()>((Magazine)products.get(i)).getAcumReadedPages())&&(top2M.getAcumReadedPages()<((Magazine)products.get(i)).getAcumReadedPages())){
					top5M = top4M;
					top4M = top3M;
					top3M = top2M;
					top2M = ((Magazine)products.get(i));
				}

				if((top2M.getAcumReadedPages()>((Magazine)products.get(i)).getAcumReadedPages())&&((top3M.getAcumReadedPages()<((Magazine)products.get(i)).getAcumReadedPages()))){
					top5M = top4M;
					top4M = top3M;
					top3M = ((Magazine)products.get(i));
				}
				if((top3M.getAcumReadedPages()>((Magazine)products.get(i)).getAcumReadedPages())&&(top4M.getAcumReadedPages()<((Magazine)products.get(i)).getAcumReadedPages())){
					top5M = top4M;
					top4M = ((Magazine)products.get(i));
				}
				if((top4M.getAcumReadedPages()>((Magazine)products.get(i)).getAcumReadedPages())&&(top5M.getAcumReadedPages()<((Magazine)products.get(i)).getAcumReadedPages())){
					top5M = ((Magazine)products.get(i));
				}
			}
		}
		msg += "\nBook top 1: \nNombre: " + top1.getName() +" \nGénero: " + top1.getGenre() + "\nPáginas leídas: " + top1.getAcumReadedPages();
		msg += "\nBook top 2: \nNombre: " + top2.getName() +" \nGénero: " + top2.getGenre() + "\nPáginas leídas: " + top2.getAcumReadedPages();
		msg += "\nBook top 3: \nNombre: " + top3.getName() +" \nGénero: " + top3.getGenre() + "\nPáginas leídas: " + top3.getAcumReadedPages();
		msg += "\nBook top 4: \nNombre: " + top4.getName() +" \nGénero: " + top4.getGenre() + "\nPáginas leídas: " + top4.getAcumReadedPages();
		msg += "\nBook top 5: \nNombre: " + top5.getName() +" \nGénero: " + top5.getGenre() + "\nPáginas leídas: " + top5.getAcumReadedPages();

		msg += "\nMagazine top 1: \nNombre: " + top1M.getName() +" \nCategoría: " + top1M.getMCategory() + "\nPáginas leídas: " + top1M.getAcumReadedPages();
		msg += "\nMagazine top 2: \nNombre: " + top2M.getName() +" \nCategoría: " + top2M.getMCategory() + "\nPáginas leídas: " + top2M.getAcumReadedPages();
		msg += "\nMagazine top 3: \nNombre: " + top3M.getName() +" \nCategoría: " + top3M.getMCategory() + "\nPáginas leídas: " + top3M.getAcumReadedPages();
		msg += "\nMagazine top 4: \nNombre: " + top4M.getName() +" \nCategoría: " + top4M.getMCategory() + "\nPáginas leídas: " + top4M.getAcumReadedPages();
		msg += "\nMagazine top 5: \nNombre: " + top5M.getName() +" \nCategoría: " + top5M.getMCategory() + "\nPáginas leídas: " + top5M.getAcumReadedPages();

		return msg;
	}

	/**
	 * The function generates a resume of the sales and total value of books sold by genre.
	 * 
	 * @return The method is returning a String message that contains information about the sales of books
	 * in different genres, including the number of units sold and the total value of sales for each
	 * genre.
	 */
	public String genreResume(){
		String msg = "";

		int selledFantasy = 0;
		double fantasyValue = 0;

		int selledScienceFiction = 0;
		double scienceFictionValue = 0;

		int selledHistoricalNovel = 0;
		double historicalNovelValue = 0;

		for (int i = 0; i < products.size(); i++){
			if(products.get(i) instanceof Book){

				if (((Book)products.get(i)).getGenre() == Genre.FANTASY){
					selledFantasy += ((Book)products.get(i)).getAmountOfSells();
					fantasyValue += ((Book)products.get(i)).getAmountOfSells() * ((Book)products.get(i)).getPrice();
				}

				if (((Book)products.get(i)).getGenre() == Genre.SCIENCE_FICTION){
					selledScienceFiction += ((Book)products.get(i)).getAmountOfSells();
					scienceFictionValue += ((Book)products.get(i)).getAmountOfSells() * ((Book)products.get(i)).getPrice();
				}

				if (((Book)products.get(i)).getGenre() == Genre.HISTORICAL_NOVEL){
					selledHistoricalNovel += ((Book)products.get(i)).getAmountOfSells();
					historicalNovelValue += ((Book)products.get(i)).getAmountOfSells() * ((Book)products.get(i)).getPrice();
				}

			}
		}

		msg += "\n\nLibros:\n \nGénero: Fantasía. \nUnidades vendidas: " + selledFantasy +". \nValor total de ventas: " + fantasyValue;
		msg += "\n\nLibros:\n \nGénero: Ciencia Ficción. \nUnidades vendidas: " + selledScienceFiction +". \nValor total de ventas: " + scienceFictionValue;
		msg += "\n\nLibros:\n \nGénero: Novela Historica. \nUnidades vendidas: " + selledHistoricalNovel +". \nValor total de ventas: " + historicalNovelValue;

		return msg;
	}

	/**
	 * The function calculates and returns the number of active subscriptions and the value of
	 * subscriptions sold for each category of magazine.
	 * 
	 * @return The method `categoryResume()` returns a `String` message containing information about the
	 * number of active subscriptions and the value collected from subscriptions for each category of
	 * magazines (varieties, science, and design).
	 */
	public String categoryResume(){

		String msg = "";

		int selledVarieties = 0;
		double varietiesValue = 0;

		int selledScience = 0;
		double scienceValue = 0;

		int selledDesign = 0;
		double designValue = 0;

		for (int i = 0; i < products.size(); i++){

			if(products.get(i) instanceof Magazine){

				if (((Magazine)products.get(i)).getMCategory() == MCategory.VARIETIES){

					selledVarieties += ((Magazine)products.get(i)).getActiveSubs();
					varietiesValue += ((Magazine)products.get(i)).getActiveSubs() * ((Magazine)products.get(i)).getSubscribeCost();

				}

				if (((Magazine)products.get(i)).getMCategory() == MCategory.SCIENCE){

					selledScience += ((Magazine)products.get(i)).getActiveSubs();
					scienceValue += ((Magazine)products.get(i)).getActiveSubs() * ((Magazine)products.get(i)).getSubscribeCost();

				}

				if (((Magazine)products.get(i)).getMCategory() == MCategory.DESIGN){

					selledDesign += ((Magazine)products.get(i)).getActiveSubs();
					designValue += ((Magazine)products.get(i)).getActiveSubs() * ((Magazine)products.get(i)).getSubscribeCost();

				}
			}
		}

		msg += "\n\nRevistas:\n \nCategoría: Variedades. \nSuscripciones Activas: " + selledVarieties +". \nValor recaudado en suscripciones: " + varietiesValue;
		msg += "\n\nRevistas:\n \nCategoría: Ciencia. \nSuscripciones Activas: " + selledScience +". \nValor recaudado en suscripciones: " + scienceValue;
		msg += "\n\nRevistas:\n \nCategoría: Diseño. \nSuscripciones Activas: " + selledDesign +". \nValor recaudado en suscripciones: " + designValue;

		return msg;
	}

}
