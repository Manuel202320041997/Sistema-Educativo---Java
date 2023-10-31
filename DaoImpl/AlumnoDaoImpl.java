package DaoImpl;

import java.util.List;

import Dao.AlumnoDao;
import Model.Alumno;
import Dao.Conexion;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDaoImpl implements AlumnoDao {

	private PreparedStatement statement = null;
    private Connection conexion;
    
    public AlumnoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	
	
	@Override
	public List<Alumno> listarAlumno() {
		List<Alumno> listarAlumno = new ArrayList<>();
	    try {
	        String consulta = "SELECT alumno.id, alumno.nombres, alumno.correo, carrera.nombre_carrera AS carrera, categoria.nombre_categoria AS categoria, semestre.nombre_semestre AS semestre, alumno.estado	FROM alumno LEFT JOIN carrera ON alumno.carrera_id = carrera.id LEFT JOIN categoria ON alumno.categoria_id = categoria.id	LEFT JOIN semestre ON alumno.semestre_id = semestre.id";
	        statement = conexion.prepareStatement(consulta);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nombres = resultSet.getString("nombres");
	            String correo = resultSet.getString("correo");
	            String carrera = resultSet.getString("carrera");
	            String categoria = resultSet.getString("categoria");
	            String semestre = resultSet.getString("semestre");
	            boolean estado = resultSet.getBoolean("estado");

	            Alumno alumno = new Alumno();
	            alumno.setId(id);
	            alumno.setNombres(nombres);
	            alumno.setCorreo(correo);
	            alumno.setCarrera(carrera);
	            alumno.setCategoria(categoria);
	            alumno.setSemestre(semestre);
	            alumno.setEstado(estado);

	            listarAlumno.add(alumno);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listarAlumno;
	}


	@Override
	public void registrarAlumno(Alumno alumno) {
		  try {
			  	int idCarrera = Integer.parseInt(alumno.getCarrera());
		        int idCategoria = Integer.parseInt(alumno.getCategoria());
		        int idSemestre = Integer.parseInt(alumno.getSemestre());
			  
			  
		        String consulta = "INSERT INTO alumno (nombres, correo, carrera_id, categoria_id, semestre_id) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);
		        
		        statement.setString(1, alumno.getNombres());
		        statement.setString(2, alumno.getCorreo());
		        statement.setInt(3, idCarrera);
		        statement.setInt(4, idCategoria);
		        statement.setInt(5, idSemestre);
		        
		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();        
		    }		
	}

	@Override
	public void eliminarAlumno(int id) {
	    try {
	        String consulta = "UPDATE alumno SET estado = 0 WHERE id = ?";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, id);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
	}


	@Override
	public Alumno obtenerAlumnoPorId(int idAlumno) {
		try {
	        String consulta = "SELECT alumno.id, alumno.nombres, alumno.correo, carrera.nombre_carrera AS carrera, categoria.nombre_categoria AS categoria, semestre.nombre_semestre AS semestre, alumno.estado FROM alumno LEFT JOIN carrera ON alumno.carrera_id = carrera.id LEFT JOIN categoria ON alumno.categoria_id = categoria.id LEFT JOIN semestre ON alumno.semestre_id = semestre.id WHERE alumno.id = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idAlumno);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nombres = resultSet.getString("nombres");
	            String correo = resultSet.getString("correo");
	            String carrera = resultSet.getString("carrera");
	            String categoria = resultSet.getString("categoria");
	            String semestre = resultSet.getString("semestre");
	            boolean estado = resultSet.getBoolean("estado");

	            Alumno alumno = new Alumno();
	            alumno.setId(id);
	            alumno.setNombres(nombres);
	            alumno.setCorreo(correo);
	            alumno.setCarrera(carrera);
	            alumno.setCategoria(categoria);
	            alumno.setSemestre(semestre);
	            alumno.setEstado(estado);

	            return alumno;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
		
	}
}
