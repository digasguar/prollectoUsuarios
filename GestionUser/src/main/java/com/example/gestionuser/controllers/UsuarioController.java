package com.example.gestionuser.controllers;

import com.example.gestionuser.GestionUserApplication;
import com.example.gestionuser.entidadesyrepositorios.Usuario;
import com.example.gestionuser.entidadesyrepositorios.UsuarioRepository;
import com.example.gestionuser.exceptions.NotFoundException;
import com.example.gestionuser.exceptions.NotValidException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class UsuarioController {
	

    @Autowired
    private UsuarioRepository usuariosRepository;
    
    @GetMapping("/user-form")
	public String tareaFormActionView() {
		return "test";
	}

    @PostMapping(value = "/usuario-add")
    public String postAddAction(@RequestParam Map<String, String> params) {
    	
    	String nombre = params.get("user");
        String apellidos = params.get("apellidos");
        String dni = params.get("dni");
        String email = params.get("email");
        String codigoPostal = params.get("codigoPostal");
        String telefono = params.get("telefono");
        String dateValue = params.get("date");
        String password = params.get("contraseña");
        String password2 = params.get("contraseña2");
        
        
        
        if (!Validator.isValidName(nombre) || !Validator.isValidName(apellidos)) {
            throw new NotValidException("No válido: el nombre o los apellidos no cumplen con los requisitos.");
        }
        
        if (!Validator.isValidApellidos(apellidos) || !Validator.isValidName(apellidos)) {
            throw new NotValidException("No válido: el nombre o los apellidos no cumplen con los requisitos.");
        }

        if (!Validator.isValidDni(dni)) {
            throw new NotValidException("No válido: el DNI no cumple con los requisitos.");
        }

        if (!Validator.isValidEmail(email)) {
            throw new NotValidException("No válido: el email no cumple con los requisitos.");
        }

        if (!Validator.isValidCodigoPostal(codigoPostal)) {
            throw new NotValidException("No válido: el código postal no cumple con los requisitos.");
        }

        if (!Validator.isValidTelefono(telefono)) {
            throw new NotValidException("No válido: el teléfono no cumple con los requisitos.");
        }
        if (!Validator.isValidContraseña(password)) {
            throw new NotValidException("No válido: el teléfono no cumple con los requisitos.");
        }
		
        
        LocalDateTime dateExpiration;
        try {
            LocalDate parsedDate = LocalDate.parse(dateValue);
            dateExpiration = parsedDate.atTime(12, 0);
        } catch (DateTimeParseException e) {
            throw new NotValidException("No válido: el formato de la fecha no es correcto.");
        }

        if (password == null || password2 == null || !password.equals(password2)) {
            throw new NotValidException("No válido: las contraseñas no coinciden o están vacías.");
        }

        Usuario usuario = new Usuario(nombre, apellidos, dni, email, codigoPostal, telefono, dateExpiration, password, password2);
        usuariosRepository.addUsuario(usuario);

        return "redirect:/user-form";
        
        
    }
    
   

    
    @GetMapping("/usuario-list")
    public String listUsuarios(@RequestParam(required = false)String name,@RequestParam(required = false)String email,Model model) {
    	
    	if((name==null || name.isEmpty()) && (email==null || email.isEmpty())) {
    		ArrayList<Usuario> usuarios = usuariosRepository.getUsuarios();
            model.addAttribute("nombre", "");
    		model.addAttribute("listaUsers", usuariosRepository.findAll());
    	}else {
    		model.addAttribute("nombre", name);
    		model.addAttribute("email", email);
    		model.addAttribute("listaUsers", usuariosRepository.findAll(name,email));
    	}
        return "listaUsers";
    }
    
    @GetMapping("/usuario-find")
	public String getFindAction(@RequestParam String nombre, Model model) {
		
    	if((nombre==null || nombre.isEmpty())) {
    		ArrayList<Usuario> usuarios = usuariosRepository.getUsuarios();
            model.addAttribute("nombre", "");
    		model.addAttribute("listaUsers", usuariosRepository.findAll());
    	}else {
    		model.addAttribute("nombre", nombre);
    		model.addAttribute("listaUsers", usuariosRepository.findAll(nombre));
    	}
        return "listaUsers";

	}

	@GetMapping("/usuario-delete")
	@ResponseBody
	public String deleteAction(@RequestParam String name) {
		
		StringBuilder responseHtml = new StringBuilder();
		responseHtml.append("<html><body><font style='color:red'>");
		try {
			Usuario usuario = usuariosRepository.getUsuarioByName(name);
			usuariosRepository.delete(usuario);

			responseHtml.append("Usuario ").append(name).append(" borrada con éxito</font>");
			responseHtml.append("<br>" + name);
		} catch (NotFoundException e) {
			responseHtml.append("Tarea ").append(name).append(" no encontrada</font>");
		}
		responseHtml.append("</body><html>");
		return responseHtml.toString();
	}
    
}

