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
			System.out.println("1. Registrar usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Consultar informacion de un usuario");
			System.out.println("5. Consultar cuantos usuarios hay registrados");
			System.out.println("6. Salir");
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

}