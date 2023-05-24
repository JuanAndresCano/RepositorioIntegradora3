package model;

import java.util.IllegalFormatPrecisionException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Product> products;

	public Controller() {

		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		testCases();
		
	}

	public void testCases() {

		
	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {
			
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " --- " + users.get(i).getName();
			
		}

		return msg;

	}

	public boolean registerUser(String id, String name, String nickname, int userType, int userCategory) {

		if (userType == 1){

			Regular newProduct = new Regular(id, name, nickname);
			return users.add(newProduct);
			

		}else{

			Premium newProduct = new Premium(id, name, nickname, userCategory);
			return users.add(newProduct);
		}

	}

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

	public boolean deleteUser(int userPosition) {
		users.remove(userPosition);
		return true;
	}

	public String getUserInfo(int option) {

		String msg = "";


			msg = users.get(option).toString();

			if (users.get(option) instanceof Premium){
				msg += "\nCategory = " + ((Premium)users.get(option)).getCategory();
			}
		

		return msg;
	}

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

	public boolean getTypeOfUser(int option){

		if (users.get(option) instanceof Regular){
			return true;
		}

		return false;

	}

	public boolean registerProduct(String id, String name, int numOfPages, int day, int month, int year, int typeOfProduct, String review, int genre, double price, int categoryChoose, double subscribeCost, String broadCastPeriodicity){

		Calendar newPublicationDate = new GregorianCalendar(year, month-1, day);

		if (typeOfProduct == 1){
			Genre genreDef = Genre.SCIENCE_FICTION;
			if (genre == 2){
				genreDef = Genre.FANTASY;
			}
			if (genre == 3){
				genreDef = Genre.HISTORICAL_NOVEL;
			}

			Book newBook = new Book(id, name, numOfPages, newPublicationDate, review, genreDef, price);
			return products.add(newBook);

		}else{

			MCategory category = MCategory.VARIETIES;
			if (categoryChoose == 2){
				category = MCategory.DESIGN;
			}
			if (categoryChoose == 3){
				category = MCategory.SCIENCE;
			}

			Magazine newMagazine = new Magazine(id, name, numOfPages, newPublicationDate, category, subscribeCost, broadCastPeriodicity);
			return products.add(newMagazine);
		}
	}

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

	public boolean getTypeOfProduct(int option){

		if (products.get(option) instanceof Book){
			return true;
		}

		return false;

	}

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
				products.get(userPosition).setName(name);
				return true;
			}
			if (option3 == 3 ){
				((Magazine)products.get(userPosition)).setSubscribeCost(price);
			}
			if (option3 == 4){
				((Magazine)products.get(userPosition)).setBroadCastPeriodicity(broadCastPeriodicity);
				return true;
			}
		}

		return false;

	}

	public boolean deleteProduct(int productPosition) {
		products.remove(productPosition);
		return true;
	}

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

	public String buyBooks(int position){
		String msg = "";
		int j = 1;

		for (int i = 0; i<products.size(); i++){
			if (products.get(i) instanceof Book){
				if(j == position){
					((Book)products.get(i)).newSell();
					
				}
				j++;
			}
		}

		return msg;
	}
}
