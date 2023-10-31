package Controller;

import DaoImpl.UsuarioDaoImpl;
import Model.Usuario;
import java.util.List;

public class UsuarioController {
	private UsuarioDaoImpl usuarioDaoImpl = null;
    
    public UsuarioController(){
        usuarioDaoImpl = new UsuarioDaoImpl();
    }
    
    public List<Usuario> listarUsuarios(){
    	List<Usuario> listarUsuarios = null;
    	listarUsuarios = usuarioDaoImpl.listarUsuario();
    	return listarUsuarios;
    }
    
    public Usuario validarLogin(String nombreUsuario, String clave) {
    	List<Usuario> usuarios = listarUsuarios();
    	
    	for(Usuario usuario : usuarios) { 
    		if(usuario.getNombre().equals(nombreUsuario) && usuario.getClave().equals(clave)) {
    			return usuario;
    		}    		
    	}
    	return null;
    }
}
