package DaoImpl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.CarreraDao;
import Dao.Conexion;
import Model.Carrera;

public class CarreraDaoImpl implements CarreraDao{

		private PreparedStatement statement = null;
	    private Connection conexion;
	    
	    public CarreraDaoImpl(){
	        this.conexion = Conexion.obtenerConexion();
	    }
	    
		@Override
	public List<Carrera> listarCarrera() {
		List<Carrera> listarCarrera = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM carrera";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				/*Obtenemos datos de la base de datos y los almacenamos en variables*/
				int id = resultSet.getInt("id");
				String nombre_carrera = resultSet.getString("nombre_carrera");
				
				
				Carrera carrera = new Carrera();
				carrera.setId(id);
				carrera.setNombre_carrera(nombre_carrera);
			
				listarCarrera.add(carrera);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listarCarrera;
	
	}

		@Override
		public Carrera obtenerCarreraPorNombre(String nombreCarrera) {
			try {
		        String consulta = "SELECT * FROM carrera WHERE nombre_carrera = ?";
		        statement = conexion.prepareStatement(consulta);
		        statement.setString(1, nombreCarrera); // Establece el valor del parámetro
		        ResultSet resultSet = statement.executeQuery();

		        if (resultSet.next()) {
		            Carrera carrera = new Carrera();
		            carrera.setId(resultSet.getInt("id"));
		            carrera.setNombre_carrera(resultSet.getString("nombre_carrera")); // Asigna el valor correcto
		            return carrera;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null; // En caso de error o si no se encuentra la categoría
		}

}
