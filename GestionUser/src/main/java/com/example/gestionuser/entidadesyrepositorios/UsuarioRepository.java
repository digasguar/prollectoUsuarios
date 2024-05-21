package com.example.gestionuser.entidadesyrepositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.gestionuser.exceptions.NotFoundException;

@Repository
public class UsuarioRepository {
	
	private ArrayList<Usuario> listaUsers;
	
	public UsuarioRepository() {
		 this.listaUsers = new ArrayList<>();
	}
	
	 public void addUsuario(Usuario usuario) {
		 listaUsers.add(usuario);
	    }

	    public ArrayList<Usuario> getUsuarios() {
	        return listaUsers;
	    }

	    public Usuario getUsuarioByEmail(String email) {
	        for (Usuario usuario : listaUsers) {
	            if (usuario.getEmail().equals(email)) {
	                return usuario;
	            }
	        }
	        return null;
	    }
	    
	    public ArrayList<Usuario> getUsuariosByName(String name) {
	    	
	    	ArrayList<Usuario> usuariosFiltrados=new ArrayList();
	    	
	        for (Usuario usuario : listaUsers) {
	            if (usuario.getNombre().equals(name)) {
	            	usuariosFiltrados.add(usuario);
	            }
	        }
	        return usuariosFiltrados;
	    }
	    
	    public Usuario getUsuarioByName(String name) {
	    	
	    	
	        for (Usuario usuario : listaUsers) {
	            if (usuario.getNombre().equals(name)) {
	            	return usuario;
	            }
	        }
	        return null;
	    }
	   

	    public void updateUsuario(Usuario usuario) {
	        Usuario foundUsuario = getUsuarioByEmail(usuario.getEmail());
	        if (foundUsuario != null) {
	            foundUsuario.setNombre(usuario.getNombre());
	            foundUsuario.setApellidos(usuario.getApellidos());
	            foundUsuario.setDni(usuario.getDni());
	            foundUsuario.setCodigoPostal(usuario.getCodigoPostal());
	            foundUsuario.setTelefonoMovil(usuario.getTelefonoMovil());
	            foundUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
	            foundUsuario.setPassword(usuario.getPassword());
	        }
	    }

	    public void deleteUsuario(String email) {
	        Usuario usuario = getUsuarioByEmail(email);
	        if (usuario != null) {
	        	listaUsers.remove(usuario);
	        }
	    }
	    
	    public List<Usuario> findAll() {
			return this.listaUsers;		
		}
	    
	    public List<Usuario> findAll(String userName) {
			List<Usuario> nombreUsuario = new ArrayList<>();
			
			for(Usuario t: this.listaUsers) {
				if (t.getNombre().equals(userName)) {
					nombreUsuario.add(t);
				}				
			}
			return nombreUsuario;
		}
	    
	    public List<Usuario> findAll(String userName,String email) {
			List<Usuario> nombreUsuario = new ArrayList<>();
			
			for(Usuario t: this.listaUsers) {
				if (t.getNombre().equals(userName) && t.getEmail().equals(email)) {
					nombreUsuario.add(t);
				}				
			}
			return nombreUsuario;
		}
	    
	    public void delete(Usuario usuario) throws NotFoundException {		
			this.listaUsers.remove(usuario);
			System.out.println("Borrada con exito!");
			mostrarUsuarios();
		}
	    
	    private void mostrarUsuarios() {
			for (Usuario usuario : listaUsers) {
				System.out.println(usuario);
			}		
		}

}