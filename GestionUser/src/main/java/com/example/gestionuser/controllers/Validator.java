package com.example.gestionuser.controllers;

import java.util.regex.Pattern;

import ch.qos.logback.core.boolex.Matcher;

public class Validator {
	
		static String nombreApellidos = "^[A-Z][a-zA-Z]{4,}$";

		static String regex = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
		
		 static String codPostal = "^(0[1-9]|[1-4][0-9]|5[0-2])[0-9]{3}$";

		
	 	public static boolean isValidName(String name) {
	        return name!=null && name.matches(nombreApellidos);
	    }
	 	
	 	
	 	public static boolean isValidApellidos(String apellidos) {
	        return apellidos != null && apellidos.matches(nombreApellidos);
	    }
	 	
	 	public static boolean isValidContraseña(String contra) {
	 		return contra!=null && contra.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=.{5,20}$).*$");
	 	}
	 		
	    public static boolean isValidDni(String dni) {
	        return dni != null && dni.matches("regex");
	    }

	    public static boolean isValidEmail(String email) {
	        String emailPatron = "^[a-zA-Z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})+$";
	        return email != null && email.matches(emailPatron);
	    }

	    public static boolean isValidCodigoPostal(String codigoPostal) {
	        return codigoPostal != null && codigoPostal.matches(codPostal);
	    }

	    public static boolean isValidTelefono(String telefono) {
	        return telefono != null && telefono.matches("^(0034|\\\\+34|34)?[67]\\\\d{8}$");
	    }
}
