package Dao;

import java.util.List;

import Model.Categoria;

public interface CategoriaDao {
	public List<Categoria> listarCategoria();
	
	public Categoria obtenerCategoriaPorNombre (String nombreCategoria);
}
