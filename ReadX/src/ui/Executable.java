package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	// The above code is defining a constructor for a class called "Executable". Within the constructor,
	// it initializes a Scanner object to read input from the console and creates a new instance of a
	// Controller class called "rXSystem".
	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	/**
	 * The main function creates an instance of the Executable class and calls its menu method.
	 */
	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	/**
	 * This function displays a menu with various options for the user to choose from and executes the
	 * corresponding actions based on the user's input.
	 */
	private void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("0. Salir");
			System.out.println("1. Registrar usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Consultar informacion de un usuario");
			System.out.println("5. Consultar cuantos usuarios hay registrados");
			System.out.println("6. Registrar productos bibliograficos");
			System.out.println("7. Modificar productos bibliograficos");
			System.out.println("8. Eliminar productos bibliograficos");
			System.out.println("9. Ver catalogo de productos");
			System.out.println("10. Ver la librería");
			System.out.println("11. Generar reporte de productos registrados");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				modifyUser();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				showUserInfo();
				break;
			case 5:
				countAllUserInfo();
				break;
			case 6:
				registerProduct();
				break;
			case 7:
				modifyProduct();
				break;
			case 8:
				deleteProduct();
				break;
			case 9:
				buyOrSubscribe();
				break;
			case 10:
				displayLibrary();
				break;
			case 11:
				generateReport();
				break;
			case 0:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	/**
	 * This function registers a new user by prompting the user to input their name, nickname, user type,
	 * and user category (if applicable), and then calls a method to register the user in a system.
	 */
	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();
		boolean flag = false;
		int userType = 0;
		int userCategory = 0;
		boolean flag2 = false;
		
		while(!flag){

			System.out.println("Digite el tipo de usuario");
			System.out.println("1. Regular");
			System.out.println("2. Premium");

			userType = reader.nextInt();

			if ((userType == 1) || (userType == 2)){

				flag = true;

				if(userType == 2){

					while(!flag2){
						
						System.out.println("Digite la categoria en la que desea registrarse");
						System.out.println("1. Plata");
						System.out.println("2. Oro");
						System.out.println("3. Diamante");
						userCategory = reader.nextInt();

						if (((userCategory == 1) || (userCategory == 2)) || (userCategory == 3)){
							flag2 = true;
						}
					}
				}
			}
		}

		if (rXSystem.registerUser(name, nickname, userType, userCategory)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

	/**
	 * This function allows the modification of user information in a system, including their name and
	 * category.
	 */
	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a editar");

			int option = reader.nextInt();

			String name = "";

			int category = 0;

			int option2 = 0;

			if(rXSystem.getTypeOfUser(option - 1)){
				System.out.println("Digite el nuevo nombre");
				name = reader.nextLine();

			}else{
				System.out.println("¿Qué datos desea modificar?");
				System.out.println("1. Nombre \n2. Categoría");
				option2 = reader.nextInt();
				if(option2 == 1){
					System.out.println("Digite el nuevo nombre");
					name = reader.nextLine();
				}else{
					System.out.println("Digite la nueva categoría");
					System.out.println("1. Plata \n2. Oro \n3. Diamante");
					category = reader.nextInt();
				}
			}
			

			if (rXSystem.editUser(option - 1, name, category)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

	/**
	 * This function deletes a user from the system after displaying a list of registered users and
	 * prompting the user to select the user to be deleted.
	 */
	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a borrar");

			int option = reader.nextInt();

			if (rXSystem.deleteUser(option - 1)) {

				System.out.println("\nUsuario borrado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser borrado");
			}

		}

	}

	/**
	 * This function displays a list of registered users in the system and allows the user to select a
	 * user to view their information.
	 */
	private void showUserInfo() {
		

		reader.nextLine();

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a consultar");

			int option = reader.nextInt();

			String query2 = rXSystem.getUserInfo(option - 1);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

	/**
	 * This function prints the count of all user information in the system.
	 */
	private void countAllUserInfo() {

		System.out.println("Esta es la informacion de usuarios registrada en el sistema");

		String query = rXSystem.countAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

	/**
	 * This function registers a product by prompting the user for information such as name, type, genre,
	 * price, and category, and then calls a method to register the product in the system.
	 */
	private void registerProduct(){

		System.out.println("Digite el nombre del libro");
		String name = reader.nextLine();

		System.out.println("Digite la cantidad de páginas");
		int numOfPages = reader.nextInt();
		int typeOfProduct = 0;

		while((typeOfProduct != 1) || (typeOfProduct != 2)){
		 	System.out.println("¿Qué clase de producto se va a registrar? \n1. Libro. \n2. Revista");
			typeOfProduct = reader.nextInt();
		}
		String review = "";
		int genre = 0;
		double price = 0;

		int categoryChoose = 0;
		double subscribeCost = 0;
		String broadCastPeriodicity = "";

		if (typeOfProduct == 1){
			System.out.println("Digite el resumen del libro");
			review = reader.nextLine();

			while(((genre != 1) || (genre != 2)) || (genre != 3)){
				System.out.println("Digite el género del libro: \n1. SCIENCE_FICTION. \n2. FANTASY. \n3. HISTORICAL_NOVEL");
				genre = reader.nextInt();
			}

			System.out.println("Digite el precio que tendrá el libro");
			price = reader.nextDouble();
		
		}else{

			while (((categoryChoose != 1) || (categoryChoose != 2)) || (categoryChoose != 3)){
				System.out.println("Digite la categpría de la revista: \n1. VARIETIES. \n2. DESIGN \n3. SCIENCE");
				categoryChoose = reader.nextInt();
			}

			System.out.println("Digite el costo que tendrá la suscripción");
			subscribeCost = reader.nextDouble();

			System.out.println("Digite la periodicidad de las publicaciones");
			broadCastPeriodicity = reader.nextLine();


		}

		if (rXSystem.registerProduct(name, numOfPages, typeOfProduct, review, genre, price, categoryChoose, subscribeCost, broadCastPeriodicity)){
			System.out.println("El producto ha sido registrado con exito");
		}else{
			System.out.println("Error, no se ha podido registrar el producto");
		}
		
	}

	/**
	 * This function allows the user to modify a product in the system by selecting the product and
	 * choosing which data to modify.
	 */
	private void modifyProduct() {

		String query = rXSystem.getProductList();

		if (query.equals("")) {

			System.out.println("No hay productos registrados");

		} else {

			System.out.println("\nEste es el listado de productos registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el producto a editar");

			int option = reader.nextInt();
			int option2 = 0;
			String name = "";
			String url = "";
			double price = 0;
			int option3 = 0;
			String broadCastPeriodicity = "";
			int typeOfProduct = 0;

			if(rXSystem.getTypeOfProduct(option - 1)){
				typeOfProduct = 1;
				System.out.println("¿Qué datos desea modificar?");
				System.out.println("1. Nombre \n2. Url \n3. Precio");
				option2 = reader.nextInt();

				if (option2 == 1){
					System.out.println("Digite el nuevo nombre");
					name = reader.nextLine();
				}

				if (option2 == 2){
					System.out.println("Digite el nuevo url");
					url = reader.nextLine();
				}

				if (option2 == 3){
					System.out.println("Digite el nuevo precio");
					price = reader.nextDouble();
				}

			}else{

				System.out.println("¿Qué datos desea modificar?");
				System.out.println("1. Nombre \n2. Url \n3. Precio de la subscripcion \n4. Periodicidad de emision");

				option3 = reader.nextInt();

				if(option3 == 1){
					System.out.println("Digite el nuevo nombre");
					name = reader.nextLine();
				}

				if(option3 == 2){
					System.out.println("Digite la nueva url");
					url = reader.nextLine();
				}

				if(option3 == 3){
					System.out.println("Digite el nuevo precio de la subscripcion");
					price = reader.nextDouble();
				}

				if(option3 == 4){
					System.out.println("Digite la nueva periodicidad de emision");
					broadCastPeriodicity = reader.nextLine();
				}
			}
			

			if (rXSystem.editProduct(option - 1, name, url, price, broadCastPeriodicity, typeOfProduct, option2, option3)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

	/**
	 * This function deletes a product from a list of registered products in a system.
	 */
	private void deleteProduct() {

		String query = rXSystem.getProductList();

		if (query.equals("")) {

			System.out.println("No hay productos registrados");

		} else {

			System.out.println("\nEste es el listado de productos registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el producto a borrar");

			int option = reader.nextInt();

			if (rXSystem.deleteProduct(option - 1)) {

				System.out.println("\nProducto borrado exitosamente");

			} else {

				System.out.println("\nError, el producto no pudo ser borrado");
			}

		}

	}

	/**
	 * This function allows a user to buy a book or subscribe to a magazine from a catalog, after
	 * verifying their ID and checking if they are registered.
	 */
	public void buyOrSubscribe(){

		reader.nextLine();

		System.out.println("Usuario, por favor digite su ID");
		String id = reader.nextLine();
		if (!rXSystem.searchUser(id)){
			System.out.println("Error, el usuario no está registrado, por favor registrarse y volver a intentar");
			return;
		}
			
		
		System.out.println("¿Qué catalogo desea ver? \n1. Libros. \n2. Revistas");
		int choose = reader.nextInt();
		String query = "";
		int position = -10;

		if (choose == 1){
			query = rXSystem.showBooks();
			System.out.println(query);
			System.out.println("Digite el libro a comprar. (número)");
			position = reader.nextInt();

			System.out.println(rXSystem.buyBooks(position, id));

		}
		if(choose == 2){
			query = rXSystem.showMagazines();
			System.out.println(query);
			System.out.println("Digite la revista a la cual suscribirse.");
			position = reader.nextInt();

			System.out.println(rXSystem.subscribeMagazine(position, id));
		}
	}

	/**
	 * This function displays the library of a registered user and allows them to choose a book to read
	 * with a simulated reading experience.
	 */
	public void displayLibrary(){
		boolean flag = false;
		boolean flag2 = false;
		reader.nextLine();

		System.out.println("Usuario, por favor digite su ID");
		String id = reader.nextLine();

		if (!rXSystem.searchUser(id)){
			System.out.println("Error, el usuario no está registrado, por favor registrarse y volver a intentar");
			return;
		}

		while(!flag){
			int count = 0;
			int page = 1;
			flag2 = false;	
			System.out.println(rXSystem.showLibrary(id));
			System.out.println("Ahora digite el código del producto que desee leer o digite F para salir");
			String bookChoosed = reader.nextLine();
			String userChoice = "";
			if (bookChoosed.equals("F")){
				return;
			}
			while(!flag2){

				System.out.println(rXSystem.lectureSimulator(id, bookChoosed, page, userChoice, count));
				userChoice = reader.nextLine();
				if(userChoice.equals("A")){
					count++;
					if(!(page<=1)){
						page--;
					}
				}
				if(userChoice.equals("S")){
					page++;
					count++;
				}
				if(userChoice.equals("B")){
					flag2 = true;
				}
				
			}
			
		}
		

	}

	/**
	 * The function generates a report by printing out various statistics related to reading habits in the
	 * rXSystem.
	 */
	public void generateReport(){
		System.out.println(rXSystem.acumReadedPagesPerProduct());
		System.out.println(rXSystem.genreAndCategoryMoreReaded());
		System.out.println(rXSystem.top5());
		System.out.println(rXSystem.genreResume());
		System.out.println(rXSystem.categoryResume());
	}

	

}