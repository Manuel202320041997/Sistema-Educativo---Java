package Dao;

import java.util.List;

import Model.Carrera;
import Model.Categoria;

public interface CarreraDao {
	public List<Carrera> listarCarrera();
	
	public Carrera obtenerCarreraPorNombre (String nombreCarrera);
}
