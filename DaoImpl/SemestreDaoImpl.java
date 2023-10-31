package DaoImpl;

import java.util.List;
import Dao.SemestreDao;
import Model.Semestre;
import Dao.Conexion;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SemestreDaoImpl implements SemestreDao{
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public SemestreDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
public List<Semestre> listarSemestre() {
	List<Semestre> listarSemestre = new ArrayList<>();
	try {
		String consulta = "SELECT * FROM semestre";
		statement = conexion.prepareStatement(consulta);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			/*Obtenemos datos de la base de datos y los almacenamos en variables*/
			int id = resultSet.getInt("id");
			String nombre_semestre = resultSet.getString("nombre_semestre");
			
			
			Semestre semestre = new Semestre();
			semestre.setId(id);
			semestre.setNombre_semestre(nombre_semestre);
		
			listarSemestre.add(semestre);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	return listarSemestre;

}

	@Override
	public Semestre obtenerSemestrePorNombre(String nombreSemestre) {
		try {
	        String consulta = "SELECT * FROM semestre WHERE nombre_semestre = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreSemestre); // Establece el valor del parámetro
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	        	Semestre semestre = new Semestre();
	        	semestre.setId(resultSet.getInt("id"));
	        	semestre.setNombre_semestre(resultSet.getString("nombre_semestre")); // Asigna el valor correcto
	            return semestre;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public List<String> obtenerNombresSemestres() {
		List<String> nombresSemestres = new ArrayList<>();
	    try {
	        String consulta = "SELECT nombre_semestre FROM semestre";
	        statement = conexion.prepareStatement(consulta);
	        ResultSet resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	            // Obtenemos el nombre del semestre de la base de datos y lo almacenamos en la lista
	            String nombre_semestre = resultSet.getString("nombre_semestre");
	            nombresSemestres.add(nombre_semestre);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return nombresSemestres;
	    }

	
}
