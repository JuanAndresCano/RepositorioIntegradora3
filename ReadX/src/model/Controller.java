package model;

import java.util.IllegalFormatPrecisionException;

public class Controller {

	private User[] users;

	public Controller() {

		users = new User[10];
		testCases();
	}

	public void testCases() {

		
	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.length; i++) {

			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}

		}

		return msg;

	}

	public boolean registerUser(String id, String name, String nickname, int userType, int userCategory) {

		for(int i = 0; i < users.length; i++){

			if(users[i] == null){

				if (userType == 1){

					users[i] = new Regular(id, name, nickname);

					return true;

				}else{

					users[i] = new Premium(id, name, nickname, userCategory);

					return true;
				}
			}
			
		}

		return false;

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
			users[userPosition].setName(name);
			return true;
		}else{

			((Premium)users[userPosition]).setCategory(categoryEnum);
			return true;
		}
	}

	public boolean deleteUser(int userPosition) {
		users[userPosition] = null;
		return true;
	}

	public String getUserInfo(int option) {

		String msg = "";

		if(users[option] != null){
			msg = users[option].toString();

			if (users[option] instanceof Premium){
				msg += "\nCategory = " + ((Premium)users[option]).getCategory();
			}
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

		for(int i = 0; i<users.length; i++){
			if (users[i] != null){
				if(users[i] instanceof Regular){
					regular++;
				}else{
					premium++;
					if((((Premium)users[i]).getCategory()) == Category.SILVER){
						silver++;
					}
					if((((Premium)users[i]).getCategory()) == Category.GOLD){
						gold++;
					}
					if((((Premium)users[i]).getCategory()) == Category.DIAMOND){
						diamond++;
					}
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

		if (users[option] instanceof Regular){
			return true;
		}

		return false;

	}

}
