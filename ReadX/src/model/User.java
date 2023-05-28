package model;

import java.util.Calendar;






public abstract class User implements BuyOrSuscribe {

	private String id;
	private String name;
	private String nickname;
	private Calendar signUpDate;

	public User(String id, String name, String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.signUpDate = Calendar.getInstance();
	}

	/**
	 * This function returns the value of the "id" variable as a string.
	 * 
	 * @return The method `getId()` is returning a `String` value. The specific value being returned
	 * depends on the value of the variable `id`.
	 */
	public String getId() {
		return id;
	}

	/**
	 * This function sets the value of the "id" variable in a Java class.
	 * 
	 * @param id The parameter "id" is a String type variable that is being passed as an argument to the
	 * method. The method sets the value of the instance variable "id" to the value of the parameter "id".
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * The function returns the name of an object as a string.
	 * 
	 * @return The method is returning a String value, which is the value of the variable "name".
	 */
	public String getName() {
		return name;
	}

	/**
	 * This function sets the name of an object.
	 * 
	 * @param name The parameter "name" is a String type variable that represents the name of an object or
	 * entity. The method "setName" takes in a String value and sets it as the name of the object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The function returns the nickname.
	 * 
	 * @return The method is returning a String value which represents the nickname.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * This function sets the nickname of an object.
	 * 
	 * @param nickname The parameter "nickname" is a String type variable that represents the new nickname
	 * that we want to set for an object. The "setNickname" method is used to update the value of the
	 * "nickname" instance variable of an object with the new value passed as a parameter.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * This function returns the sign-up date as a Calendar object.
	 * 
	 * @return The method is returning a Calendar object named "signUpDate".
	 */
	public Calendar getSignUpDate() {
		return signUpDate;
	}

	/**
	 * This function sets the sign-up date for a user account using a Calendar object.
	 * 
	 * @param signUpDate a variable of type Calendar that represents the date when a user signed up for a
	 * service or application. The method setSignUpDate() is a setter method that sets the value of the
	 * signUpDate variable to the value passed as a parameter.
	 */
	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}	

	/**
	 * This function returns a string representation of a user object with their id, name, nickname, and
	 * registration date.
	 * 
	 * @return A string representation of a User object, including their id, name, nickname, and
	 * registration date.
	 */
	@Override
	public String toString() {
		return "User: \nId = " + id + "\nName = " + name + "\nNickname = " + nickname;
	}
}
