package model;

import java.util.ArrayList;
import java.util.Random;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Product> products;

	public Controller() {

		users = new ArrayList<User>();
		products = new ArrayList<Product>();
		testCases();
		
	}

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

	public boolean registerProduct(String id, String name, int numOfPages, int typeOfProduct, String review, int genre, double price, int categoryChoose, double subscribeCost, String broadCastPeriodicity){


		if (typeOfProduct == 1){
			Genre genreDef = Genre.SCIENCE_FICTION;
			if (genre == 2){
				genreDef = Genre.FANTASY;
			}
			if (genre == 3){
				genreDef = Genre.HISTORICAL_NOVEL;
			}

			Book newBook = new Book(id, name, numOfPages, review, genreDef, price);
			return products.add(newBook);

		}else{

			MCategory category = MCategory.VARIETIES;
			if (categoryChoose == 2){
				category = MCategory.DESIGN;
			}
			if (categoryChoose == 3){
				category = MCategory.SCIENCE;
			}

			Magazine newMagazine = new Magazine(id, name, numOfPages, category, subscribeCost, broadCastPeriodicity);
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

	public boolean searchUser(String id){
		
		for (int i = 0; i < users.size(); i++){

			if ((users.get(i).getId()).equals(id)){
				return true;
			}

		}

		return false;

	}

	public int lookUpUserPosition(String id){
		int position = -1;
		for (int i = 0; i < users.size(); i++){

			if ((users.get(i).getId()).equals(id)){
				return position = i;
			}

		}

		return position;

	}

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
				page--;
			}else{
				msg += "No es posible ir una página atrás\n";
			}
		}
		if(userChoice.equals("S")){
			if(page<totalPages){
				page++;
			}else{
				msg += "No es posible ir una página adelante\n";
			}
		}

		for (int i = 0; i < users.size(); i++){

			if((users.get(i).getId()).equals(id)){

				if (users.get(i) instanceof Premium){

					msg += ((Premium)users.get(i)).lectureSimulatorPremium(page, totalPages, name);

				}else{

					msg += ((Regular)users.get(i)).lectureSimulatorRegular(page, totalPages, name);
					count++;

					if ((count%5) == 0){
						count2 = random.nextInt(3);
						if(count2 == 0){
							msg += "¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
						}
						if(count2 == 1){
							msg += "Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.";
						}
						if(count2 == 2){
							msg += "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.";
						}
					}

				}
				
			}
		}

		return msg;

	}

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
		msg += "\nBook top 1: \nNombre: " + top1.getName() +" \nGénero: " + top1.getGenre() + "\nPáginas leídas" + top1.getAcumReadedPages();
		msg += "\nBook top 2: \nNombre: " + top2.getName() +" \nGénero: " + top2.getGenre() + "\nPáginas leídas" + top2.getAcumReadedPages();
		msg += "\nBook top 3: \nNombre: " + top3.getName() +" \nGénero: " + top3.getGenre() + "\nPáginas leídas" + top3.getAcumReadedPages();
		msg += "\nBook top 4: \nNombre: " + top4.getName() +" \nGénero: " + top4.getGenre() + "\nPáginas leídas" + top4.getAcumReadedPages();
		msg += "\nBook top 5: \nNombre: " + top5.getName() +" \nGénero: " + top5.getGenre() + "\nPáginas leídas" + top5.getAcumReadedPages();

		msg += "\nMagazine top 1: \nNombre: " + top1M.getName() +" \nCategoría: " + top1M.getMCategory() + "\nPáginas leídas" + top1M.getAcumReadedPages();
		msg += "\nMagazine top 2: \nNombre: " + top2M.getName() +" \nCategoría: " + top2M.getMCategory() + "\nPáginas leídas" + top2M.getAcumReadedPages();
		msg += "\nMagazine top 3: \nNombre: " + top3M.getName() +" \nCategoría: " + top3M.getMCategory() + "\nPáginas leídas" + top3M.getAcumReadedPages();
		msg += "\nMagazine top 4: \nNombre: " + top4M.getName() +" \nCategoría: " + top4M.getMCategory() + "\nPáginas leídas" + top4M.getAcumReadedPages();
		msg += "\nMagazine top 5: \nNombre: " + top5M.getName() +" \nCategoría: " + top5M.getMCategory() + "\nPáginas leídas" + top5M.getAcumReadedPages();

		return msg;
	}

}
