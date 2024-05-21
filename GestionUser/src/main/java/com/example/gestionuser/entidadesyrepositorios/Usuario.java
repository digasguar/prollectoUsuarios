package com.example.gestionuser.entidadesyrepositorios;

import java.time.LocalDateTime;
import java.util.Date;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String codigoPostal;
    private String telefonoMovil;
    private LocalDateTime fechaNacimiento;
    private String password;
    private String password2;
    
    
    public Usuario(String nombre, String apellidos, String dni, String email, String codigoPostal, String telefonoMovil,
			LocalDateTime fechaNacimiento, String password,String password2) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.codigoPostal = codigoPostal;
		this.telefonoMovil = telefonoMovil;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.password2=password2;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


