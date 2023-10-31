package Controller;

import java.util.List;
import javax.swing.JOptionPane;

import DaoImpl.CategoriaDaoImpl;
import Model.Categoria;

public class CategoriaController {
	private CategoriaDaoImpl categoriaDaoImpl = null;
	 public CategoriaController(){
	    	categoriaDaoImpl = new CategoriaDaoImpl();
	    }
	 
	 public List<Categoria> listarCategoria(){
	    	List<Categoria> listarCategoria = null;
	    	listarCategoria = categoriaDaoImpl.listarCategoria();
	    	return listarCategoria;
	 }
	 
	 public int obtenerIdCategoriaPorNombre(String nombreCategoria) {
		    try {
		        Categoria categoria = categoriaDaoImpl.obtenerCategoriaPorNombre(nombreCategoria);

		        if (categoria != null) {
		            return categoria.getId();
		        } else {
		            JOptionPane.showMessageDialog(null, "La categoría no se encuentra en la base de datos.", "Categoría no encontrada", JOptionPane.WARNING_MESSAGE);
		            return -1;
		        }
		    } catch (Exception e) { 
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al obtener el ID de la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
		        return -1;
		    }
	 }
}
