package Dao;

import java.util.List;
import Model.Usuario;
import DaoImpl.UsuarioDaoImpl;

public interface UsuarioDao {
	public List<Usuario> listarUsuario();
}
