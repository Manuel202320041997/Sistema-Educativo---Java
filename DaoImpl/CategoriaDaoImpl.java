package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CategoriaDao;
import Dao.Conexion;
import Model.Categoria;


public class CategoriaDaoImpl implements CategoriaDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public CategoriaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
public List<Categoria> listarCategoria() {
	List<Categoria> listarCategoria = new ArrayList<>();
	try {
		String consulta = "SELECT * FROM categoria";
		statement = conexion.prepareStatement(consulta);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			/*Obtenemos datos de la base de datos y los almacenamos en variables*/
			int id = resultSet.getInt("id");
			String nombre_categoria = resultSet.getString("nombre_categoria");
			
			
			Categoria categoria = new Categoria();
			categoria.setId(id);
			categoria.setNombre_categoria(nombre_categoria);
		
			listarCategoria.add(categoria);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	return listarCategoria;
}

	@Override
	public Categoria obtenerCategoriaPorNombre(String nombreCategoria) {
		try {
	        String consulta = "SELECT * FROM categoria WHERE nombre_categoria = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreCategoria); // Establece el valor del parámetro
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            Categoria categoria = new Categoria();
	            categoria.setId(resultSet.getInt("id"));
	            categoria.setNombre_categoria(resultSet.getString("nombre_categoria")); // Asigna el valor correcto
	            return categoria;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}
}
