package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

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
			case 0:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

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

		if (rXSystem.registerUser(id, name, nickname, userType, userCategory)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

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

	private void countAllUserInfo() {

		System.out.println("Esta es la informacion de usuarios registrada en el sistema");

		String query = rXSystem.countAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

	private void registerProduct(){

		System.out.println("Digite el id del libro");
		String id = reader.nextLine();

		System.out.println("Digite el nombre del libro");
		String name = reader.nextLine();

		System.out.println("Digite la cantidad de páginas");
		int numOfPages = reader.nextInt();

		System.out.println("Digite la fecha de publicación");
		System.out.println("Digite el día");
		int day = reader.nextInt();

		System.out.println("Digite el mes");
		int month = reader.nextInt();

		System.out.println("Digite el año");
		int year = reader.nextInt();

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

		if (rXSystem.registerProduct(id, name, numOfPages, day, month, year, typeOfProduct, review, genre, price, categoryChoose, subscribeCost, broadCastPeriodicity)){
			System.out.println("El producto ha sido registrado con exito");
		}else{
			System.out.println("Error, no se ha podido registrar el producto");
		}
		
	}

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
			int category = 0;
			double price = 0;
			int option3 = 0;
			String broadCastPeriodicity = "";

			if(rXSystem.getTypeOfProduct(option - 1)){
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
			

			if (rXSystem.editProduct(option - 1, name, url, price, broadCastPeriodicity)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

}